package test.tools.workshop.hamcrest;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class Hamcrest3Collections {
    private static final List<String> UNDER_TEST = asList("someText", "someOtherText");

    @Test
    public void testHasItem() throws Exception {
	assertThat(UNDER_TEST, hasItem("someText"));
	assertThat(UNDER_TEST, hasItems("someOtherText", "someText"));

	// fail
	assertThat(UNDER_TEST, hasItem("someNotExistentText"));
    }

    @Test
    public void testContains() throws Exception {
	assertThat(UNDER_TEST, contains("someText", "someOtherText"));

	// fail
	assertThat(UNDER_TEST, contains("someOtherText", "someText"));
    }

    @Test
    public void testContainsInAnyOrder() throws Exception {
	assertThat(UNDER_TEST, containsInAnyOrder("someOtherText", "someText"));

	// fail
	assertThat(UNDER_TEST, containsInAnyOrder("someText"));
    }
}
