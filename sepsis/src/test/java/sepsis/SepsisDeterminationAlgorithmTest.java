package sepsis;

import org.junit.Test;

import edu.unl.cse.soft160.a4.sepsis.Observation;
import edu.unl.cse.soft160.a4.sepsis.Patient;
import edu.unl.cse.soft160.a4.sepsis.SepsisDetermination;
import edu.unl.cse.soft160.a4.sepsis.SepsisDeterminationAlgorithm;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class SepsisDeterminationAlgorithmTest {
	@Test
	public void testNotAdult() {
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		Observation observation1 = new Observation(false, 35.0, 120.0, 1.0, 1.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 150.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now().plusDays(-2));
		observationList.add(observation1);
		Observation observation2 = new Observation(false, 35.0, 120.0, 1.0, 4.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 500.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now());
		observationList.add(observation2);
		Patient patient = new Patient(observationList, 1, 1, 2010);
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.NON_ADULT, result);
	}

	@Test
	public void testPregnant() {
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		Observation observation1 = new Observation(false, 39.0, 120.0, 1.0, 1.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 150.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now().plusDays(-2));
		observationList.add(observation1);
		Observation observation2 = new Observation(true, 35.0, 100.0, 25.0, 4.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 500.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now());
		observationList.add(observation2);
		Patient patient = new Patient(observationList, 1, 1, 2002);
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.PREGNANT_PATIENT, result);
	}

	@Test
	public void testNotResponsive() {
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		Observation observation1 = new Observation(false, 35.0, 120.0, 1.0, 1.0, 1.0, 2.0, true, true, false, true,
				false, false, false, true, false, 2.0, 1.0, 2.0, 3.0, true, 1.0, 2.4, 2.2, 3.0, 4.0,
				LocalDate.now().plusDays(-2));
		observationList.add(observation1);
		Observation observation2 = new Observation(false, 35.0, 100.0, 1.0, 2.0, 1.0, 2.0, true, true, false, true,
				false, false, false, true, false, 2.0, 1.0, 2.0, 3.0, true, 1.0, 2.4, 2.2, 3.0, 4.0, LocalDate.now());
		observationList.add(observation2);
		observation2.setIsResponsive(false);
		Patient patient = new Patient(observationList, 1, 1, 2002);
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.CODE_BLUE, result);
	}

	@Test
	public void testStableNotSepsisNotOrganDysfunction() {
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		Observation observation1 = new Observation(false, 37.0, 120.0, 25.0, 4.0, 91.0, 2.0, true, false, true, false,
				false, false, false, false, false, 500.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now().plusDays(-2));
		observationList.add(observation1);
		Observation observation2 = new Observation(false, 37.0, 120.0, 25.0, 4.0, 91.0, 2.0, true, false, true, false,
				false, false, false, false, false, 500.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now());
		observationList.add(observation2);
		Patient patient = new Patient(observationList, 1, 1, 2002);
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.CONTINUE_MONITORING, result);

	}

	@Test
	public void testStableNotSepsisNotInfection() {
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		Observation observation1 = new Observation(false, 35.0, 120.0, 1.0, 1.0, 91.0, 200.0, true, false, true, false,
				false, false, false, false, false, 150.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now().plusDays(-2));
		observationList.add(observation1);
		Observation observation2 = new Observation(false, 35.0, 120.0, 1.0, 1.0, 91.0, 200.0, true, false, true, false,
				false, false, false, false, false, 500.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now());
		observationList.add(observation2);
		Patient patient = new Patient(observationList, 1, 1, 2002);
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.CONTINUE_MONITORING, result);

	}

	@Test
	public void testUnstableSepticShock() {
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		Observation observation1 = new Observation(false, 37.0, 120.0, 1.0, 1.0, 1.0, 2.0, true, false, true, false,
				false, false, false, true, true, 150.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now().plusDays(-2));
		observationList.add(observation1);
		Observation observation2 = new Observation(false, 37.0, 120.0, 1.0, 2.0, 1.0, 2.0, true, false, true, false,
				false, false, false, true, true, 500.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now());
		observationList.add(observation2);
		Patient patient = new Patient(observationList, 1, 1, 2002);
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.SEPTIC_SHOCK, result);

	}

	@Test
	public void testUnstableSepsis() {
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		Observation observation1 = new Observation(false, 37.0, 120.0, 1.0, 1.0, 100.0, 200.0, true, false, true, true,
				false, false, false, true, true, 150.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now().plusDays(-2));
		observationList.add(observation1);
		Observation observation2 = new Observation(false, 37.0, 100.0, 25.0, 2.0, 100.0, 200.0, true, false, true, true,
				false, false, false, true, true, 500.0, 18.0, 13.0, 16.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now());
		observationList.add(observation2);
		Patient patient = new Patient(observationList, 1, 1, 2002);
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.SEPSIS, result);
	}

	@Test
	public void testStableSepsis() {
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		Observation observation1 = new Observation(false, 35.0, 120.0, 1.0, 1.0, 91.0, 200.0, true, false, true, false,
				false, false, false, true, true, 150.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now().plusDays(-2));
		observationList.add(observation1);
		Observation observation2 = new Observation(false, 35.0, 120.0, 1.0, 1.0, 91.0, 200.0, true, false, true, false,
				false, false, false, true, true, 500.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now());
		observationList.add(observation2);
		Patient patient = new Patient(observationList, 1, 1, 2002);
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.SEPSIS, result);
	}

	@Test
	public void testStableSepticShock() {
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		Observation observation1 = new Observation(false, 35.0, 120.0, 1.0, 1.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 150.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now().plusDays(-2));
		observationList.add(observation1);
		Observation observation2 = new Observation(false, 35.0, 120.0, 1.0, 1.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 500.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now());
		observationList.add(observation2);
		Patient patient = new Patient(observationList, 1, 1, 2002);
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.SEPTIC_SHOCK, result);
	}

	@Test
	public void testNotResponsiveNotInpatientStatus() {
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		Observation observation1 = new Observation(false, 35.0, 120.0, 1.0, 1.0, 1.0, 2.0, true, true, false, true,
				false, false, false, true, false, 2.0, 1.0, 2.0, 3.0, true, 1.0, 2.4, 2.2, 3.0, 4.0,
				LocalDate.now().plusDays(-2));
		observationList.add(observation1);
		Observation observation2 = new Observation(false, 35.0, 100.0, 1.0, 2.0, 1.0, 2.0, true, true, false, true,
				false, false, false, true, false, 2.0, 1.0, 2.0, 3.0, true, 1.0, 2.4, 2.2, 3.0, 4.0, LocalDate.now());
		observationList.add(observation2);
		observation2.setIsResponsive(false);
		observation2.setIsInpatientStatus(false);
		Patient patient = new Patient(observationList, 1, 1, 2002);
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.INDETERMINATE, result);
	}

	@Test
	public void testIndeterminateNotEnoughData() {
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		Observation observation1 = new Observation(false, 37.0, 100.0, 25.0, 15.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 150.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now().plusDays(-2));
		observationList.add(observation1);
		Observation observation2 = new Observation(false, 37.0, null, 25.0, 15.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 500.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now());
		observationList.add(observation2);
		Patient patient = new Patient(observationList, 1, 1, 2002);
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.INDETERMINATE, result);
	}

	@Test
	public void testNoCurrentObservationExist() {
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		Observation observation1 = new Observation(false, 37.0, 100.0, 25.0, 15.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 150.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now().plusDays(-2));
		observationList.add(observation1);
		Observation observation2 = new Observation(false, 37.0, 100.0, 25.0, 15.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 500.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now().plusDays(-2));
		observationList.add(observation2);
		Patient patient = new Patient(observationList, 1, 1, 2002);
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.INDETERMINATE, result);
	}

	@Test
	public void testNoBaselineObservationExist() {
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		Observation observation1 = new Observation(false, 37.0, 100.0, 25.0, 15.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 150.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now().plusDays(-3));
		observationList.add(observation1);
		Observation observation2 = new Observation(false, 37.0, 100.0, 25.0, 15.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 500.0, 18.0, 13.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 100.0,
				LocalDate.now().plusDays(-1));
		observationList.add(observation2);
		Patient patient = new Patient(observationList, 1, 1, 2002);
		SepsisDetermination result = SepsisDeterminationAlgorithm.analyze(patient);
		assertEquals(SepsisDetermination.INDETERMINATE, result);
	}

	@Test
	public void testComputeSOFAScore0() {
		Observation observation = new Observation(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 300.0, 160.0, 1.0, 1.0, true, 0.2, 0.2, 15.0, 1.0, 600.0,
				LocalDate.now().plusDays(-2));
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(observation);
		assertEquals(0, score);
	}

	@Test
	public void testComputeSOFAScore1() {
		Observation observation = new Observation(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 250.0, 110.0, 1.5, 1.0, true, 0.2, 0.2, 13.0, 1.5, 600.0,
				LocalDate.now().plusDays(-2));
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(observation);
		assertEquals(1, score);
	}

	@Test
	public void testComputeSOFAScore7() {
		Observation observation = new Observation(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 250.0, 110.0, 1.5, 1.0, true, 0.2, 0.2, 14.0, 1.5, 600.0,
				LocalDate.now().plusDays(-2));
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(observation);
		assertEquals(1, score);
	}

	@Test
	public void testComputeSOFAScore2() {
		Observation observation = new Observation(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 150.0, 60.0, 2.5, 6.0, false, 0.0, 0.0, 10.0, 2.6, 100.0,
				LocalDate.now().plusDays(-2));
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(observation);
		assertEquals(2, score);
	}

	@Test
	public void testComputeSOFAScore3() {
		Observation observation = new Observation(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 7.0, 4.0, 500.0,
				LocalDate.now().plusDays(-2));
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(observation);
		assertEquals(3, score);
	}

	@Test
	public void testComputeSOFAScore4() {
		Observation observation = new Observation(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 7.0, 6.0, 1000.0,
				LocalDate.now().plusDays(-2));
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(observation);
		assertEquals(3, score);
	}

	@Test
	public void testComputeSOFAScore5() {
		Observation observation = new Observation(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 7.0, 6.0, 1000.0,
				LocalDate.now().plusDays(-2));
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(observation);
		assertEquals(3, score);
	}

	@Test
	public void testComputeSOFAScore6() {
		Observation observation = new Observation(false, null, null, null, 1.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0,
				LocalDate.now().plusDays(-2));
		int score = SepsisDeterminationAlgorithm.computeSOFAScore(observation);
		assertEquals(3, score);
	}

	@Test
	public void testDecideSIRSCriteria1() {
		Observation observation = new Observation(false, 35.0, 100.0, 25.0, 5.0, 91.0, 5.0, true, false, true, false,
				false, false, false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0,
				LocalDate.now().plusDays(-2));
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(observation);
		assertEquals(true, result);
	}

	@Test
	public void testDecideSIRSCriteria2() {
		Observation observation = new Observation(false, 40.0, 100.0, 20.0, 2.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0,
				LocalDate.now().plusDays(-2));
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(observation);
		assertEquals(true, result);
	}

	@Test
	public void testDecideSIRSCriteria3() {
		Observation observation = new Observation(false, 37.0, 100.0, 25.0, 2.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0,
				LocalDate.now().plusDays(-2));
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(observation);
		assertEquals(true, result);
	}

	@Test
	public void testDecideSIRSCriteria4() {
		Observation observation = new Observation(false, 40.0, 100.0, 20.0, 200.0, 91.0, 2.0, true, false, true, false,
				false, false, false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0,
				LocalDate.now().plusDays(-2));
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(observation);
		assertEquals(true, result);
	}

	@Test
	public void testDecideSIRSCriteria5() {
		Observation observation = new Observation(false, 35.0, 100.0, 20.0, 5.0, 91.0, 5.0, true, false, true, false,
				false, false, false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0,
				LocalDate.now().plusDays(-2));
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(observation);
		assertEquals(false, result);
	}

	@Test
	public void testDecideSIRSCriteria6() {
		Observation observation = new Observation(false, 37.0, 100.0, 25.0, 15.0, 91.0, 5.0, true, false, true, false,
				false, false, false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0,
				LocalDate.now().plusDays(-2));
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(observation);
		assertEquals(true, result);
	}

	@Test
	public void testDecideSIRSCriteria7() {
		Observation observation = new Observation(false, 37.0, 150.0, 20.0, 15.0, 91.0, 5.0, true, false, true, false,
				false, false, false, true, true, 50.0, 30.0, 7.0, 6.0, false, 0.2, 0.2, 5.0, 6.0, 1000.0,
				LocalDate.now().plusDays(-2));
		boolean result = SepsisDeterminationAlgorithm.decideSIRSCriteria(observation);
		assertEquals(true, result);
	}
}
