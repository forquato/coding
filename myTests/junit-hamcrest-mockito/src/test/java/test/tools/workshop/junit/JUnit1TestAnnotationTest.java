package test.tools.workshop.junit;

import static java.lang.Thread.sleep;
import static org.junit.Assert.fail;

import org.junit.Test;

public class JUnit1TestAnnotationTest {
    /*
     * enter "test" and hit Ctrl+Space to use templates to create an empty test
     */

    @Test
    public void successfulTest() throws Exception {

    }

    @Test
    public void failingTest() throws Exception {
	fail("failing");
	System.out.println("this is never executed");
    }

    @Test(expected = RuntimeException.class)
    public void expectAnException() throws Exception {
	throw new IllegalArgumentException("should be successful if exception is thrown");
    }

    @Test(timeout = 1000 /* millisecconds */)
    public void failAfterTimeout() throws Exception {
	sleep(2000 /* milliseconds */);
    }
}
