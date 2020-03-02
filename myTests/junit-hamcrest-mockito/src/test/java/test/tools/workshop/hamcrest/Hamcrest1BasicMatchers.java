package test.tools.workshop.hamcrest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Hamcrest1BasicMatchers {
    @Test
    public void plainAssertTrue() throws Exception {
	assertTrue(false);
	// AssertionError: <empty>. What was wrong is unclear
    }

    @Test
    public void hamcrestBooleanTest() throws Exception {

	assertThat(false, is(true));
	// AssertionError: expected is <true> but was >false>
    }

    @Test
    public void equalsWithAssertTrue() throws Exception {
	assertTrue("hans".equals("peter"));
	// AssertionError: <empty>. What was wrong is unclear
    }

    @Test
    public void plainAssertEquals() throws Exception {
	assertEquals("expected", "actual");
	// what is expected what is the actual value when writing?
    }

    @Test
    public void equalsWithIsMatcher() throws Exception {
	assertThat("actual", is("expected"));
	// AssertionError:
	// Expected: is "expected"
	// but: was "actual"
    }
}