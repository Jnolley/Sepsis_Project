package edu.unl.cse.soft160.a4.sepsis;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Patient {
	private ArrayList<Observation> observation = new ArrayList<Observation>();
	private Integer birthDay;
	private Integer birthMonth;
	private Integer birthYear;

	public Patient(ArrayList<Observation> observation, Integer birthDay, Integer birthMonth, Integer birthYear) {
		super();
		this.observation = observation;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
	}

	public Observation getCurrentObservation() {
		for (Observation observation : observation) {
			Period period = Period.between(observation.getTime(), LocalDate.now());
			if (period.getDays() <= 1) {
				return observation;
			}
		}
		return null;
	}

	public Observation getLastObservation() {
		for (Observation observation : observation) {
			LocalDate time = observation.getTime();
			Period period = Period.between(observation.getTime(), LocalDate.now());
			if (period.getDays() > 1 && period.getDays() <= 2) {
				return observation;
			}
		}
		return null;
	}

	public Integer getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Integer birthDay) {
		this.birthDay = birthDay;
	}

	public Integer getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(Integer birthMonth) {
		this.birthMonth = birthMonth;
	}

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}
}