package edu.unl.cse.soft160.a4.sepsis;

import static javax.swing.JOptionPane.showInputDialog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.unl.cse.soft160.rest_connector.connector.ObservationRecord;
import edu.unl.cse.soft160.rest_connector.connector.OpenMRSConnection;
import edu.unl.cse.soft160.rest_connector.connector.PatientRecord;

public class SepesisDeterminationApp {

	public Patient setValue(PatientRecord patientRecord, ObservationRecord observationRecord,
			String needForVasopressorSupport, String isResponsive, String presenceOfCardiacArrhythmia,
			String declineInBaselineStatus, Double baselineGlaslowScale, Double currentGlaslowScale) {
		Patient patient = new Patient();
		ArrayList<Observation> observationList = patient.getObservationList();
		for (Observation observation: observationList ) {
			 
			 if (observation.getConcept() == "needForVasopressorSupport") {
				observation.setBMeasurement(needForVasopressorSupport);
			 }
			 else if (observation.getConcept() == "needForVasopressorSupport") {
				observation.setBMeasurement(isResponsive);
			 }else if (observation.getConcept() == "presenceOfCardiacArrhythmia") {
				observation.setBMeasurement(presenceOfCardiacArrhythmia);
			 }else if(observation.getConcept() == "declineInBaselineStatus"){
				observation.setBMeasurement(declineInBaselineStatus);
			 }else if(observation.getConcept() == "baselineGlaslowScale") {
				observation.setDMeasurement(baselineGlaslowScale);
			 } else if(observation.getConcept() == "currentGlaslowScale") {
				observation.setDMeasurement(currentGlaslowScale);
			 }
		}
		return patient;
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
				} else {
					String needForVasopressorSupport = showInputDialog(null,
							"Does the patient need for vasopressor support?:(Y/N) ");

					String isResponsive = showInputDialog(null, "Is the patient unresponsive?:(Y/N) ");

					String presenceOfCardiacArrhythmia = showInputDialog(null,
							"Does the patient have Cardiac Arrhythmia?:(Y/N) ");

					String declineInBaselineStatus = showInputDialog(null,
							"Does the patient have decline in baseline mental status?:(Y/N) ");

					String baselineGlaslowScale = showInputDialog(null, "Enter baseline Glaslow Scale: ");

					String currentGlaslowScale = showInputDialog(null, "Enter current Glaslow Scale: ");

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
						System.out.println("  Patient Name: " + patientRecord.getFamilyName() + " "
								+ patientRecord.getGivenName());
						System.out.println("  Age: " + age.getYears() + " years " + age.getMonths() + " months "
								+ age.getDays() + " days");
						System.out.println("  Location: " + patientRecord.getLocation());
						for (ObservationRecord observationRecord : connection
								.getObservationRecords(patientRecord.getUUID())) {
							System.out.println(observationRecord.getConcept());
						}
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
}
