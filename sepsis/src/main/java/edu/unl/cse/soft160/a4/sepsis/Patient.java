package edu.unl.cse.soft160.a4.sepsis;

import java.util.ArrayList;

public class Patient {

	private Integer birthDay;
	private Integer birthMonth;
	private Integer birthYear;
	ArrayList<Observation> observaitonList = new ArrayList<Observation>();

	public Patient(Integer birthDay, Integer birthMonth, Integer birthYear, ArrayList<Observation> observaitonList) {
		super();
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.observaitonList = observaitonList;
	}

	public ArrayList<Observation> getObservaitonList() {
		return observaitonList;
	}

	public void setObservaitonList(ArrayList<Observation> observaitonList) {
		this.observaitonList = observaitonList;
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