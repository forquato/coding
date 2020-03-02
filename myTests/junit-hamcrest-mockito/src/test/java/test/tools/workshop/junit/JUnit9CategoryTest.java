package test.tools.workshop.junit;

import static java.lang.Thread.sleep;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import test.tools.workshop.junit.helpers.DeploymentRequiringTest;
import test.tools.workshop.junit.helpers.SlowUnitTest;

// you can define in maven which tests you want to execute in a dedicated pipeline step
public class JUnit9CategoryTest {
    @Test
    public void normalTest() throws Exception {
	System.out.println("some normal test");
    }

    @Category(SlowUnitTest.class)
    @Test
    public void slowUnitTest() throws Exception {
	System.out.println("A test that test something like timeout mechanisms");
	sleep(2000 /* milliseconds */);
    }

    @Category(DeploymentRequiringTest.class)
    @Test
    public void testRequiringDeployment() throws Exception {
	System.out.println("this test requires a deployment of an artifact that is used in test");
    }
}
