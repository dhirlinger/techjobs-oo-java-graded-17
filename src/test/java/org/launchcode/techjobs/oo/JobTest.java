package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        Job test_job1 = new Job();
        Job test_job2 = new Job();

        assertNotEquals(test_job1.getId(), test_job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job test_job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(test_job1.getName() instanceof String);
        assertTrue(test_job1.getEmployer() instanceof Employer);
        assertTrue(test_job1.getLocation() instanceof Location);
        assertTrue(test_job1.getPositionType() instanceof PositionType);
        assertTrue(test_job1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(test_job1.getName(), "Product tester");
        assertEquals(test_job1.getEmployer().getValue(), "ACME");
        assertEquals(test_job1.getLocation().getValue(), "Desert");
        assertEquals(test_job1.getPositionType().getValue(), "Quality control");
        assertEquals(test_job1.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job test_job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertNotEquals(test_job1, test_job2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job test_job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(String.valueOf(test_job1.toString().charAt(0)), System.lineSeparator());
        assertEquals(String.valueOf(test_job1.toString().charAt(test_job1.toString().length() -1)), System.lineSeparator());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String newLine = System.lineSeparator();
        Job test_job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(test_job1.toString().contains("ID: " + test_job1.getId() + newLine + "Name: " + test_job1.getName() + newLine
        + "Employer: " + test_job1.getEmployer().getValue() + newLine + "Location: " + test_job1.getLocation().getValue() + newLine
        + "Position Type: " + test_job1.getPositionType().getValue() + newLine + "Core Competency: " + test_job1.getCoreCompetency().getValue() + newLine));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job test_job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));

       assertTrue(test_job1.getPositionType().getValue().isEmpty() && test_job1.toString().contains("Position Type: Data not available"));
    }
}
