package test.tools.workshop.hamcrest;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Hamcrest5ArrayMatchers {
    private static final String[] STRINGS = new String[] { "a", "b" };

    @Test
    public void arrayMatchers() throws Exception {
	assertThat(STRINGS, is(arrayWithSize(2)));
	assertThat(STRINGS, is(arrayContaining("a", "b")));
	assertThat(STRINGS, is(arrayContainingInAnyOrder("b", "a")));
    }
}
