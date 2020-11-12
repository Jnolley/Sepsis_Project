package edu.unl.cse.soft160.a4.sepsis;

import java.time.LocalDateTime;

public class Observation {
	private LocalDateTime timestamp;
	private Concept concept;

	public Observation(LocalDateTime timestamp, Concept concept) {
		this.timestamp = timestamp;
		this.concept = concept;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public Concept getConcept() {
		return concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}
}
