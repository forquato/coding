package test.tools.workshop.hamcrest;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Hamcrest2CombinationOfMatchersTest {
    @Test
    public void notTest() throws Exception {
	assertThat("someString", is(not("someString")));
    }

    @Test
    public void notNull() throws Exception {
	String someReference = null;
	assertThat(someReference, is(not(nullValue())));
	// you cannot write not(null) because it then cannot make type
	// resolution and would result in a NPE
    }

    @Test
    public void allOf_combineMatchers() throws Exception {
	assertThat("someText", allOf(containsString("some"), containsString("Test")));
    }
}
