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
	// Constructor

	// Getters and Setters
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
