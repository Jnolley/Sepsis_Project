package edu.unl.cse.soft160.a4.sepsis;

import static javax.swing.JOptionPane.showInputDialog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Set;
import java.util.HashSet;

import javax.swing.JOptionPane;

import edu.unl.cse.soft160.rest_connector.connector.ObservationRecord;
import edu.unl.cse.soft160.rest_connector.connector.OpenMRSConnection;
import edu.unl.cse.soft160.rest_connector.connector.PatientRecord;

public class SepsisDeterminationApp {
	public static Boolean toBoolean(String answer) {
		if (answer.equals("Y")) {
			return true;
		} else if (answer.equals("N")) {
			return false;
		} else
			return null;
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void setUpObservationList(Set<ObservationRecord> observationRecordList,
			Set<Observation> currentObservationList, Set<Observation> baselineObservationList) {
		for (ObservationRecord observationRecord : observationRecordList) {
			if (observationRecord.getConcept().equals("Temperature (C)")) {
				Observation temperature = new Observation(observationRecord.getTimestamp(), "Temperature",
						observationRecord.getMeasurement());
				categorizeObservationList(currentObservationList, baselineObservationList, temperature);
			} else if (observationRecord.getConcept().equals("Diastolic blood pressure")) {
				Observation diastolicBloodPressure = new Observation(observationRecord.getTimestamp(),
						"Diastolic blood pressure", observationRecord.getMeasurement());
				categorizeObservationList(currentObservationList, baselineObservationList, diastolicBloodPressure);
			} else if (observationRecord.getConcept().equals("Leukocytes (#/µL)")) {
				Observation wbcCount = new Observation(observationRecord.getTimestamp(), "WBCCount",
						observationRecord.getMeasurement());
				categorizeObservationList(currentObservationList, baselineObservationList, wbcCount);
			} else if (observationRecord.getConcept().equals("Pulse")) {
				Observation heartRate = new Observation(observationRecord.getTimestamp(), "Heart rate",
						observationRecord.getMeasurement());
				categorizeObservationList(currentObservationList, baselineObservationList, heartRate);
			} else if (observationRecord.getConcept().equals("Systolic blood pressure")) {
				Observation systolicBloodPressure = new Observation(observationRecord.getTimestamp(),
						"Systolic blood pressure", observationRecord.getMeasurement());
				categorizeObservationList(currentObservationList, baselineObservationList, systolicBloodPressure);
			} else if (observationRecord.getConcept().equals("Platelets (#/µL)")) {
				Observation coagulationPlatelets = new Observation(observationRecord.getTimestamp(),
						"Coagulation Platelets", observationRecord.getMeasurement());
				categorizeObservationList(currentObservationList, baselineObservationList, coagulationPlatelets);
			} else if (observationRecord.getConcept().equals("Bilirubin Direct (mg/dL)")) {
				Observation liverBilirubin = new Observation(observationRecord.getTimestamp(), "Liver Bilirubin",
						observationRecord.getMeasurement());
				categorizeObservationList(currentObservationList, baselineObservationList, liverBilirubin);
			} else if (observationRecord.getConcept().equals("Creatinine in Blood (mg/dL)")) {
				Observation creatinineInBlood = new Observation(observationRecord.getTimestamp(),
						"Creatinine in blood (mg/dL)", observationRecord.getMeasurement());
				categorizeObservationList(currentObservationList, baselineObservationList, creatinineInBlood);
			} else if (observationRecord.getConcept().equals("Respiratory rate")) {
				Observation respiratoryRate = new Observation(observationRecord.getTimestamp(), "Respiratory rate",
						observationRecord.getMeasurement());
				categorizeObservationList(currentObservationList, baselineObservationList, respiratoryRate);
			}
		}
		String isPregnant = showInputDialog(null, "Is the patient pregnant? (Y/N): ");
		while (!isPregnant.equals("Y") && !isPregnant.equals("N")) {
			isPregnant = showInputDialog(null, "Is the patient pregnant? (Y/N): ");
		}
		Observation isPregnant1 = new Observation(LocalDateTime.now(), "Is Pregnant", toBoolean(isPregnant));
		currentObservationList.add(isPregnant1);
		String needForVasopressorSupport = showInputDialog(null,
				"Does the patient need for vasopressor support?(Y/N): ");
		while (!needForVasopressorSupport.equals("Y") && !needForVasopressorSupport.equals("N")) {
			needForVasopressorSupport = showInputDialog(null, "Does the patient need for vasopressor support?(Y/N): ");
		}
		Observation needForVasopressorSupport1 = new Observation(LocalDateTime.now(), "Need For Vasopressor Support",
				toBoolean(needForVasopressorSupport));
		currentObservationList.add(needForVasopressorSupport1);
		String isInpatientStatus = showInputDialog(null, "Is the patient's status inpatient status?(Y/N): ");
		while (!isInpatientStatus.equals("Y") && !isInpatientStatus.equals("N")) {
			isInpatientStatus = showInputDialog(null, "Is the patient's status inpatient status?(Y/N): ");
		}
		Observation isInpatientStatus1 = new Observation(LocalDateTime.now(), "Is Inpatient Status",
				toBoolean(isInpatientStatus));
		currentObservationList.add(isInpatientStatus1);
		String isResponsive = showInputDialog(null, "Is the patient responsive?(Y/N): ");
		while (!isResponsive.equals("Y") && !isResponsive.equals("N")) {
			isResponsive = showInputDialog(null, "Is the patient responsive?(Y/N): ");
		}
		Observation isResponsive1 = new Observation(LocalDateTime.now(), "Is responsive", toBoolean(isResponsive));
		currentObservationList.add(isResponsive1);
		String cardiacArrhythmia = showInputDialog(null, "Does the patient have cardiac arrhythmia?(Y/N): ");
		while (!cardiacArrhythmia.equals("Y") && !cardiacArrhythmia.equals("N")) {
			cardiacArrhythmia = showInputDialog(null, "Does the patient have cardiac arrhythmia?(Y/N): ");
		}
		Observation cardiacArrhythmia1 = new Observation(LocalDateTime.now(), "Cardiac arrhythmia",
				toBoolean(cardiacArrhythmia));
		currentObservationList.add(cardiacArrhythmia1);
		String declineInBaselineMentalStatus = showInputDialog(null,
				"Does the patient have decline in baseline mental status?(Y/N): ");
		while (!declineInBaselineMentalStatus.equals("Y") && !declineInBaselineMentalStatus.equals("N")) {
			declineInBaselineMentalStatus = showInputDialog(null,
					"Does the patient have decline in baseline mental status?(Y/N): ");
		}
		Observation declineInBaselineMentalStatus1 = new Observation(LocalDateTime.now(),
				"Decline in baseline mental status", toBoolean(declineInBaselineMentalStatus));
		currentObservationList.add(declineInBaselineMentalStatus1);
		String infectionSkinWound = showInputDialog(null, "Does the patient has infection skin wound?(Y/N): ");
		while (!infectionSkinWound.equals("Y") && !infectionSkinWound.equals("N")) {
			infectionSkinWound = showInputDialog(null, "Does the patient has infection skin wound?(Y/N): ");
		}
		Observation infectionSkinWound1 = new Observation(LocalDateTime.now(), "Infection Skin Wound",
				toBoolean(infectionSkinWound));
		currentObservationList.add(infectionSkinWound1);
		String infectionInvasiveDevice = showInputDialog(null,
				"Does the patient has infection invasive device?(Y/N): ");
		while (!infectionInvasiveDevice.equals("Y") && !infectionInvasiveDevice.equals("N")) {
			infectionInvasiveDevice = showInputDialog(null, "Does the patient has infection invasive device?(Y/N): ");
		}
		Observation infectionInvasiveDevice1 = new Observation(LocalDateTime.now(), "Infection Invasive Device",
				toBoolean(infectionInvasiveDevice));
		currentObservationList.add(infectionInvasiveDevice1);
		String infectionRecentSurgicalProcedure = showInputDialog(null,
				"Does the patient has infection of recent surgical procedure?(Y/N): ");
		while (!infectionRecentSurgicalProcedure.equals("Y") && !infectionRecentSurgicalProcedure.equals("N")) {
			infectionRecentSurgicalProcedure = showInputDialog(null,
					"Does the patient has infection of recent surgical procedure?(Y/N): ");
		}
		Observation infectionRecentSurgicalProcedure1 = new Observation(LocalDateTime.now(),
				"Infection Recent Surgical Procedure", toBoolean(infectionRecentSurgicalProcedure));
		currentObservationList.add(infectionRecentSurgicalProcedure1);
		String isImmunocompromised = showInputDialog(null, "Is the patient immunocompromised?(Y/N): ");
		while (!isImmunocompromised.equals("Y") && !isImmunocompromised.equals("N")) {
			isImmunocompromised = showInputDialog(null, "Is the patient immunocompromised?(Y/N): ");
		}
		Observation isImmunocompromised1 = new Observation(LocalDateTime.now(), "is Immunocompromised",
				toBoolean(isImmunocompromised));
		currentObservationList.add(isImmunocompromised1);
		String baselineRespiratoryPaOxyFiOxy = showInputDialog(null,
				"What is the patient's baseline respiratory PaOxy/FiOxy?(mmHg): ");
		while (!isNumeric(baselineRespiratoryPaOxyFiOxy)) {
			baselineRespiratoryPaOxyFiOxy = showInputDialog(null,
					"What is the patient's baseline respiratory PaOxy/FiOxy?(mmHg): ");
		}
		Observation baselineRespiratoryPaOxyFiOxy1 = new Observation(LocalDateTime.now(),
				"Baseline Respiratory PaOxy/FiOxy", Double.parseDouble(baselineRespiratoryPaOxyFiOxy));
		baselineObservationList.add(baselineRespiratoryPaOxyFiOxy1);
		String currentRespiratoryPaOxyFiOxy = showInputDialog(null,
				"What is the patient's current respiratory PaOxy/FiOxy?(mmHg): ");
		while (!isNumeric(currentRespiratoryPaOxyFiOxy)) {
			currentRespiratoryPaOxyFiOxy = showInputDialog(null,
					"What is the patient's current respiratory PaOxy/FiOxy?(mmHg): ");
		}
		Observation currentRespiratoryPaOxyFiOxy1 = new Observation(LocalDateTime.now(),
				"Current Respiratory PaOxy/FiOxy", Double.parseDouble(currentRespiratoryPaOxyFiOxy));
		currentObservationList.add(currentRespiratoryPaOxyFiOxy1);
		String baselineDopamine = showInputDialog(null,
				"What is the patient's baseline use of dopamine?(mcg/kg/minute): ");
		while (!isNumeric(baselineDopamine)) {
			baselineDopamine = showInputDialog(null,
					"What is the patient's baseline use of dopamine?(mcg/kg/minute): ");
		}
		Observation baselineDopamine1 = new Observation(LocalDateTime.now(), "Baseline Dopamine",
				Double.parseDouble(baselineDopamine));
		baselineObservationList.add(baselineDopamine1);
		String currentDopamine = showInputDialog(null,
				"What is the patient's current use of dopamine?(mcg/kg/minute): ");
		while (!isNumeric(currentDopamine)) {
			currentDopamine = showInputDialog(null, "What is the patient's current use of dopamine?(mcg/kg/minute): ");
		}
		Observation currentDopamine1 = new Observation(LocalDateTime.now(), "Current Dopamine",
				Double.parseDouble(currentDopamine));
		currentObservationList.add(currentDopamine1);
		String baselineAnyDoputamine = showInputDialog(null, "Does the patient use any doputamine yesterday?(Y/N): ");
		while (!baselineAnyDoputamine.equals("Y") && !baselineAnyDoputamine.equals("N")) {
			baselineAnyDoputamine = showInputDialog(null, "Does the patient use any doputamine yesterday?(Y/N): ");
		}
		Observation baselineAnyDoputamine1 = new Observation(LocalDateTime.now(), "Using Any Doputamine Baseline",
				toBoolean(baselineAnyDoputamine));
		baselineObservationList.add(baselineAnyDoputamine1);
		String currentAnyDoputamine = showInputDialog(null, "Does the patient use any doputamine currently?(Y/N): ");
		while (!currentAnyDoputamine.equals("Y") && !currentAnyDoputamine.equals("N")) {
			currentAnyDoputamine = showInputDialog(null, "Does the patient use any doputamine currently?(Y/N):");
		}
		Observation currentAnyDoputamine1 = new Observation(LocalDateTime.now(), "Using Any Doputamine Currently",
				toBoolean(currentAnyDoputamine));
		currentObservationList.add(currentAnyDoputamine1);
		String baselineEpinephrine = showInputDialog(null,
				"What is the patient's baseline epinephrine?(mcg/kg/minute): ");
		while (!isNumeric(baselineEpinephrine)) {
			baselineEpinephrine = showInputDialog(null, "What is the patient's baseline epinephrine?(mcg/kg/minute): ");
		}
		Observation baselineEpinephrine1 = new Observation(LocalDateTime.now(), "Baseline Epinephrine",
				Double.parseDouble(baselineEpinephrine));
		baselineObservationList.add(baselineEpinephrine1);
		String currentEpinephrine = showInputDialog(null,
				"What is the patient's current epinephrine?(mcg/kg/minute): ");
		while (!isNumeric(currentEpinephrine)) {
			currentEpinephrine = showInputDialog(null, "What is the patient's current epinephrine?(mcg/kg/minute): ");
		}
		Observation currentEpinephrine1 = new Observation(LocalDateTime.now(), "Current Epinephrine",
				Double.parseDouble(currentEpinephrine));
		currentObservationList.add(currentEpinephrine1);
		String baselineNorepinephrine = showInputDialog(null,
				"What is the patient's baseline norepinephrine?(mcg/kg/minute): ");
		while (!isNumeric(baselineNorepinephrine)) {
			baselineNorepinephrine = showInputDialog(null,
					"What is the patient's baseline norepinephrine?(mcg/kg/minute): ");
		}
		Observation baselineNorepinephrine1 = new Observation(LocalDateTime.now(), "Baseline Norepinephrine",
				Double.parseDouble(baselineNorepinephrine));
		baselineObservationList.add(baselineNorepinephrine1);
		String currentNorepinephrine = showInputDialog(null,
				"What is the patient's cureent norepinephrine?(mcg/kg/minute): ");
		while (!isNumeric(currentNorepinephrine)) {
			currentNorepinephrine = showInputDialog(null,
					"What is the patient's cureent norepinephrine?(mcg/kg/minute): ");
		}
		Observation currentNorepinephrine1 = new Observation(LocalDateTime.now(), "Current Norepinephrine",
				Double.parseDouble(currentNorepinephrine));
		currentObservationList.add(currentNorepinephrine1);
		String baseGlasgowComaScale = showInputDialog(null, "What is the patient's baseline glasgowComaScale? (): ");
		while (!isNumeric(baseGlasgowComaScale)) {
			baseGlasgowComaScale = showInputDialog(null, "What is the patient's baseline glasgowComaScale? (): ");
		}
		Observation baseGlasgowComaScale1 = new Observation(LocalDateTime.now(), "Baseline Glasgow Coma Scale",
				Double.parseDouble(baseGlasgowComaScale));
		baselineObservationList.add(baseGlasgowComaScale1);
		String currentGlasgowComaScale = showInputDialog(null, "What is the patient's current glasgowComaScale? (): ");
		while (!isNumeric(currentGlasgowComaScale)) {
			currentGlasgowComaScale = showInputDialog(null, "What is the patient's current glasgowComaScale? (): ");
		}
		Observation currentGlasgowComaScale1 = new Observation(LocalDateTime.now(), "Current Glasgow Coma Scale",
				Double.parseDouble(currentGlasgowComaScale));
		currentObservationList.add(currentGlasgowComaScale1);
	}

	public static Concept setUpBaselineConceptList(Set<Observation> observationList) {
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
			} else if (observation.getConcept().equals("Baseline Respiratory PaOxy/FiOxy")) {
				concepts.setRespiratoryPaOxyFiOxy(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Coagulation Platelets")) {
				concepts.setCoagulationPlatelets(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Liver Bilirubin")) {
				concepts.setLiverBilirubin(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Baseline Dopamine")) {
				concepts.setDopamine(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Using Any Doputamine Baseline")) {
				concepts.setAnyDoputamine(observation.getBMeasurement());
			} else if (observation.getConcept().equals("Baseline Epinephrine")) {
				concepts.setEpinephrine(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Baseline Norepinephrine")) {
				concepts.setNorepinephrine(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Baseline Glasgow Coma Scale")) {
				concepts.setGlasgowComaScale(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Creatinine in Blood (mg/dL)")) {
				concepts.setRenalCreatinine(observation.getDMeasurement());
			}
		}
		return concepts;
	}

	public static Concept setUpCurrentConceptList(Set<Observation> observationList) {
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
			} else if (observation.getConcept().equals("Current Respiratory PaOxy/FiOxy")) {
				concepts.setRespiratoryPaOxyFiOxy(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Coagulation Platelets")) {
				concepts.setCoagulationPlatelets(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Liver Bilirubin")) {
				concepts.setLiverBilirubin(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Current Dopamine")) {
				concepts.setDopamine(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Using Any Doputamine Currently")) {
				concepts.setAnyDoputamine(observation.getBMeasurement());
			} else if (observation.getConcept().equals("Current Epinephrine")) {
				concepts.setEpinephrine(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Current Norepinephrine")) {
				concepts.setNorepinephrine(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Current Glasgow Coma Scale")) {
				concepts.setGlasgowComaScale(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Current Glasgow Coma Scale")) {
				concepts.setGlasgowComaScale(observation.getDMeasurement());
			} else if (observation.getConcept().equals("Creatinine in Blood (mg/dL)")) {
				concepts.setRenalCreatinine(observation.getDMeasurement());
			}
		}
		return concepts;
	}

	public static void categorizeObservationList(Set<Observation> currentObservationList,
			Set<Observation> baselineObservationList, Observation observation) {
		LocalDate timestamp = observation.getTimestamp().toLocalDate();
		Period time = Period.between(timestamp, LocalDate.now());
		if (time.getDays() <= 1) {
			currentObservationList.add(observation);
		} else if (time.getDays() > 1 && time.getDays() <= 2) {
			baselineObservationList.add(observation);
		}
	}

	public static void main(String[] args) throws IOException {

		String serverLocation = showInputDialog(null, "Enter server location");
		if (serverLocation == null) {
			return;
		} else {
			String username = showInputDialog(null, "Enter username: ");
			if (username == null) {
				return;
			} else {
				String password = showInputDialog(null, "Enter password: ");
				if (password == null) {
					return;
				}
				try {
					OpenMRSConnection connection = new OpenMRSConnection(serverLocation, username, password);
					String numberOfPatients = showInputDialog(null, "Enter number of patients");
					if (numberOfPatients == null) {
						return;
					} else {
						while (!isInt(numberOfPatients)) {
							numberOfPatients = showInputDialog(null, "Enter number of patients");
							if (numberOfPatients == null) {
								return;
							}
						}
						String[] patientID = new String[Integer.parseInt(numberOfPatients)];
						for (int i = 0; i < patientID.length; ++i) {
							patientID[i] = showInputDialog(null, "Enter patientID: ");
							if (patientID[i] == null) {
								return;
							}
							if (!patientID[i].matches("[0-9A-Z]*")) {
								patientID[i] = showInputDialog(null, "Enter patientID: ");
							}
							PatientRecord patientRecord = connection.getPatientRecord(patientID[i]);
							if (patientRecord == null) {
								JOptionPane.showMessageDialog(null, "Patient" + patientID[i] + " does not exist.");
								return;
							}
							JOptionPane.showMessageDialog(null, "Patient" + patientID[i] + " exists.");
							LocalDateTime now = LocalDateTime.now();
							Period age = Period.between(patientRecord.getBirthDate(), now.toLocalDate());
							System.out.println("  Time Reported: " + now.toString());
							System.out.println("  PatientID: " + patientID[i]);
							System.out.println("  Patient Name: " + patientRecord.getFamilyName() + " "
									+ patientRecord.getGivenName());
							System.out.println("  Age: " + age.getYears() + " years " + age.getMonths() + " months "
									+ age.getDays() + " days");
							System.out.println("  Location: " + patientRecord.getLocation());
							String temperature = "unknown";
							String heartRate = "unknown";
							String respiratoryRate = "unknown";
							for (ObservationRecord observation : connection
									.getObservationRecords(patientRecord.getUUID())) {
								if (observation.getConcept().equals("Temperature (C)")) {
									temperature = String.valueOf(observation.getMeasurement());
								} else if (observation.getConcept().equals("Pulse")) {
									heartRate = String.valueOf(observation.getMeasurement());
								} else if (observation.getConcept().equals("Respiratory rate")) {
									respiratoryRate = String.valueOf(observation.getMeasurement());
								}
							}
							System.out.println("  Body Temperature: " + temperature + " (C)");
							System.out.println("  Heart Rate: " + heartRate + " (bpm)");
							System.out.println("  Respiratory Rate: " + respiratoryRate + " (bpm)");
							Set<Observation> currentObservationList = new HashSet<Observation>();
							Set<Observation> baselineObservationList = new HashSet<Observation>();
							setUpObservationList(connection.getObservationRecords(patientRecord.getUUID()),
									currentObservationList, baselineObservationList);
							Concept currentConcepts = setUpCurrentConceptList(currentObservationList);
							Concept baselineConcepts = setUpBaselineConceptList(baselineObservationList);
							System.out.println(SepsisDeterminationAlgorithm.analyze(patientRecord, baselineConcepts,
									currentConcepts));
							for (Observation observation : currentObservationList) {
								if (observation.getMeasurement() == null) {
									System.out.println(observation.getTimestamp() + ": " + observation.getConcept()
											+ ": " + "unknown");
								} else {
									System.out.println(observation.getTimestamp() + ": " + observation.getConcept()
											+ ": " + observation.getMeasurement());
								}
							}
							System.out.println();
							for (Observation observation : baselineObservationList) {
								if (observation.getMeasurement() == null) {
									System.out.println(observation.getTimestamp() + ": " + observation.getConcept()
											+ ": " + "unknown");
								} else {
									System.out.println(observation.getTimestamp() + ": " + observation.getConcept()
											+ ": " + observation.getMeasurement());
								}
							}
						}
					}
				} catch (ConnectException ex) {
					JOptionPane.showMessageDialog(null, "Could not contact the server.");
				} catch (FileNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "Could not contact the server.");
				} catch (ProtocolException ex) {
					JOptionPane.showMessageDialog(null, "Credentials were incorrect.");
				} catch (NullPointerException ex) {
					return;
				}
			}
		}

	}
}