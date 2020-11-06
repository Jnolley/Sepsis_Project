package edu.unl.cse.soft160.a4.sepsis;

public class Observation {
	// Field Declaration
	private Boolean isImpatient;
	private Boolean isPregnant;
	private Double temperature;
	private Double heartRate;
	private Double respiratoryRate;
	private Double wbcCount;
	private Double systolicBloodPressure;
	private Double diastolicBloodPressure;
	private Boolean needForVasopressorSupport;
	private Boolean isResponsive;
	private Boolean isStable;
	private Boolean cardiacArrhythmia;
	private Boolean declineInBaselineMentalStatus;
	private Boolean infectionSkinWound;
	private Boolean infectionInvasiveDevice;
	private Boolean infectionRecentSurgicalProcedure;	
	private Boolean isImmunocompromised;	
	private Boolean respiratoryPaOxFiOx;
	private Boolean coagulationPlatelets;
	private Boolean liverBilirubin;
	private Boolean cardiovascularHypotension;
	private Boolean centralNervousGlasgow;
	private Boolean renalCreatineUrine;
	private Boolean presenceOfOrganDysfunction;

	// Constructor
	public Boolean getInfectionSkinWound() {
		return infectionSkinWound;
	}

	public Observation(Boolean isImpatient, Boolean isPregnant, Double temperature, Double heartRate,
			Double respiratoryRate, Double wbcCount, Double systolicBloodPressure, Double diastolicBloodPressure,
			Boolean needForVasopressorSupport, Boolean isResponsive, Boolean isStable, Boolean cardiacArrhythmia,
			Boolean declineInBaselineMentalStatus, Boolean infectionSkinWound, Boolean infectionInvasiveDevice,
			Boolean infectionRecentSurgicalProcedure, Boolean isImmunocompromised, Boolean respiratoryPaOxFiOx,
			Boolean coagulationPlatelets, Boolean liverBilirubin, Boolean cardiovascularHypotension,
			Boolean centralNervousGlasgow, Boolean renalCreatineUrine, Boolean presenceOfOrganDysfunction) {
		super();
		this.isImpatient = isImpatient;
		this.isPregnant = isPregnant;
		this.temperature = temperature;
		this.heartRate = heartRate;
		this.respiratoryRate = respiratoryRate;
		this.wbcCount = wbcCount;
		this.systolicBloodPressure = systolicBloodPressure;
		this.diastolicBloodPressure = diastolicBloodPressure;
		this.needForVasopressorSupport = needForVasopressorSupport;
		this.isResponsive = isResponsive;
		this.isStable = isStable;
		this.cardiacArrhythmia = cardiacArrhythmia;
		this.declineInBaselineMentalStatus = declineInBaselineMentalStatus;
		this.infectionSkinWound = infectionSkinWound;
		this.infectionInvasiveDevice = infectionInvasiveDevice;
		this.infectionRecentSurgicalProcedure = infectionRecentSurgicalProcedure;
		this.isImmunocompromised = isImmunocompromised;
		this.respiratoryPaOxFiOx = respiratoryPaOxFiOx;
		this.coagulationPlatelets = coagulationPlatelets;
		this.liverBilirubin = liverBilirubin;
		this.cardiovascularHypotension = cardiovascularHypotension;
		this.centralNervousGlasgow = centralNervousGlasgow;
		this.renalCreatineUrine = renalCreatineUrine;
		this.presenceOfOrganDysfunction = presenceOfOrganDysfunction;
	}	

	// Getters and Setters
	


	public void setInfectionSkinWound(Boolean infectionSkinWound) {
		this.infectionSkinWound = infectionSkinWound;
	}

	public Boolean getInfectionInvasiveDevice() {
		return infectionInvasiveDevice;
	}

	public void setInfectionInvasiveDevice(Boolean infectionInvasiveDevice) {
		this.infectionInvasiveDevice = infectionInvasiveDevice;
	}

	public Boolean getInfectionRecentSurgicalProcedure() {
		return infectionRecentSurgicalProcedure;
	}

	public void setInfectionRecentSurgicalProcedure(Boolean infectionRecentSurgicalProcedure) {
		this.infectionRecentSurgicalProcedure = infectionRecentSurgicalProcedure;
	}

