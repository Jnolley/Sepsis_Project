package edu.unl.cse.soft160.a4.sepsis;

import static javax.swing.JOptionPane.showInputDialog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Set;
import java.util.HashSet;

import javax.swing.JOptionPane;

import edu.unl.cse.soft160.rest_connector.connector.ObservationRecord;
import edu.unl.cse.soft160.rest_connector.connector.OpenMRSConnection;
import edu.unl.cse.soft160.rest_connector.connector.PatientRecord;

public class SepesisDeterminationApp {
	public static Boolean toBoolean(String answer) {
		if (answer.equals("Y")) {
			return true;
		} else if (answer.equals("N")) {
			return false;
		} else
			return null;
	}

	public static Set<Observation> setUpObservationList(Set<ObservationRecord> observationRecordList) {
		Set<Observation> observationList = new HashSet<Observation>();
		for (ObservationRecord observationRecord : observationRecordList) {
			if (observationRecord.getConcept().equals("Temperature (C)")) {
				Observation temperature = new Observation(observationRecord.getTimestamp(), "Temperature",
						observationRecord.getMeasurement());
				observationList.add(temperature);
			} else if (observationRecord.getConcept().equals("Diastolic blood pressure")) {
				Observation diastolicBloodPressure = new Observation(observationRecord.getTimestamp(),
						"Diastolic blood pressure", observationRecord.getMeasurement());
				observationList.add(diastolicBloodPressure);
			} else if (observationRecord.getConcept().equals("Systolic blood pressure")) {
				Observation systolicBloodPressure = new Observation(observationRecord.getTimestamp(),
						"Systolic blood pressure", observationRecord.getMeasurement());
				observationList.add(systolicBloodPressure);
			} else if (observationRecord.getConcept().equals("Creatinine in Blood (mg/dL)")) {
				Observation creatinineInBlood = new Observation(observationRecord.getTimestamp(),
						"Creatinine in blood (mg/dL)", observationRecord.getMeasurement());
				observationList.add(creatinineInBlood);
			} else if (observationRecord.getConcept().equals("Respiratory rate")) {
				Observation respiratoryRate = new Observation(observationRecord.getTimestamp(), "Respiratory rate",
						observationRecord.getMeasurement());
				observationList.add(respiratoryRate);
			}
		}
		String isPregnant = showInputDialog(null, "Is the patient pregnant? (Y/N): ");
		Observation isPregnant1 = new Observation(LocalDateTime.now(), "Is Pregnant", toBoolean(isPregnant));
		observationList.add(isPregnant1);
		String needForVasopressorSupport = showInputDialog(null,
				"Does the patient need for vasopressor support?(Y/N): ");
		Observation needForVasopressorSupport1 = new Observation(LocalDateTime.now(), "Need For Vasopressor Support",
				toBoolean(needForVasopressorSupport));
		observationList.add(needForVasopressorSupport1);
		String heartRate = showInputDialog(null, "What is the patient's heart rate? (): ");
		Observation heartRate1 = new Observation(LocalDateTime.now(), "Heart rate", Double.parseDouble(heartRate));
		observationList.add(heartRate1);
		String WBCCount = showInputDialog(null, "What is the patient's wbc count? (): ");
		Observation wbcCount1 = new Observation(LocalDateTime.now(), "WBCCount", Double.parseDouble(WBCCount));
		observationList.add(wbcCount1);
		String isInpatientStatus = showInputDialog(null, "Is the patient's status inpatient status?(Y/N): ");
		Observation isInpatientStatus1 = new Observation(LocalDateTime.now(), "Is Inpatient Status",
				toBoolean(isInpatientStatus));
		observationList.add(isInpatientStatus1);
		String isResponsive = showInputDialog(null, "Is the patient responsive?(Y/N): ");
		Observation isResponsive1 = new Observation(LocalDateTime.now(), "Is responsive", toBoolean(isResponsive));
		observationList.add(isResponsive1);
		String cardiacArrhythmia = showInputDialog(null, "Does the patient have cardiac arrhythmia?(Y/N): ");
		Observation cardiacArrhythmia1 = new Observation(LocalDateTime.now(), "Cardiac arrhythmia",
				toBoolean(cardiacArrhythmia));
		observationList.add(cardiacArrhythmia1);
		String declineInBaselineMentalStatus = showInputDialog(null,
				"Does the patient has decline in baseline mental status?(Y/N): ");
		Observation declineInBaselineMentalStatus1 = new Observation(LocalDateTime.now(),
				"Decline in baseline mental status", toBoolean(declineInBaselineMentalStatus));
		observationList.add(declineInBaselineMentalStatus1);
		String infectionSkinWound = showInputDialog(null, "Does the patient has infection skin wound?(Y/N): ");
		Observation infectionSkinWound1 = new Observation(LocalDateTime.now(), "Infection Skin Wound",
				toBoolean(infectionSkinWound));
		observationList.add(infectionSkinWound1);
		String infectionInvasiveDevice = showInputDialog(null,
				"Does the patient has infection invasive device?(Y/N): ");
		Observation infectionInvasiveDevice1 = new Observation(LocalDateTime.now(), "Infection Invasive Device",
				toBoolean(infectionInvasiveDevice));
		observationList.add(infectionInvasiveDevice1);
		String infectionRecentSurgicalProcedure = showInputDialog(null,
				"Does the patient has infection of recent surgical procedure?(Y/N): ");
		Observation infectionRecentSurgicalProcedure1 = new Observation(LocalDateTime.now(),
				"Infection Recent Surgical Procedure", toBoolean(infectionRecentSurgicalProcedure));
		observationList.add(infectionRecentSurgicalProcedure1);
		String isImmunocompromised = showInputDialog(null, "Is the patient immunocompromised?(Y/N): ");
		Observation isImmunocompromised1 = new Observation(LocalDateTime.now(), "is Immunocompromised",
				toBoolean(isImmunocompromised));
		observationList.add(isImmunocompromised1);
		String baselineRespiratoryPaOxyFiOxy = showInputDialog(null,
				"What is the patient's baseline respiratory PaOxy/FiOxy? (): ");
		Observation baselineRespiratoryPaOxyFiOxy1 = new Observation(LocalDateTime.now(),
				"Baseline Respiratory PaOxy/FiOxy", Double.parseDouble(baselineRespiratoryPaOxyFiOxy));
		observationList.add(baselineRespiratoryPaOxyFiOxy1);
		String currentRespiratoryPaOxyFiOxy = showInputDialog(null,
				"What is the patient's current respiratory PaOxy/FiOxy? (): ");
		Observation currentRespiratoryPaOxyFiOxy1 = new Observation(LocalDateTime.now(),
				"Current Respiratory PaOxy/FiOxy", Double.parseDouble(currentRespiratoryPaOxyFiOxy));
		observationList.add(currentRespiratoryPaOxyFiOxy1);
		String baselineCoagulationPlatelets = showInputDialog(null,
				"What is the patient's baseline coagulation platelets? (): ");
		Observation baselineCoagulationPlatelets1 = new Observation(LocalDateTime.now(),
				"Baseline Coagulation Platelets", Double.parseDouble(baselineCoagulationPlatelets));
		observationList.add(baselineCoagulationPlatelets1);
		String currentCoagulationPlatelets = showInputDialog(null,
				"What is the patient's current coagulation platelets? (): ");
		Observation currentCoagulationPlatelets1 = new Observation(LocalDateTime.now(), "Current Coagulation Platelets",
				Double.parseDouble(currentCoagulationPlatelets));
		observationList.add(currentCoagulationPlatelets1);
		String baselineLiverBilirubin = showInputDialog(null,
				"What is the patient's baseline use of liver bilirubin? (): ");
		Observation baselineLiverBilirubin1 = new Observation(LocalDateTime.now(), "Baseline Liver Bilirubin",
				Double.parseDouble(baselineLiverBilirubin));
		observationList.add(baselineLiverBilirubin1);
		String currentliverBilirubin = showInputDialog(null,
				"What is the patient's current use of liver bilirubin? (): ");
		Observation currentliverBilirubin1 = new Observation(LocalDateTime.now(), "Current Liver Bilirubin",
				Double.parseDouble(currentliverBilirubin));
		observationList.add(currentliverBilirubin1);
		String baselineDopamine = showInputDialog(null, "What is the patient's baseline use of dopamine? (): ");
		Observation baselineDopamine1 = new Observation(LocalDateTime.now(), "Baseline Dopamine",
				Double.parseDouble(baselineDopamine));
		observationList.add(baselineDopamine1);
		String currentDopamine = showInputDialog(null, "What is the patient's current use of dopamine? (): ");
		Observation currentDopamine1 = new Observation(LocalDateTime.now(), "Current Dopamine",
				Double.parseDouble(currentDopamine));
		observationList.add(currentDopamine1);
		String baselineAnyDoputamine = showInputDialog(null, "Does the patient use any doputamine yesterday?(Y/N): ");
		Observation baselineAnyDoputamine1 = new Observation(LocalDateTime.now(), "Using Any Doputamine Baseline",
				toBoolean(baselineAnyDoputamine));
		observationList.add(baselineAnyDoputamine1);
		String currentAnyDoputamine = showInputDialog(null, "Does the patient use any doputamine currently?(Y/N): ");
		Observation currentAnyDoputamine1 = new Observation(LocalDateTime.now(), "Using Any Doputamine Currently",
				toBoolean(currentAnyDoputamine));
		observationList.add(currentAnyDoputamine1);
		String baselineEpinephrine = showInputDialog(null, "What is the patient's baseline epinephrine? (): ");
		Observation baselineEpinephrine1 = new Observation(LocalDateTime.now(), "Baseline Epinephrine",
				Double.parseDouble(baselineEpinephrine));
		observationList.add(baselineEpinephrine1);
		String currentEpinephrine = showInputDialog(null, "What is the patient's epinephrine? (): ");
		Observation currentEpinephrine1 = new Observation(LocalDateTime.now(), "Current Epinephrine",
				Double.parseDouble(currentEpinephrine));
		observationList.add(currentEpinephrine1);
		String baselineNorepinephrine = showInputDialog(null, "What is the patient's baseline norepinephrine? (): ");
		Observation baselineNorepinephrine1 = new Observation(LocalDateTime.now(), "Baseline Norepinephrine",
				Double.parseDouble(baselineNorepinephrine));
		observationList.add(baselineNorepinephrine1);
		String currentNorepinephrine = showInputDialog(null, "What is the patient's cureent norepinephrine? (): ");
		Observation currentNorepinephrine1 = new Observation(LocalDateTime.now(), "Current Norepinephrine",
				Double.parseDouble(currentNorepinephrine));
		observationList.add(currentNorepinephrine1);
		String baseGlasgowComaScale = showInputDialog(null, "What is the patient's baseline glasgowComaScale? (): ");
		Observation baseGlasgowComaScale1 = new Observation(LocalDateTime.now(), "Baseline Glasgow Coma Scale",
				Double.parseDouble(baseGlasgowComaScale));
		observationList.add(baseGlasgowComaScale1);
		String currentGlasgowComaScale = showInputDialog(null, "What is the patient's current glasgowComaScale? (): ");
		Observation currentGlasgowComaScale1 = new Observation(LocalDateTime.now(), "Current Glasgow Coma Scale",
				Double.parseDouble(currentGlasgowComaScale));
		observationList.add(currentGlasgowComaScale1);
		return observationList;
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
					String patientID = showInputDialog(null, "Enter patientID: ");
					if (patientID == null) {
						return;
					}
					PatientRecord patientRecord = connection.getPatientRecord(patientID);
					if (patientRecord == null) {
						JOptionPane.showMessageDialog(null, "Patient" + patientID + " does not exist.");
						return;
					}
					JOptionPane.showMessageDialog(null, "Patient" + patientID + " exists.");
					LocalDateTime now = LocalDateTime.now();
					Period age = Period.between(patientRecord.getBirthDate(), now.toLocalDate());
					System.out.println("  Time Reported: " + now.toString());
					System.out.println("  PatientID: " + patientID);
					System.out.println(
							"  Patient Name: " + patientRecord.getFamilyName() + " " + patientRecord.getGivenName());
					System.out.println("  Age: " + age.getYears() + " years " + age.getMonths() + " months "
							+ age.getDays() + " days");
					System.out.println("  Location: " + patientRecord.getLocation());
					Set<Observation> observationList = setUpObservationList(
							connection.getObservationRecords(patientRecord.getUUID()));
					for (Observation observation : observationList) {
						System.out.println(observation.getTimestamp() + ": " + observation.getConcept() + ": "
								+ observation.getMeasurement());
					}
					System.out.println(SepsisDeterminationAlgorithm.analyze(observationList, patientRecord));
				} catch (ConnectException ex) {
					JOptionPane.showMessageDialog(null, "Could not contact the server.");
				} catch (FileNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "Could not contact the server.");
				} catch (ProtocolException ex) {
					JOptionPane.showMessageDialog(null, "Credentials were incorrect.");
				}
			}
		}
	}

}