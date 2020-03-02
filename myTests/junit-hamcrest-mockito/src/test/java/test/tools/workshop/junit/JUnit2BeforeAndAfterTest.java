package test.tools.workshop.junit;

import static java.lang.System.out;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnit2BeforeAndAfterTest {
    /*
     * -> Preferences -> Java -> Editor -> Templates: add template "before" and
     * same for "after" or "before_class" ${:import(org.junit.Before)}@Before
     * public void setUp() throws Exception { ${cursor} }
     */

    private final Initializer initializer = new Initializer();

    @Before
    public void setUp() throws Exception {
	out.println("execute once before each test");
	// example:
	initializer.initialize();
    }

    @After
    public void tearDown() throws Exception {
	out.println("execute once after each test (even if failed)");
	// example:
	initializer.cleanUp();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
	out.println("execute once before all tests in this class");
	// eg. establish DB connection
    }

    @AfterClass
    public static void afterClass() throws Exception {
	out.println("execute once after all tests in this class (even if failed)");
	// eg. close DB connection
    }

    @Test
    public void successfulTest() throws Exception {
	System.out.println("successful test");
    }

    @Test
    public void failingTest() throws Exception {
	System.out.println("successles test");
	fail("expected fail");
    }
}
