package edu.unl.cse.soft160.a4.sepsis;

import static javax.swing.JOptionPane.showInputDialog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import javax.swing.JOptionPane;

import edu.unl.cse.soft160.rest_connector.connector.ObservationRecord;
import edu.unl.cse.soft160.rest_connector.connector.OpenMRSConnection;
import edu.unl.cse.soft160.rest_connector.connector.PatientRecord;

public class SepesisDeterminationApp {

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
							LocalDate timeStamp = observationRecord.getTimestamp().toLocalDate();
							
						}
						for (ObservationRecord observationRecord : connection
								.getObservationRecords(patientRecord.getUUID())) {
							String suffix = observationRecord.getMeasurement() == null ? ""
									: " = " + observationRecord.getMeasurement().toString();
							System.out.println("  " + observationRecord.getTimestamp() + ": "
									+ observationRecord.getConcept() + suffix);
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
