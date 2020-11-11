# Sepsis Determination App

The Sepsis detection app connects to OpenMRS and, given a patient ID,
automatically determines whether or not that patient has symptoms indicative of
Sepsis using the MD Anderson Cancer Center Sepsis determination algorithm. The app will report one of seven outcomes. It could report that the patient has Sepsis or has experienced Septic Shock. It could report that the algorithm could not be run because the patient is either pregnant or is not an adult. It could report a Code Blue meaning the patient is unresponsive. It could report that the patient should continued to be monitored. If the algorithm fails then it will report Indeterminate.

Project status: **feature-complete, fully tested, no test failures, and no known
bugs**

Authors:
*   Adam Kamrath <akamrath2@huskers.unl.edu>
*   Harry Do <hdo7@huskers.unl.edu>
*   Jack Nolley <jackmnolley@gmail.com>
*   Nathan Srisa-an <>


## Dependencies

The heart failure detection app depends on
[the OpenMRS REST connector](https://git.unl.edu/soft-core/soft-160/openmrs-rest-connector).
The REST connector must be in the project's build path during development and
the project's classpath when the app is run.

To run, the REST connector in turn requires a running instance of OpenMRS either
on the same computer or accessible over a network.

For development, JUnit 4 is required to run the project's unit tests.

## Building

The app can be built and packaged as a JAR by running `mvn package` from the
`sepsis` folder. The project can also be imported into Eclipse, in which
case Eclipse will build the `.class` files, but not a JAR.

## Running

For development, `SepsisDeterminationApp.java` can be run in Eclipse by
right-clicking on it in the "Package Explorer" and selecting "Run As" → "Java
Application".

Once packaged, the app can be run with the command

````
java -jar sepsis.jar
````

where `sepsis.jar` is the name of the JAR that was built (which may vary
depending on your Maven configuration.)

The Sepsis determination app will prompt for the URI, port number, and
login credentials to the OpenMRS server. Enter this information as requested.

The app will then prompt the user for a patient ID. Once the patient ID has been
entered, the app will print a report for that patient. If the patient ID is left
blank, the app will exit.

## Software Architecture

The Sepsis detection app is organized into three tiers: a connector to
the OpenMRS backend&nbsp;(`rest_backend`), an implementation of the Sepsis determination algorithm&nbsp;(`sepsis`), and a command-line
interface&nbsp;(`cli`):

1.  The `rest_backend` package mostly contains classes for representing OpenMRS
    types locally:

	*   `Clinic.java`
	*   `Patient.java`
	*   `Medication.java`
	*   `Concept.java`
	*   `Observation.java`

	An additional class handles observations that must be matched to each other:

	*   `SimultaneousObservations.java`

	And timestamp support within these classes is provided by an abstract
    superclass:

	*   `TimestampedObject.java`

2.  The `heart_failure` package contains a single entry point:

    *   `HeartFailureAlgorithm.java`

	The heart failure determination algorithm itself is implemented by
    several classes, which perform most of their computation at
    construction but can also act as return types:

	*   `OrganDysfunctionDetermination.java`
	*   `MissingLabsDetermination.java`

	Common determination codes are kept in an abstract superclass:

	*   `Determination.java`

	And evidence is in the form of observations falling inside or outside of
    certain reference ranges:

	*    `ObservationInInterval.java`

	These objects are in turn supported by a class for ranges:

	*    `Interval.java`

	As for medication data, it is to be loaded on demand, not preloaded, so the
    screening package provides an interface that a (frontend) medication data
    source must implement:

	*   `MedicationDataSource.java`

3.  The `cli` package provides the main class:

    *   `HeartFailureDeterminationApp.java`

	which in turn uses command-line utility functions:

	*   `CLI.java`

	Major responsibilities, such as asking the user for medication data or
    formatting the final report, are delegated to separate classes:

	*   `MedicationQuestioner.java`
	*   `Report.java`

Finally, while not code per se, internationalization data for the command-line
interface is kept in `HeartFailure.properties` inside the `resources` folder.

## Testing  & Test Results

The heart failure determination app has been verified with automated unit tests
of the ACME heart failure determination algorithm and manual system tests of the
app as a whole. Both types of tests were designed using the specifications
provided to derive categories and partitions to support category-partition
testing. The test suites were then augmented to achieve 100% code coverage. The
categories and partitions chosen are documented in a separate file we created
called `test_design.md`, which is in the `documentation` folder.

Unit tests are available in three classes in the `test` folder:

*   `HeartFailureTest.java`
*   `OrganDysfunctionDeterminationTest.java`
*   `MissingLabsDeterminationTest.java`

The unit tests require JUnit 4.

System tests are documented as Markdown in the `system_tests` folder. Each test
includes:

*   The steps necessary to reset the test environment (i.e., the OpenMRS
    database),
*   The manual system testing steps, including the steps to run the app and
    specific values to enter at each step, and
*   The steps necessary to verify the output with respect to the expected output
    to determine if the test has passed or failed.

The system tests do not require any special tools or software.

No UI testing, security testing, or load/stress testing was performed for this
milestone.

The app is passing all unit-level and system-level tests. The unit-level tests
achieve 100% statement coverage of the code developed by our team.
