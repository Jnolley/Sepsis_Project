package edu.unl.cse.soft160.a4.sepsis;

import java.time.LocalDateTime;

public class Observation {
	private LocalDateTime timestamp;
	private String concept;
	private Double DMeasurement;
	private Boolean BMeasurement;

	public Observation(LocalDateTime timestamp, String concept, Double DMeasurement) {
		this.timestamp = timestamp;
		this.concept = concept;
		this.DMeasurement = DMeasurement;
	}

	public Observation(LocalDateTime timestamp, String concept, Boolean BMeasurement) {
		this.timestamp = timestamp;
		this.concept = concept;
		this.BMeasurement = BMeasurement;
	}

	public Observation(String concept) {
		super();
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getConcept() {
		return concept;
	}

	public Double getDMeasurement() {
		return DMeasurement;
	}

	public String getMeasurement() {
		if (DMeasurement != null || BMeasurement == null) {
			return String.valueOf(DMeasurement);
		} else if (BMeasurement) {
			return "Yes";
		} else {
			return "No";
		}
	}

	public void setDMeasurement(Double DMeasurement) {
		this.DMeasurement = DMeasurement;
	}

	public Boolean getBMeasurement() {
		return BMeasurement;
	}

	public void setBMeasurement(Boolean BMeasurement) {
		this.BMeasurement = BMeasurement;
	}
}
