package test.tools.workshop.hamcrest;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Hamcrest4StringsTest {
    @Test
    public void containsForIterablesVsContainsStrings() throws Exception {
	assertThat(asList("a", "b"), contains("a", "b")); // contains for
							  // Iterables

	assertThat("someText", containsString("meTe")); // contains for
							// substrings

	// don't work: assertThat("someText", contains("substring"));
    }

    @Test
    public void otherMatchers() throws Exception {
	assertThat("someText", startsWith("some"));
	assertThat("someText", endsWith("Text"));
	assertThat("someText", equalToIgnoringCase("SoMeTeXt"));
	assertThat("some text", equalToIgnoringWhiteSpace("some \n\rText"));
    }
}
