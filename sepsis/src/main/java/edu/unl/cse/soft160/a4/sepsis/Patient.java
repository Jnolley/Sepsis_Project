package edu.unl.cse.soft160.a4.sepsis;

import java.util.ArrayList;

public class Patient {
	
	int yearBorn;
	ArrayList<Observation> observaitonList = new ArrayList<Observation>();


public Patient(int yearBorn, ArrayList<Observation> observaitonList) {
	super();
	this.yearBorn = yearBorn;
	this.observaitonList = observaitonList;
}


public int yearBorn() {
	return yearBorn;
}


public void setAdult(int yearBorn) {
	this.yearBorn = yearBorn;
}


public ArrayList<Observation> getObservaitonList() {
	return observaitonList;
}


public void setObservaitonList(ArrayList<Observation> observaitonList) {
	this.observaitonList = observaitonList;
}





}