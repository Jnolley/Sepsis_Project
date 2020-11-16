package edu.unl.cse.soft160.a4.sepsis;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import edu.unl.cse.soft160.rest_connector.connector.ObservationRecord;
import edu.unl.cse.soft160.rest_connector.connector.OpenMRSConnection;
import edu.unl.cse.soft160.rest_connector.connector.PatientRecord;

// Harry Do

public class SepsisDeterminationAlgorithm {
	public static Set<Observation> getCurrentObservationList(Set<Observation> observationList) {
		Set<Observation> currentObservationList = new HashSet<Observation>();
		for (Observation observation : observationList) {
			LocalDate timestamp = observation.getTimestamp().toLocalDate();
			Period time = Period.between(timestamp, LocalDate.now());
			if (time.getDays() <= 1 && !observation.getConcept().equals("Baseline Glasgow Coma Scale")) {
				currentObservationList.add(observation);
			}
		}
		return currentObservationList;
	}

	public static Set<Observation> getBaselineObservationList(Set<Observation> observationList) {
		Set<Observation> baselineObservationList = new HashSet<Observation>();
		for (Observation observation : observationList) {
			LocalDate timestamp = observation.getTimestamp().toLocalDate();
			Period time = Period.between(timestamp, LocalDate.now());
			if (time.getDays() > 1 && time.getDays() <= 2
					&& !observation.getConcept().equals("Current Glasgow Coma Scale")) {
				baselineObservationList.add(observation);
			}
		}
		return baselineObservationList;
	}

