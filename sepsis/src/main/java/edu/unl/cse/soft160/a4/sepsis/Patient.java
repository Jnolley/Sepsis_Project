package edu.unl.cse.soft160.a4.sepsis;

import java.util.ArrayList;

public class Patient {
	
	boolean isAdult;
	ArrayList<Observation> observaitonList = new ArrayList<Observation>();


public Patient(boolean isAdult, ArrayList<Observation> observaitonList) {
	super();
	this.isAdult = isAdult;
	this.observaitonList = observaitonList;
}


public boolean isAdult() {
	return isAdult;
}


public void setAdult(boolean isAdult) {
	this.isAdult = isAdult;
}


public ArrayList<Observation> getObservaitonList() {
	return observaitonList;
}


public void setObservaitonList(ArrayList<Observation> observaitonList) {
	this.observaitonList = observaitonList;
}





}