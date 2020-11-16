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

	public Double getMAP(ArrayList<Observation> observationList) {
		Double systolicBloodPressure = null, diastolicBloodPressure = null;
		for (Observation observation : observationList) {
			if (observation.getConcept() == "systolicBloodPressure") {
				systolicBloodPressure = observation.getDMeasurement();
			} else if (observation.getConcept() == "systolicBloodPressure") {
				diastolicBloodPressure = observation.getDMeasurement();
			}
		}
		Double map = (systolicBloodPressure - diastolicBloodPressure) / 3 + diastolicBloodPressure;
		return map;
	}

	public Patient() {
		super();
		Observation isPregnant = new Observation("isPregnant");
		Observation temperature = new Observation("temperature");
		Observation heartRate = new Observation("heartRate");
		Observation respiratoryRate = new Observation("respiratoryRate");
		Observation wBCCount = new Observation("wBCCount");
		Observation systolicBloodPressure = new Observation("systolicBloodPressure");
		Observation diastolicBloodPressure = new Observation("diastolicBloodPressure");
		Observation isInpatientStatus = new Observation("isInpatientStatus");
		Observation needForVasopressorSupport = new Observation("needForVasopressorSupport");
		Observation isResponsive = new Observation("isResponsive");
		Observation cardiacArrhythmia = new Observation("cardiacArrhythmia");
		Observation declineInBaselineMentalStatus = new Observation("declineInBaselineMentalStatus");
		Observation infectionSkinWound = new Observation("infectionSkinWound");
		Observation infectionInvasiveDevice = new Observation("infectionInvasiveDevice");
		Observation infectionRecentSurgicalProcedure = new Observation("infectionRecentSurgicalProcedure");
		Observation isImmunocompromised = new Observation("isImmunocompromised");
		Observation respiratoryPaOxyFiOxy = new Observation("respiratoryPaOxyFiOxy");
		Observation coagulationPlatelets = new Observation("coagualtionPlatelets");
		Observation liverBilirubin = new Observation("liverBilirubin");
		Observation dopamine = new Observation("dopamine");
		Observation anyDoputamine = new Observation("anyDoputamine");
		Observation epinephrine = new Observation("epinephrine");
		Observation norepinephrine = new Observation("norepinephrine");
		Observation glasgowComaScale = new Observation("galsgowComaScale");
		this.observationList.add(isPregnant);
		this.observationList.add(temperature);
		this.observationList.add(heartRate);
		this.observationList.add(respiratoryRate);
		this.observationList.add(wBCCount);
		this.observationList.add(systolicBloodPressure);
		this.observationList.add(diastolicBloodPressure);
		this.observationList.add(isInpatientStatus);
		this.observationList.add(needForVasopressorSupport);
		this.observationList.add(isResponsive);
		this.observationList.add(cardiacArrhythmia);
		this.observationList.add(declineInBaselineMentalStatus);
		this.observationList.add(infectionSkinWound);
		this.observationList.add(infectionInvasiveDevice);
		this.observationList.add(infectionRecentSurgicalProcedure);
		this.observationList.add(infectionInvasiveDevice);
		this.observationList.add(isImmunocompromised);
		this.observationList.add(respiratoryPaOxyFiOxy);
		this.observationList.add(coagulationPlatelets);
		this.observationList.add(liverBilirubin);
		this.observationList.add(dopamine);
		this.observationList.add(anyDoputamine);
		this.observationList.add(epinephrine);
		this.observationList.add(norepinephrine);
		this.observationList.add(glasgowComaScale);
	}

	public ArrayList<Observation> getCurrentObservationList() {
		ArrayList<Observation> currentObservationList = new ArrayList<Observation>();
		for (Observation observation : observationList) {
			LocalDate timestamp = observation.getTimestamp().toLocalDate();
			Period period = Period.between(timestamp, LocalDate.now());
			if (period.getDays() <= 1) {
				currentObservationList.add(observation);
			}
		}
		return currentObservationList;
	}

	public ArrayList<Observation> getLastObservationList() {
		ArrayList<Observation> lastObservationList = new ArrayList<Observation>();
		for (Observation observation : observationList) {
			LocalDate timestamp = observation.getTimestamp().toLocalDate();
			Period period = Period.between(timestamp, LocalDate.now());
			if (period.getDays() > 1 && period.getDays() <= 2) {
				lastObservationList.add(observation);
			}
		}
		return lastObservationList;
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
		Observation heartRate = new Observation("heartRate");
		Observation respiratoryRate = new Observation("respiratoryRate");
		Observation wBCCount = new Observation("wBCCount");
		Observation systolicBloodPressure = new Observation("systolicBloodPressure");
		Observation diastolicBloodPressure = new Observation("diastolicBloodPressure");
		Observation isInpatientStatus = new Observation("isInpatientStatus");
		Observation needForVasopressorSupport = new Observation("needForVasopressorSupport");
		Observation isResponsive = new Observation("isResponsive");
		Observation cardiacArrhythmia = new Observation("cardiacArrhythmia");
		Observation declineInBaselineMentalStatus = new Observation("declineInBaselineMentalStatus");
		Observation infectionSkinWound = new Observation("infectionSkinWound");
		Observation infectionInvasiveDevice = new Observation("infectionInvasiveDevice");
		Observation infectionRecentSurgicalProcedure = new Observation("infectionRecentSurgicalProcedure");
		Observation isImmunocompromised = new Observation("isImmunocompromised");
		Observation respiratoryPaOxyFiOxy = new Observation("respiratoryPaOxyFiOxy");
		Observation coagulationPlatelets = new Observation("coagualtionPlatelets");
		Observation liverBilirubin = new Observation("liverBilirubin");
		Observation dopamine = new Observation("dopamine");
		Observation anyDoputamine = new Observation("anyDoputamine");
		Observation epinephrine = new Observation("epinephrine");
		Observation norepinephrine = new Observation("norepinephrine");
		Observation glasgowComaScale = new Observation("galsgowComaScale");
		Observation renalCreatinine = new Observation("renalCreatinine");
		Observation urineOutput = new Observation("urineOutput");
		this.observationList.add(isPregnant);
		this.observationList.add(temperature);
		this.observationList.add(heartRate);
		this.observationList.add(respiratoryRate);
		this.observationList.add(wBCCount);
		this.observationList.add(systolicBloodPressure);
		this.observationList.add(diastolicBloodPressure);
		this.observationList.add(isInpatientStatus);
		this.observationList.add(needForVasopressorSupport);
		this.observationList.add(isResponsive);
		this.observationList.add(cardiacArrhythmia);
		this.observationList.add(declineInBaselineMentalStatus);
		this.observationList.add(infectionSkinWound);
		this.observationList.add(infectionInvasiveDevice);
		this.observationList.add(infectionRecentSurgicalProcedure);
		this.observationList.add(infectionInvasiveDevice);
		this.observationList.add(isImmunocompromised);
		this.observationList.add(respiratoryPaOxyFiOxy);
		this.observationList.add(coagulationPlatelets);
		this.observationList.add(liverBilirubin);
		this.observationList.add(dopamine);
		this.observationList.add(anyDoputamine);
		this.observationList.add(epinephrine);
		this.observationList.add(norepinephrine);
		this.observationList.add(glasgowComaScale);
		this.observationList.add(renalCreatinine);
		this.observationList.add(urineOutput);
	}

	public ArrayList<Observation> getObservationList() {
		return observationList;
	}
	public void addValueToList(Boolean isPregnant, Double temperature, Double heartRate, Double respiratoryRate, Double wBCCount,
			Double systolicBloodPressure, Double diastolicBloodPressure, Boolean isInpatientStatus,
			Boolean needForVasopressorSupport, Boolean isResponsive, Boolean cardiacArrhythmia,
			Boolean declineInBaselineMentalStatus, Boolean infectionSkinWound, Boolean infectionInvasiveDevice,
			Boolean infectionRecentSurgicalProcedure, Boolean isImmunocompromised, Double respiratoryPaOxyFiOxy,
			Double coagulationPlatelets, Double liverBilirubin, Double dopamine, Boolean anyDoputamine,
			Double epinephrine, Double norepinephrine, Double glasgowComaScale, Double renalCreatinine,
			Double urineOutput) {
		for (int i=0; i<observationList.size(); i++) {
			observationList.get(i);
		}
	}

}