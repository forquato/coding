package test.tools.workshop.hamcrest;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Hamcrest6SameProvertyValuesAsTest {
    private final WithoutEquals entry1 = new WithoutEquals("someKey", "someValue");
    private final WithoutEquals entry2 = new WithoutEquals("someKey", "someValue");

    @Test
    public void isMatcherComparesWithEquals() throws Exception {
	// fail: with bad message, because there is no toString, too
	assertThat(entry1, is(entry2));
    }

    @Test
    public void useSamePropertyValuesAs_toTestGetterResults() throws Exception {
	assertThat(entry1, samePropertyValuesAs(entry2));
    }

    @Test
    public void failingSamePropertyValuesAs() throws Exception {
	assertThat(new WithoutEquals("someKey", "wrongValue"), samePropertyValuesAs(entry2));
    }
}
