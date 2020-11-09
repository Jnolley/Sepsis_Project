package edu.unl.cse.soft160.a4.sepsis;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

// Harry Do

public class SepsisDeterminationAlgorithm {
	public static Boolean isNotAdult(Patient patient) {
		LocalDate birthDate = LocalDate.of(patient.getBirthYear(), patient.getBirthMonth(), patient.getBirthDay());
		LocalDate currentDate = LocalDate.now();
		Period diff = Period.between(birthDate, currentDate);
		return (diff.getYears() < 18);
	}

	public static boolean decideSIRSCriteria(Observation observation) {
		if ((observation.getTemperature() < 36 || observation.getTemperature() > 38.5)
				&& observation.getHeartRate() >= 110) {
			return true;
		}
		if ((observation.getTemperature() < 36 || observation.getTemperature() > 38.5)
				&& observation.getRespiratoryRate() > 24) {
			return true;
		}
		if ((observation.getTemperature() < 36 || observation.getTemperature() > 38.5)
				&& (observation.getWBCCount() < 3 || observation.getWBCCount() >= 15)) {
			return true;
		}
		if (observation.getHeartRate() >= 110 && observation.getRespiratoryRate() > 24) {
			return true;
		}
		if (observation.getHeartRate() >= 110 && (observation.getWBCCount() < 3 || observation.getWBCCount() >= 15)) {
			return true;
		}
		if (observation.getRespiratoryRate() > 24
				&& (observation.getWBCCount() < 3 || observation.getWBCCount() >= 15)) {
			return true;
		}
		return false;
	}

	// Determine if the patient is Unstable
	public static boolean isUnStable(Observation observation) {
		if (observation.getSystolicBloodPressure() < 90 || observation.getHeartRate() > 150
				|| observation.getNeedForVasopressorSupport() || observation.getCardiacArrhythmia()) {
			return true;
		}
		return false;
	}

