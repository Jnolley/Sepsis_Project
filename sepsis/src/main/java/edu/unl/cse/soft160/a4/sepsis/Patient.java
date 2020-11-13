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
		Observation respiratoryRate =  new Observation("respiratoryRate"); // this is a calculated value we need to change
		Observation wBCCount= new Observation("wBCCount");
		Observation systolicBloodPressure= new Observation ("systolicBloodPressure");
		Observation diastolicBloodPressure= new Observation ("diastolicBloodPressure");
		Observation isInpatientStatus= new Observation ("isInpatientStatus");
		Observation needForVasopressorSupport= new Observation ("needForVasopressorSupport");
		Observation isResponsive= new Observation ("isResponsive");
		Observation cardiacArrhythmia= new Observation ("cardiacArrhythmia");
		Observation declineInBaselineMentalStatus= new Observation ('declineInBaselineMentalStatus'); 
		Observation infectionSkinWound= new Observaiton ("infectionSkinWound");
		Observation infectionInvasiveDevice= new Observation("infectionInvasiveDevice");
		Observation infectionRecentSurgicalProcedure= new Observation("infectionRecentSurgicalProcedure");
		Observation isImmunocompromised= new Observation ("isImmunocompromised");
		Observation respiratoryPaOxyFiOxy= new Observation ("respiratoryPaOxyFiOxy"); //check this one this one might also be calculated
		Observation coagulationPlatelets= new Observation ("coagualtionPlatelets"); 
		Observation liverBilirubin= new Observation ("liverBilirubin");
		Observation dopamine= new Observation ("dopamine");
		Observation anyDoputamine= new Observation ("anyDoputamine");
		Observation epinephrine= new Observation ("epinephrine");
		Observation norepinephrine= new Observation ("norepinephrine");
		Observation glasgowComaScale= new Observation ("galsgowComaScale");
	}

	public ArrayList<Observation> getObservationList() {
		return observationList;
	}

}