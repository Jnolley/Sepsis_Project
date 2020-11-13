package edu.unl.cse.soft160.a4.sepsis;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Patient {
	private ArrayList<Observation> observationList = new ArrayList<Observation>();
	private LocalDate birthDate;

	public Patient(ArrayList<Observation> observationList, LocalDate birthDate) {
		super();
		this.observationList = observationList;
		this.setBirthDate(birthDate);
	}

	public Patient() {
		super();
	}

	public Observation getCurrentObservation() {
		for (Observation observation : observationList) {
			LocalDate timestamp = observation.getTimestamp().toLocalDate();
			Period period = Period.between(timestamp, LocalDate.now());
			if (period.getDays() <= 1) {
				return observation;
			}
		}
		return null;
	}

	public Observation getLastObservation() {
		for (Observation observation : observationList) {
			LocalDate timestamp = observation.getTimestamp().toLocalDate();
			Period period = Period.between(timestamp, LocalDate.now());
			if (period.getDays() > 1 && period.getDays() <= 2) {
				return observation;
			}
		}
		return null;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public void addAllValueToObservationList() {
		Observation isPregnant = new Observation("isPregnant");
		Observation temperature = new Observation("temperature");
		Observation heartRate =  new Observation("heartRate");
		Observation respiratoryRate =  new Observation("respiratoryRate");
	}

	public ArrayList<Observation> getObservationList() {
		return observationList;
	}

}