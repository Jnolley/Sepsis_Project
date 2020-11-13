package sepsis;

import org.junit.Test;

import edu.unl.cse.soft160.a4.sepsis.Concept;
import edu.unl.cse.soft160.a4.sepsis.Observation;
import edu.unl.cse.soft160.a4.sepsis.Patient;
import edu.unl.cse.soft160.a4.sepsis.SepsisDetermination;
import edu.unl.cse.soft160.a4.sepsis.SepsisDeterminationAlgorithm;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SepsisDeterminationAlgorithmTest {
	@Test
	public void testNotAdult() {
		ArrayList<Observation> ObservationList = new ArrayList<Observation>();
		Concept concept1 = new Concept(false, 35.0, 120.0, 1.0, 1.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 150.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation1 = new Observation(LocalDateTime.now().plusDays(-2), concept1);
		ObservationList.add(observation1);
		Concept concept2 = new Concept(false, 35.0, 120.0, 1.0, 4.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 500.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation2 = new Observation(LocalDateTime.now(), concept2);
		ObservationList.add(observation2);
		Patient patient = new Patient(ObservationList, LocalDate.of(2010, 1, 1));
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.NON_ADULT, result);
	}

	@Test
	public void testPregnant() {
		ArrayList<Observation> ObservationList = new ArrayList<Observation>();
		Concept concept1 = new Concept(false, 39.0, 120.0, 1.0, 1.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 150.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation1 = new Observation(LocalDateTime.now().plusDays(-2), concept1);
		ObservationList.add(observation1);
		Concept concept2 = new Concept(true, 35.0, 100.0, 25.0, 4.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 500.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation2 = new Observation(LocalDateTime.now(), concept2);
		ObservationList.add(observation2);
		Patient patient = new Patient(ObservationList, LocalDate.of(2002, 1, 1));
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.PREGNANT_PATIENT, result);
	}

	@Test
	public void testNotResponsive() {
		ArrayList<Observation> ObservationList = new ArrayList<Observation>();
		Concept concept1 = new Concept(false, 35.0, 120.0, 1.0, 1.0, 1.0, 2.0, true, true, false, true, false, false,
				false, true, false, 2.0, 1.0, 2.0, 3.0, true, 1.0, 2.4, 2.2, 3.0, 4.0);
		Observation observation1 = new Observation(LocalDateTime.now().plusDays(-2), concept1);
		ObservationList.add(observation1);
		Concept concept2 = new Concept(false, 35.0, 100.0, 1.0, 2.0, 1.0, 2.0, true, true, false, true, false, false,
				false, true, false, 2.0, 1.0, 2.0, 3.0, true, 1.0, 2.4, 2.2, 3.0, 4.0);
		Observation observation2 = new Observation(LocalDateTime.now(), concept2);
		ObservationList.add(observation2);
		concept2.setIsResponsive(false);
		Patient patient = new Patient(ObservationList, LocalDate.of(2002, 1, 1));
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.CODE_BLUE, result);
	}

	@Test
	public void testStableNotSepsisNotOrganDysfunction() {
		ArrayList<Observation> ObservationList = new ArrayList<Observation>();
		Concept concept1 = new Concept(false, 37.0, 120.0, 25.0, 4.0, 91.0, 2.0, true, false, true, false, false, false,
				false, false, false, 500.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation1 = new Observation(LocalDateTime.now().plusDays(-2), concept1);
		ObservationList.add(observation1);
		Concept concept2 = new Concept(false, 37.0, 120.0, 25.0, 4.0, 91.0, 2.0, true, false, true, false, false, false,
				false, false, false, 500.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation2 = new Observation(LocalDateTime.now(), concept2);
		ObservationList.add(observation2);
		Patient patient = new Patient(ObservationList, LocalDate.of(2002, 1, 1));
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.CONTINUE_MONITORING, result);

	}

	@Test
	public void testStableNotSepsisNotInfection() {
		ArrayList<Observation> ObservationList = new ArrayList<Observation>();
		Concept concept1 = new Concept(false, 35.0, 120.0, 1.0, 1.0, 91.0, 200.0, true, false, true, false, false,
				false, false, false, false, 150.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation1 = new Observation(LocalDateTime.now().plusDays(-2), concept1);
		ObservationList.add(observation1);
		Concept concept2 = new Concept(false, 35.0, 120.0, 1.0, 1.0, 91.0, 200.0, true, false, true, false, false,
				false, false, false, false, 500.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation2 = new Observation(LocalDateTime.now(), concept2);
		ObservationList.add(observation2);
		Patient patient = new Patient(ObservationList, LocalDate.of(2002, 1, 1));
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.CONTINUE_MONITORING, result);

	}

	@Test
	public void testUnstableSepticShock() {
		ArrayList<Observation> ObservationList = new ArrayList<Observation>();
		Concept concept1 = new Concept(false, 37.0, 120.0, 1.0, 1.0, 1.0, 2.0, true, false, true, false, false, false,
				false, true, true, 150.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation1 = new Observation(LocalDateTime.now().plusDays(-2), concept1);
		ObservationList.add(observation1);
		Concept concept2 = new Concept(false, 37.0, 120.0, 1.0, 2.0, 1.0, 2.0, true, false, true, false, false, false,
				false, true, true, 500.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation2 = new Observation(LocalDateTime.now(), concept2);
		ObservationList.add(observation2);
		Patient patient = new Patient(ObservationList, LocalDate.of(2002, 1, 1));
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.SEPTIC_SHOCK, result);

	}

	@Test
	public void testUnstableSepsis() {
		ArrayList<Observation> ObservationList = new ArrayList<Observation>();
		Concept concept1 = new Concept(false, 37.0, 120.0, 1.0, 1.0, 100.0, 200.0, true, false, true, true, false,
				false, false, true, true, 150.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation1 = new Observation(LocalDateTime.now().plusDays(-2), concept1);
		ObservationList.add(observation1);
		Concept concept2 = new Concept(false, 37.0, 100.0, 25.0, 2.0, 100.0, 200.0, true, false, true, true, false,
				false, false, true, true, 500.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation2 = new Observation(LocalDateTime.now(), concept2);
		ObservationList.add(observation2);
		Patient patient = new Patient(ObservationList, LocalDate.of(2002, 1, 1));
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.SEPSIS, result);
	}

	@Test
	public void testStableSepsis() {
		ArrayList<Observation> ObservationList = new ArrayList<Observation>();
		Concept concept1 = new Concept(false, 35.0, 120.0, 1.0, 1.0, 91.0, 200.0, true, false, true, false, false,
				false, false, true, true, 150.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation1 = new Observation(LocalDateTime.now().plusDays(-2), concept1);
		ObservationList.add(observation1);
		Concept concept2 = new Concept(false, 35.0, 120.0, 1.0, 1.0, 91.0, 200.0, true, false, true, false, false,
				false, false, true, true, 500.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation2 = new Observation(LocalDateTime.now(), concept2);
		ObservationList.add(observation2);
		Patient patient = new Patient(ObservationList, LocalDate.of(2002, 1, 1));
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.SEPSIS, result);
	}

	@Test
	public void testStableSepticShock() {
		ArrayList<Observation> ObservationList = new ArrayList<Observation>();
		Concept concept1 = new Concept(false, 35.0, 120.0, 1.0, 1.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 150.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation1 = new Observation(LocalDateTime.now().plusDays(-2), concept1);
		ObservationList.add(observation1);
		Concept concept2 = new Concept(false, 35.0, 120.0, 1.0, 1.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 500.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation2 = new Observation(LocalDateTime.now(), concept2);
		ObservationList.add(observation2);
		Patient patient = new Patient(ObservationList, LocalDate.of(2002, 1, 1));
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.SEPTIC_SHOCK, result);
	}

	@Test
	public void testNotResponsiveNotInpatientStatus() {
		ArrayList<Observation> ObservationList = new ArrayList<Observation>();
		Concept concept1 = new Concept(false, 35.0, 120.0, 1.0, 1.0, 1.0, 2.0, true, true, false, true, false, false,
				false, true, false, 2.0, 1.0, 2.0, 3.0, true, 1.0, 2.4, 2.2, 3.0, 4.0);
		Observation observation1 = new Observation(LocalDateTime.now().plusDays(-2), concept1);
		ObservationList.add(observation1);
		Concept concept2 = new Concept(false, 35.0, 100.0, 1.0, 2.0, 1.0, 2.0, true, true, false, true, false, false,
				false, true, false, 2.0, 1.0, 2.0, 3.0, true, 1.0, 2.4, 2.2, 3.0, 4.0);
		Observation observation2 = new Observation(LocalDateTime.now(), concept2);
		ObservationList.add(observation2);
		concept2.setIsResponsive(false);
		concept2.setIsInpatientStatus(false);
		Patient patient = new Patient(ObservationList, LocalDate.of(2002, 1, 1));
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.INDETERMINATE, result);
	}

	@Test
	public void testIndeterminateNotEnoughData() {
		ArrayList<Observation> ObservationList = new ArrayList<Observation>();
		Concept concept1 = new Concept(false, 37.0, 100.0, 25.0, 15.0, 91.0, 2.0, true, false, true, false, false,
				false, false, true, true, 150.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation1 = new Observation(LocalDateTime.now().plusDays(-2), concept1);
		ObservationList.add(observation1);
		Concept concept2 = new Concept(false, 37.0, null, 25.0, 15.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 500.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation2 = new Observation(LocalDateTime.now(), concept2);
		ObservationList.add(observation2);
		Patient patient = new Patient(ObservationList, LocalDate.of(2002, 1, 1));
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.INDETERMINATE, result);
	}

	@Test
	public void testNoCurrentConceptExist() {
		ArrayList<Observation> ObservationList = new ArrayList<Observation>();
		Concept concept1 = new Concept(false, 37.0, 100.0, 25.0, 15.0, 91.0, 2.0, true, false, true, false, false,
				false, false, true, true, 150.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation1 = new Observation(LocalDateTime.now().plusDays(-2), concept1);
		ObservationList.add(observation1);
		Concept concept2 = new Concept(false, 37.0, 100.0, 25.0, 15.0, 91.0, 2.0, true, false, true, false, false,
				false, false, true, true, 500.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation2 = new Observation(LocalDateTime.now().plusDays(-2), concept2);
		ObservationList.add(observation2);
		Patient patient = new Patient(ObservationList, LocalDate.of(2002, 1, 1));
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.INDETERMINATE, result);
	}

	@Test
	public void testNoBaselineConceptExist() {
		ArrayList<Observation> ObservationList = new ArrayList<Observation>();
		Concept concept1 = new Concept(false, 37.0, 100.0, 25.0, 15.0, 91.0, 2.0, true, false, true, false, false,
				false, false, true, true, 150.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation1 = new Observation(LocalDateTime.now().plusDays(-3), concept1);
		ObservationList.add(observation1);
		Concept concept2 = new Concept(false, 37.0, 100.0, 25.0, 15.0, 91.0, 2.0, true, false, true, false, false,
				false, false, true, true, 500.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0);
		Observation observation2 = new Observation(LocalDateTime.now().plusDays(-1), concept2);
		ObservationList.add(observation2);
		Patient patient = new Patient(ObservationList, LocalDate.of(2002, 1, 1));
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.INDETERMINATE, result);
	}

	@Test
	public void testComputeSOFAScore0() {
		Concept concept = new Concept(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 300.0, 160.0, 1.0, 1.0, true, 0.2, 0.2, 15.0, 1.0, 600.0);
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(concept);
		assertEquals(0, score);
	}

	@Test
	public void testComputeSOFAScore1() {
		Concept concept = new Concept(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 250.0, 110.0, 1.5, 1.0, true, 0.2, 0.2, 13.0, 1.5, 600.0);
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(concept);
		assertEquals(1, score);
	}

	@Test
	public void testComputeSOFAScore7() {
		Concept concept = new Concept(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 250.0, 110.0, 1.5, 1.0, true, 0.2, 0.2, 14.0, 1.5, 600.0);
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(concept);
		assertEquals(1, score);
	}

	@Test
	public void testComputeSOFAScore2() {
		Concept concept = new Concept(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 150.0, 60.0, 2.5, 6.0, false, 0.0, 0.0, 10.0, 2.6, 100.0);
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(concept);
		assertEquals(2, score);
	}

	@Test
	public void testComputeSOFAScore3() {
		Concept concept = new Concept(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 7.0, 4.0, 500.0);
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(concept);
		assertEquals(3, score);
	}

	@Test
	public void testComputeSOFAScore4() {
		Concept concept = new Concept(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 7.0, 6.0, 1000.0);
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(concept);
		assertEquals(3, score);
	}

	@Test
	public void testComputeSOFAScore5() {
		Concept concept = new Concept(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 7.0, 6.0, 1000.0);
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(concept);
		assertEquals(3, score);
	}

	@Test
	public void testComputeSOFAScore6() {
		Concept concept = new Concept(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0);
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(concept);
		assertEquals(3, score);
	}

	@Test
	public void testDecideSIRSCriteria1() {
		Concept concept = new Concept(false, 35.0, 100.0, 25.0, 5.0, 91.0, 5.0, true, false, true, false, false, false,
				false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0);
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(concept);
		assertEquals(true, result);
	}

	@Test
	public void testDecideSIRSCriteria2() {
		Concept concept = new Concept(false, 40.0, 100.0, 20.0, 2.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0);
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(concept);
		assertEquals(true, result);
	}

	@Test
	public void testDecideSIRSCriteria3() {

		Concept concept = new Concept(false, 37.0, 100.0, 25.0, 2.0, 91.0, 2.0, true, false, true, false, false, false,
				false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0);
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(concept);
		assertEquals(true, result);
	}

	@Test
	public void testDecideSIRSCriteria4() {
		Concept concept = new Concept(false, 40.0, 100.0, 20.0, 200.0, 91.0, 2.0, true, false, true, false, false,
				false, false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0);
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(concept);
		assertEquals(true, result);
	}

	@Test
	public void testDecideSIRSCriteria5() {
		Concept concept = new Concept(false, 35.0, 100.0, 20.0, 5.0, 91.0, 5.0, true, false, true, false, false, false,
				false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0);
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(concept);
		assertEquals(false, result);
	}

	@Test
	public void testDecideSIRSCriteria6() {
		Concept concept = new Concept(false, 37.0, 100.0, 25.0, 15.0, 91.0, 5.0, true, false, true, false, false, false,
				false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0);
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(concept);
		assertEquals(true, result);
	}

	@Test
	public void testDecideSIRSCriteria7() {
		Concept concept = new Concept(false, 37.0, 150.0, 20.0, 15.0, 91.0, 5.0, true, false, true, false, false, false,
				false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0);
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(concept);
		assertEquals(true, result);
	}
}