	public Boolean getIsImmunocompromised() {
		return isImmunocompromised;
	}

	public void setIsImmunocompromised(Boolean isImmunocompromised) {
		this.isImmunocompromised = isImmunocompromised;
	}

	public Boolean getPresenceOfOrganDysfunction() {
		return presenceOfOrganDysfunction;
	}

	public void setPresenceOfOrganDysfunction(Boolean presenceOfOrganDysfunction) {
		this.presenceOfOrganDysfunction = presenceOfOrganDysfunction;
	}

	public Boolean getRespiratoryPaOxFiOx() {
		return respiratoryPaOxFiOx;
	}

	public void setRespiratoryPaOxFiOx(Boolean respiratoryPaOxFiOx) {
		this.respiratoryPaOxFiOx = respiratoryPaOxFiOx;
	}

	public Boolean getCoagulationPlatelets() {
		return coagulationPlatelets;
	}

	public void setCoagulationPlatelets(Boolean coagulationPlatelets) {
		this.coagulationPlatelets = coagulationPlatelets;
	}

	public Boolean getLiverBilirubin() {
		return liverBilirubin;
	}

	public void setLiverBilirubin(Boolean liverBilirubin) {
		this.liverBilirubin = liverBilirubin;
	}

	public Boolean getCardiovascularHypotension() {
		return cardiovascularHypotension;
	}

	public void setCardiovascularHypotension(Boolean cardiovascularHypotension) {
		this.cardiovascularHypotension = cardiovascularHypotension;
	}

	public Boolean getCentralNervousGlasgow() {
		return centralNervousGlasgow;
	}

	public void setCentralNervousGlasgow(Boolean centralNervousGlasgow) {
		this.centralNervousGlasgow = centralNervousGlasgow;
	}

	public Boolean getRenalCreatineUrine() {
		return renalCreatineUrine;
	}

	public void setRenalCreatineUrine(Boolean renalCreatineUrine) {
		this.renalCreatineUrine = renalCreatineUrine;
	}

	public Boolean getIsImpatient() {
		return isImpatient;
	}

	public void setIsImpatient(Boolean isImpatient) {
		this.isImpatient = isImpatient;
	}

	public Boolean getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(Double heartRate) {
		this.heartRate = heartRate;
	}

	public Double getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(Double respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public Double getWbcCount() {
		return wbcCount;
	}

	public void setWbcCount(Double wbcCount) {
		this.wbcCount = wbcCount;
	}

	public Double getSystolicBloodPressure() {
		return systolicBloodPressure;
	}

	public void setSystolicBloodPressure(Double systolicBloodPressure) {
		this.systolicBloodPressure = systolicBloodPressure;
	}

	public Double getDiastolicBloodPressure() {
		return diastolicBloodPressure;
	}

	public void setDiastolicBloodPressure(Double diastolicBloodPressure) {
		this.diastolicBloodPressure = diastolicBloodPressure;
	}

	public Boolean getNeedForVasopressorSupport() {
		return needForVasopressorSupport;
	}

	public void setNeedForVasopressorSupport(Boolean needForVasopressorSupport) {
		this.needForVasopressorSupport = needForVasopressorSupport;
	}

	public Boolean getIsResponsive() {
		return isResponsive;
	}

	public void setIsResponsive(Boolean isResponsive) {
		this.isResponsive = isResponsive;
	}

	public Boolean getIsStable() {
		return isStable;
	}

	public void setIsStable(Boolean isStable) {
		this.isStable = isStable;
	}

	public Boolean getCardiacArrhythmia() {
		return cardiacArrhythmia;
	}

	public void setCardiacArrhythmia(Boolean cardiacArrhythmia) {
		this.cardiacArrhythmia = cardiacArrhythmia;
	}

	public Boolean getDeclineInBaselineMentalStatus() {
		return declineInBaselineMentalStatus;
	}

	public void setDeclineInBaselineMentalStatus(Boolean declineInBaselineMentalStatus) {
		this.declineInBaselineMentalStatus = declineInBaselineMentalStatus;
	}

}