	public static Concept setUpConceptList(Set<Observation> observationList) {
		Concept concepts = new Concept();
		for (Observation observation : observationList) {
			if (observation.getConcept().equals("Is Pregnant")) {
				concepts.setIsPregnant(observation.getBMeasurement());
			} else if (observation.getConcept().equals("Temperature")) {
				concepts.setTemperature(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Heart rate")) {
				concepts.setHeartRate(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Respiratory rate")) {
				concepts.setRespiratoryRate(observation.getDMeasurement());
			} else if (observation.getConcept().equals("WBCCount")) {
				concepts.setWBCCount(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Systolic blood pressure")) {
				concepts.setSystolicBloodPressure(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Diastolic blood pressure")) {
				concepts.setDiastolicBloodPressure(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Is Inpatient Status")) {
				concepts.setIsInpatientStatus(observation.getBMeasurement());
			} else if (observation.getConcept().equals("Need For Vasopressor Support")) {
				concepts.setNeedForVasopressorSupport(observation.getBMeasurement());
			} else if (observation.getConcept().equals("Is responsive")) {
				concepts.setIsResponsive(observation.getBMeasurement());
			} else if (observation.getConcept().equals("Cardiac arrhythmia")) {
				concepts.setCardiacArrhythmia(observation.getBMeasurement());
			} else if (observation.getConcept().equals("Decline in baseline mental status")) {
				concepts.setDeclineInBaselineMentalStatus(observation.getBMeasurement());
			} else if (observation.getConcept().equals("Infection Skin Wound")) {
				concepts.setInfectionSkinWound(observation.getBMeasurement());
			} else if (observation.getConcept().equals("Infection Invasive Device")) {
				concepts.setInfectionInvasiveDevice(observation.getBMeasurement());
			} else if (observation.getConcept().equals("Infection Recent Surgical Procedure")) {
				concepts.setInfectionRecentSurgicalProcedure(observation.getBMeasurement());
			} else if (observation.getConcept().equals("is Immunocompromised")) {
				concepts.setIsImmunocompromised(observation.getBMeasurement());
			} else if (observation.getConcept().equals("Respiratory PaOxy/FiOxy")) {
				concepts.setRespiratoryPaOxyFiOxy(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Coagulation Platelets")) {
				concepts.setCoagulationPlatelets(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Liver Bilirubin")) {
				concepts.setLiverBilirubin(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Dopamine")) {
				concepts.setDopamine(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Using Any Doputamine?")) {
				concepts.setAnyDoputamine(observation.getBMeasurement());
			} else if (observation.getConcept().equals("Epinephrine")) {
				concepts.setEpinephrine(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Norepinephrine")) {
				concepts.setNorepinephrine(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Current Glasgow Coma Scale")) {
				concepts.setGlasgowComaScale(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Baseline Glasgow Coma Scale")) {
				concepts.setGlasgowComaScale(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Creatinine in Blood (mg/dL)")) {
				concepts.setRenalCreatinine(observation.getDMeasurement());
			}
		}
		return concepts;
	}

	public static Boolean isNotAdult(PatientRecord patientRecord) {
		LocalDateTime now = LocalDateTime.now();
		Period age = Period.between(patientRecord.getBirthDate(), now.toLocalDate());
		return (age.getYears() < 18);
	}

	public static boolean decideSIRSCriteria(Concept concept) {
		if ((concept.getTemperature() < 36 || concept.getTemperature() > 38.5) && concept.getHeartRate() >= 110) {
			return true;
		}
		if ((concept.getTemperature() < 36 || concept.getTemperature() > 38.5) && concept.getRespiratoryRate() > 24) {
			return true;
		}
		if ((concept.getTemperature() < 36 || concept.getTemperature() > 38.5)
				&& (concept.getWBCCount() < 3 || concept.getWBCCount() >= 15)) {
			return true;
		}
		if (concept.getHeartRate() >= 110 && concept.getRespiratoryRate() > 24) {
			return true;
		}
		if (concept.getHeartRate() >= 110 && (concept.getWBCCount() < 3 || concept.getWBCCount() >= 15)) {
			return true;
		}
		if (concept.getRespiratoryRate() > 24 && (concept.getWBCCount() < 3 || concept.getWBCCount() >= 15)) {
			return true;
		}
		return false;
	}

	// Determine if the patient is Unstable
	public static boolean isUnStable(Concept concept) {
		if (concept.getSystolicBloodPressure() < 90 || concept.getHeartRate() > 150
				|| concept.getNeedForVasopressorSupport() || concept.getCardiacArrhythmia()) {
			return true;
		}
		return false;
	}

	// Determine the SOFAScore from Appendix B
	public static Integer computeSOFAScore(Concept concept) {
		int scoreRespiratoryPaOxyFiOxy = 0;
		int scoreCoagulation = 0;
		int scoreLiverBilirubin = 0;
		int scoreCardiovascularHypotension = 0;
		int scoreGlasgowComaScale = 0;
		int scoreCreatinineorUrine = 0;
		concept.setMap();
		if (concept.getRespiratoryPaOxyFiOxy() >= 400) {
			scoreRespiratoryPaOxyFiOxy = 0;
		} else if (concept.getRespiratoryPaOxyFiOxy() >= 300 && concept.getRespiratoryPaOxyFiOxy() < 400) {
			scoreRespiratoryPaOxyFiOxy = 1;
		} else if (concept.getRespiratoryPaOxyFiOxy() >= 200 && concept.getRespiratoryPaOxyFiOxy() < 300) {
			scoreRespiratoryPaOxyFiOxy = 2;
		} else if (concept.getRespiratoryPaOxyFiOxy() >= 100 && concept.getRespiratoryPaOxyFiOxy() < 200) {
			scoreRespiratoryPaOxyFiOxy = 3;
		} else {
			scoreRespiratoryPaOxyFiOxy = 4;
		}
		if (concept.getCoagulationPlatelets() >= 150) {
			scoreCoagulation = 0;
		} else if (concept.getCoagulationPlatelets() >= 100 && concept.getCoagulationPlatelets() < 150) {
			scoreCoagulation = 1;
		} else if (concept.getCoagulationPlatelets() >= 50 && concept.getCoagulationPlatelets() < 100) {
			scoreCoagulation = 2;
		} else if (concept.getCoagulationPlatelets() >= 20 && concept.getCoagulationPlatelets() < 50) {
			scoreCoagulation = 3;
		} else {
			scoreCoagulation = 4;
		}
		if (concept.getLiverBilirubin() < 1.2) {
			scoreLiverBilirubin = 0;
		} else if (concept.getLiverBilirubin() >= 1.2 && concept.getLiverBilirubin() <= 1.9) {
			scoreLiverBilirubin = 1;
		} else if (concept.getLiverBilirubin() >= 2 && concept.getLiverBilirubin() <= 5.9) {
			scoreLiverBilirubin = 2;
		} else if (concept.getLiverBilirubin() >= 6 && concept.getLiverBilirubin() <= 11.9) {
			scoreLiverBilirubin = 3;
		} else {
			scoreLiverBilirubin = 4;
		}
		if (concept.getMap() >= 70) {
			scoreCardiovascularHypotension = 0;
		} else {
			scoreCardiovascularHypotension = 1;
		}
		if (concept.getDopamine() < 5 || concept.getAnyDoputamine()) {
			scoreCardiovascularHypotension = 2;
		} else if ((concept.getDopamine() >= 5.1 && concept.getDopamine() <= 15) || (concept.getEpinephrine() <= 0.1)
				|| (concept.getNorepinephrine() <= 0.1)) {
			scoreCardiovascularHypotension = 3;
		} else {
			scoreCardiovascularHypotension = 4;
		}
		if (concept.getGlasgowComaScale() == 15) {
			scoreGlasgowComaScale = 0;
		} else if (concept.getGlasgowComaScale() == 13 || concept.getGlasgowComaScale() == 14) {
			scoreGlasgowComaScale = 1;
		} else if (concept.getGlasgowComaScale() >= 10 && concept.getGlasgowComaScale() <= 12) {
			scoreGlasgowComaScale = 2;
		} else if (concept.getGlasgowComaScale() >= 6 && concept.getGlasgowComaScale() <= 9) {
			scoreGlasgowComaScale = 3;
		} else if (concept.getGlasgowComaScale() < 6) {
			scoreGlasgowComaScale = 4;
		}
		if (concept.getRenalCreatinine() < 1.2) {
			scoreCreatinineorUrine = 0;
		} else if (concept.getRenalCreatinine() >= 1.2 && concept.getRenalCreatinine() <= 1.9) {
			scoreCreatinineorUrine = 1;
		} else if (concept.getRenalCreatinine() >= 2 && concept.getRenalCreatinine() <= 3.4) {
			scoreCreatinineorUrine = 2;
		}
		if ((concept.getRenalCreatinine() >= 3.4 && concept.getRenalCreatinine() < 4.9)
				|| (concept.getUrineOutput() < 500) && concept.getUrineOutput() >= 200) {
			scoreCreatinineorUrine = 3;
		} else if (concept.getRenalCreatinine() >= 5 || concept.getUrineOutput() < 200) {
			scoreCreatinineorUrine = 4;
		}
		return Math.min(scoreRespiratoryPaOxyFiOxy, Math.min(scoreCoagulation, Math.min(scoreLiverBilirubin,
				Math.min(scoreCardiovascularHypotension, Math.min(scoreGlasgowComaScale, scoreCreatinineorUrine)))));
	}

	public static boolean organDysfunction(Concept currentconcept, Concept baselineConcepts) {
		Integer SOFAScoreChange = Math.abs(computeSOFAScore(currentconcept) - computeSOFAScore(baselineConcepts));
		if (SOFAScoreChange >= 2) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isInfection(Concept concept) {
		if (concept.getInfectionSkinWound() || concept.getInfectionInvasiveDevice()
				|| concept.getInfectionRecentSurgicalProcedure()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isSepsis(Concept currentConcept, Concept baselineConcepts) {
		if (organDysfunction(currentConcept, baselineConcepts) && isInfection(currentConcept)
				&& currentConcept.getIsImmunocompromised()) {
			return true;
		} else {
			return false;
		}
	}

	public static SepsisDetermination analyze(Set<Observation> observationList, PatientRecord patient) {
		try {
			Set<Observation> currentObservationList = getCurrentObservationList(observationList);
			Set<Observation> baselineObservationList = getBaselineObservationList(observationList);
			Concept currentConcepts = setUpConceptList(currentObservationList);
			Concept baselineConcepts = setUpConceptList(baselineObservationList);
			currentConcepts.setMap();
			if (isNotAdult(patient)) {
				return SepsisDetermination.NON_ADULT;
			} else if (currentConcepts.getIsPregnant()) {
				return SepsisDetermination.PREGNANT_PATIENT;
			} else if (decideSIRSCriteria(currentConcepts)) {
				if (currentConcepts.getIsResponsive()) {
					if (!isUnStable(currentConcepts)) {
						if (!isSepsis(currentConcepts, baselineConcepts)) {
							return SepsisDetermination.CONTINUE_MONITORING;
						}
					}
					if (currentConcepts.getMap() < 65) {
						return SepsisDetermination.SEPTIC_SHOCK;
					} else {
						return SepsisDetermination.SEPSIS;
					}
				} else if (currentConcepts.getIsInpatientStatus()) {
					return SepsisDetermination.CODE_BLUE;

				}
			}
			return SepsisDetermination.INDETERMINATE;

		} catch (NullPointerException e) {
			return SepsisDetermination.INDETERMINATE;
		}
	}
}
