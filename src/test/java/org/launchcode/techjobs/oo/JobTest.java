package org.launchcode.techjobs.oo;

import org.junit.Test;

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
}
