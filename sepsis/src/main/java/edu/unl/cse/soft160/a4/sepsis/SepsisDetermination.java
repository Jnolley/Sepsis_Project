package edu.unl.cse.soft160.a4.sepsis;

public enum SepsisDetermination { 
		   CODE_BLUE, // patient with in-patient status is unresponsive
		   CONTINUE_MONITORING, // found no evidence of sepsis or septic shock
		   SEPTIC_SHOCK, // found evidence of septic shock
		   SEPSIS, //found evidence of sepsis 
		   NON_ADULT, //patient is not an adult
		   PREGNANT_PATIENT, //patient is pregnant
		   INDETERMINATE, //found too few data to make a determination }
}