	// Determine the SOFAScore from Appendix B
	public static Integer computeSOFAScore(Observation observation) {
		int scoreRespiratoryPaOxyFiOxy = 0;
		int scoreCoagulation = 0;
		int scoreLiverBilirubin = 0;
		int scoreCardiovascularHypotension = 0;
		int scoreGlasgowComaScale = 0;
		int scoreCreatinineorUrine = 0;
		observation.setMap();
		if (observation.getRespiratoryPaOxyFiOxy() >= 400) {
			scoreRespiratoryPaOxyFiOxy = 0;
		} else if (observation.getRespiratoryPaOxyFiOxy() >= 300 && observation.getRespiratoryPaOxyFiOxy() < 400) {
			scoreRespiratoryPaOxyFiOxy = 1;
		} else if (observation.getRespiratoryPaOxyFiOxy() >= 200 && observation.getRespiratoryPaOxyFiOxy() < 300) {
			scoreRespiratoryPaOxyFiOxy = 2;
		} else if (observation.getRespiratoryPaOxyFiOxy() >= 100 && observation.getRespiratoryPaOxyFiOxy() < 200) {
			scoreRespiratoryPaOxyFiOxy = 3;
		} else {
			scoreRespiratoryPaOxyFiOxy = 4;
		}
		if (observation.getCoagulationPlatelets() >= 150) {
			scoreCoagulation = 0;
		} else if (observation.getCoagulationPlatelets() >= 100 && observation.getCoagulationPlatelets() < 150) {
			scoreCoagulation = 1;
		} else if (observation.getCoagulationPlatelets() >= 50 && observation.getCoagulationPlatelets() < 100) {
			scoreCoagulation = 2;
		} else if (observation.getCoagulationPlatelets() >= 20 && observation.getCoagulationPlatelets() < 50) {
			scoreCoagulation = 3;
		} else {
			scoreCoagulation = 4;
		}
		if (observation.getLiverBilirubin() < 1.2) {
			scoreLiverBilirubin = 0;
		} else if (observation.getLiverBilirubin() >= 1.2 && observation.getLiverBilirubin() <= 1.9) {
			scoreLiverBilirubin = 1;
		} else if (observation.getLiverBilirubin() >= 2 && observation.getLiverBilirubin() <= 5.9) {
			scoreLiverBilirubin = 2;
		} else if (observation.getLiverBilirubin() >= 6 && observation.getLiverBilirubin() <= 11.9) {
			scoreLiverBilirubin = 3;
		} else {
			scoreLiverBilirubin = 4;
		}
		if (observation.getMap() >= 70) {
			scoreCardiovascularHypotension = 0;
		} else {
			scoreCardiovascularHypotension = 1;
		}
		if (observation.getDopamine() < 5 || observation.getAnyDoputamine()) {
			scoreCardiovascularHypotension = 2;
		} else if ((observation.getDopamine() >= 5.1 && observation.getDopamine() <= 15)
				|| (observation.getEpinephrine() <= 0.1) || (observation.getNorepinephrine() <= 0.1)) {
			scoreCardiovascularHypotension = 3;
		} else {
			scoreCardiovascularHypotension = 4;
		}
		if (observation.getGlasgowComaScale() == 15) {
			scoreGlasgowComaScale = 0;
		} else if (observation.getGlasgowComaScale() == 13 || observation.getGlasgowComaScale() == 14) {
			scoreGlasgowComaScale = 1;
		} else if (observation.getGlasgowComaScale() >= 10 && observation.getGlasgowComaScale() <= 12) {
			scoreGlasgowComaScale = 2;
		} else if (observation.getGlasgowComaScale() >= 6 && observation.getGlasgowComaScale() <= 9) {
			scoreGlasgowComaScale = 3;
		} else if (observation.getGlasgowComaScale() < 6) {
			scoreGlasgowComaScale = 4;
		}
		if (observation.getRenalCreatinine() < 1.2) {
			scoreCreatinineorUrine = 0;
		} else if (observation.getRenalCreatinine() >= 1.2 && observation.getRenalCreatinine() <= 1.9) {
			scoreCreatinineorUrine = 1;
		} else if (observation.getRenalCreatinine() >= 2 && observation.getRenalCreatinine() <= 3.4) {
			scoreCreatinineorUrine = 2;
		}
		if ((observation.getRenalCreatinine() >= 3.4 && observation.getRenalCreatinine() < 4.9)
				|| (observation.getUrineOutput() < 500) && observation.getUrineOutput() >= 200) {
			scoreCreatinineorUrine = 3;
		} else if (observation.getRenalCreatinine() >= 5 || observation.getUrineOutput() < 200) {
			scoreCreatinineorUrine = 4;
		}
		return Math.min(scoreRespiratoryPaOxyFiOxy, Math.min(scoreCoagulation, Math.min(scoreLiverBilirubin,
				Math.min(scoreCardiovascularHypotension, Math.min(scoreGlasgowComaScale, scoreCreatinineorUrine)))));
	}

	public static boolean organDysfunction(Patient patient) {
		Observation currentObservation = patient.getCurrentObservation();
		Observation lastObservation = patient.getLastObservation();

		Integer SOFAScoreChange = Math.abs(computeSOFAScore(currentObservation) - computeSOFAScore(lastObservation));
		if (SOFAScoreChange >= 2) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isInfection(Observation observation) {
		if (observation.getInfectionSkinWound() || observation.getInfectionInvasiveDevice()
				|| observation.getInfectionRecentSurgicalProcedure()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isSepsis(Patient patient, Observation observation) {
		if (organDysfunction(patient) && isInfection(observation) && observation.getIsImmunocompromised()) {
			return true;
		} else {
			return false;
		}
	}

	public static SepsisDetermination analyze(Patient patient) {
		try {
			Observation observation = patient.getCurrentObservation();
			observation.setMap();
			if (isNotAdult(patient)) {
				return SepsisDetermination.NON_ADULT;
			} else if (observation.getIsPregnant()) {
				return SepsisDetermination.PREGNANT_PATIENT;
			} else if (decideSIRSCriteria(observation)) {
				if (observation.getIsResponsive()) {
					if (!isUnStable(observation)) {
						if (!isSepsis(patient, observation)) {
							return SepsisDetermination.CONTINUE_MONITORING;
						}
					}
					if (observation.getMap() < 65) {
						return SepsisDetermination.SEPTIC_SHOCK;
					} else {
						return SepsisDetermination.SEPSIS;
					}

				} else {
					if (observation.getIsInpatientStatus())
						return SepsisDetermination.CODE_BLUE;
				}
			}
			return SepsisDetermination.INDETERMINATE;
		} catch (Exception e) {
			return SepsisDetermination.INDETERMINATE;
		}
	}
}