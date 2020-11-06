package edu.unl.cse.soft160.a4.sepsis;

public class Observation {
	private Boolean isPregnant;
	private Double temperature;
	private Double heartRate;
	private Double respiratoryRate;
	private Double wBCCount;
	private Double systolicBloodPressure;
	private Double diastolicBloodPressure;
	private Boolean isInpatientStatus;
	private Boolean needForVasopressorSupport;
	private Boolean isResponsive;
	private Boolean cardiacArrhythmia;
	private Boolean declineInBaselineMentalStatus;
	private Boolean infectionSkinWound;
	private Boolean infectionInvasiveDevice;
	private Boolean infectionRecentSurgicalProcedure;
	private Boolean isImmunocompromised;
	private Double respiratoryPaOxyFiOxy;
	private Double coagulationPlatelets;
	private Double liverBilirubin;
	private Double dopamine;
	private Boolean anyDoputamine;
	private Double epinephrine;
	private Double norepinephrine;
	private Double glasgowComaScale;
	private Double renalCreatinine;
	private Double urineOutput;
	private Integer birthDay;
	private Integer birthMonth;
	private Integer birthYear;

	public Observation(Boolean isPregnant, Double temperature, Double heartRate, Double respiratoryRate,
			Double wBCCount, Double systolicBloodPressure, Double diastolicBloodPressure, Boolean isInpatientStatus,
			Boolean needForVasopressorSupport, Boolean isResponsive, Boolean cardiacArrhythmia,
			Boolean declineInBaselineMentalStatus, Boolean infectionSkinWound, Boolean infectionInvasiveDevice,
			Boolean infectionRecentSurgicalProcedure, Boolean isImmunocompromised, Double respiratoryPaOxyFiOxy,
			Double coagulationPlatelets, Double liverBilirubin, Double dopamine, Boolean anyDoputamine,
			Double epinephrine, Double norepinephrine, Double glasgowComaScale, Double renalCreatinine,
			Double urineOutput, Integer birthDay, Integer birthMonth, Integer birthYear) {
		super();
		this.isPregnant = isPregnant;
		this.temperature = temperature;
		this.heartRate = heartRate;
		this.respiratoryRate = respiratoryRate;
		this.wBCCount = wBCCount;
		this.systolicBloodPressure = systolicBloodPressure;
		this.diastolicBloodPressure = diastolicBloodPressure;
		this.isInpatientStatus = isInpatientStatus;
		this.needForVasopressorSupport = needForVasopressorSupport;
		this.isResponsive = isResponsive;
		this.cardiacArrhythmia = cardiacArrhythmia;
		this.declineInBaselineMentalStatus = declineInBaselineMentalStatus;
		this.infectionSkinWound = infectionSkinWound;
		this.infectionInvasiveDevice = infectionInvasiveDevice;
		this.infectionRecentSurgicalProcedure = infectionRecentSurgicalProcedure;
		this.isImmunocompromised = isImmunocompromised;
		this.respiratoryPaOxyFiOxy = respiratoryPaOxyFiOxy;
		this.coagulationPlatelets = coagulationPlatelets;
		this.liverBilirubin = liverBilirubin;
		this.dopamine = dopamine;
		this.anyDoputamine = anyDoputamine;
		this.epinephrine = epinephrine;
		this.norepinephrine = norepinephrine;
		this.glasgowComaScale = glasgowComaScale;
		this.renalCreatinine = renalCreatinine;
		this.urineOutput = urineOutput;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
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

	public Double getwBCCount() {
		return wBCCount;
	}

	public void setwBCCount(Double wBCCount) {
		this.wBCCount = wBCCount;
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

	public Boolean getIsInpatientStatus() {
		return isInpatientStatus;
	}

	public void setIsInpatientStatus(Boolean isInpatientStatus) {
		this.isInpatientStatus = isInpatientStatus;
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

	public Boolean getInfectionSkinWound() {
		return infectionSkinWound;
	}

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

	public Double getRespiratoryPaOxyFiOxy() {
		return respiratoryPaOxyFiOxy;
	}

	public void setRespiratoryPaOxyFiOxy(Double respiratoryPaOxyFiOxy) {
		this.respiratoryPaOxyFiOxy = respiratoryPaOxyFiOxy;
	}

	public Double getCoagulationPlatelets() {
		return coagulationPlatelets;
	}

	public void setCoagulationPlatelets(Double coagulationPlatelets) {
		this.coagulationPlatelets = coagulationPlatelets;
	}

	public Double getLiverBilirubin() {
		return liverBilirubin;
	}

	public void setLiverBilirubin(Double liverBilirubin) {
		this.liverBilirubin = liverBilirubin;
	}

	public Double getDopamine() {
		return dopamine;
	}

	public void setDopamine(Double dopamine) {
		this.dopamine = dopamine;
	}

	public Boolean getAnyDoputamine() {
		return anyDoputamine;
	}

	public void setAnyDoputamine(Boolean anyDoputamine) {
		this.anyDoputamine = anyDoputamine;
	}

	public Double getEpinephrine() {
		return epinephrine;
	}

	public void setEpinephrine(Double epinephrine) {
		this.epinephrine = epinephrine;
	}

	public Double getNorepinephrine() {
		return norepinephrine;
	}

	public void setNorepinephrine(Double norepinephrine) {
		this.norepinephrine = norepinephrine;
	}

	public Double getGlasgowComaScale() {
		return glasgowComaScale;
	}

	public void setGlasgowComaScale(Double glasgowComaScale) {
		this.glasgowComaScale = glasgowComaScale;
	}

	public Double getRenalCreatinine() {
		return renalCreatinine;
	}

	public void setRenalCreatinine(Double renalCreatinine) {
		this.renalCreatinine = renalCreatinine;
	}

	public Double getUrineOutput() {
		return urineOutput;
	}

	public void setUrineOutput(Double urineOutput) {
		this.urineOutput = urineOutput;
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
