package test.tools.workshop.junit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assume.assumeThat;
import static test.tools.workshop.junit.JUnit8AssumeTest.OS.OTHER;
import static test.tools.workshop.junit.JUnit8AssumeTest.OS.UNIX;
import static test.tools.workshop.junit.JUnit8AssumeTest.OS.WINDOWS;

import org.junit.Test;

public class JUnit8AssumeTest {
    enum OS {
	WINDOWS, UNIX, OTHER
    }

    @Test
    public void testOnlyOnWindows() throws Exception {
	assumeThat(currentOS(), is(WINDOWS));
	System.out.println("this test runs only on windows machines");
    }

    @Test
    public void testOnlyOnUnix() throws Exception {
	assumeThat(currentOS(), is(UNIX));
	System.out.println("this test runs only on unix machines");
    }

    private static OS currentOS() {
	String osName = System.getProperty("os.name").toLowerCase();
	if (osName.contains("win")) {
	    return WINDOWS;
	} else if (osName.contains("unix")) {
	    return UNIX;
	} else {
	    return OTHER;
	}
    }
}
