package edu.unl.cse.soft160.a4.sepsis;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Patient {
	private ArrayList<Observation> observation = new ArrayList<Observation>();
	private LocalDate birthDate;

	public Patient(ArrayList<Observation> observation, LocalDate birthDate) {
		super();
		this.observation = observation;
		this.setBirthDate(birthDate);
	}

	public Observation getCurrentObservation() {
		for (Observation observation : observation) {
			LocalDate timestamp = observation.getTimestamp().toLocalDate();
			Period period = Period.between(timestamp, LocalDate.now());
			if (period.getDays() <= 1) {
				return observation;
			}
		}
		return null;
	}

	public Observation getLastObservation() {
		for (Observation observation : observation) {
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

	
}