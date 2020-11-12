package edu.unl.cse.soft160.a4.sepsis;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

// Harry Do

public class SepsisDeterminationAlgorithm {
	public static Boolean isNotAdult(Patient patient) {
		LocalDate birthDate = patient.getBirthDate();
		LocalDate currentDate = LocalDate.now();
		Period diff = Period.between(birthDate, currentDate);
		return (diff.getYears() < 18);
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

	public static boolean organDysfunction(Patient patient) {
		Observation currentObservation = patient.getCurrentObservation();
		Observation lastObservation = patient.getLastObservation();
		Concept currentconcept = currentObservation.getConcept();
		Concept lastconcept = lastObservation.getConcept();
		Integer SOFAScoreChange = Math.abs(computeSOFAScore(currentconcept) - computeSOFAScore(lastconcept));
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

	public static boolean isSepsis(Patient patient, Concept concept) {
		if (organDysfunction(patient) && isInfection(concept) && concept.getIsImmunocompromised()) {
			return true;
		} else {
			return false;
		}
	}

	public static SepsisDetermination analyze(Patient patient) {
		try {
			Observation observation = patient.getCurrentObservation();
			Concept concept = observation.getConcept();
			concept.setMap();
			if (isNotAdult(patient)) {
				return SepsisDetermination.NON_ADULT;
			} else if (concept.getIsPregnant()) {
				return SepsisDetermination.PREGNANT_PATIENT;
			} else if (decideSIRSCriteria(concept)) {
				if (concept.getIsResponsive()) {
					if (!isUnStable(concept)) {
						if (!isSepsis(patient, concept)) {
							return SepsisDetermination.CONTINUE_MONITORING;
						}
					}
					if (concept.getMap() < 65) {
						return SepsisDetermination.SEPTIC_SHOCK;
					} else {
						return SepsisDetermination.SEPSIS;
					}

				} else {
					if (concept.getIsInpatientStatus())
						return SepsisDetermination.CODE_BLUE;
				}
			}
			return SepsisDetermination.INDETERMINATE;
		} catch (Exception e) {
			return SepsisDetermination.INDETERMINATE;
		}
	}
}