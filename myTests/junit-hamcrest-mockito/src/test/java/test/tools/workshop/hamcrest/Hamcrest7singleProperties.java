package test.tools.workshop.hamcrest;

import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static test.tools.workshop.hamcrest.helpers.WithIrrelevantTimeStampMatchers.hasCreatedAt;
import static test.tools.workshop.hamcrest.helpers.WithIrrelevantTimeStampMatchers.hasKey;
import static test.tools.workshop.hamcrest.helpers.WithIrrelevantTimeStampMatchers.hasSameKeyAndValueAs;
import static test.tools.workshop.hamcrest.helpers.WithIrrelevantTimeStampMatchers.hasValue;

import org.hamcrest.FeatureMatcher;
import org.junit.Before;
import org.junit.Test;

public class Hamcrest7singleProperties {
    private final WithIrrelevantTimeStamp entry1 = new WithIrrelevantTimeStamp("someKey", "someValue");
    private final WithIrrelevantTimeStamp expected = new WithIrrelevantTimeStamp("someKey", "someValue");

    @Before
    public void setUp() throws Exception {
	sleep(1 /* millisecond */); // enforce time problems
    }

    @Test
    public void samePropertyValuesComparesAllGetterWithoutExceptions() throws Exception {
	assertThat(entry1.getCreatedAt(), is(not(expected.getCreatedAt())));

	// fail
	assertThat(entry1, samePropertyValuesAs(expected));
    }

    @Test
    public void workaroundForCheckingSingleProperties() throws Exception {
	assertThat(entry1, hasProperty("key", is("someKey")));
	assertThat(entry1, hasProperty("value", is("someValue")));

	// not aware of renamings
	assertThat(entry1, hasProperty("valueAfterAutomatedRenaming", is("someValue")));
    }

    @Test
    public void betterIsToUseFeatureMatcher() throws Exception {
	// the idea:
	assertThat(entry1, new FeatureMatcher<WithIrrelevantTimeStamp, String>(equalTo("someKey"), "key", "key") {
	    @Override
	    protected String featureValueOf(WithIrrelevantTimeStamp actual) {
		return actual.getKey();
	    }
	});

	// how to use: extracted to method:
	assertThat(entry1, hasKeyEqualTo("someKey"));

	// increase reusement: create static factories in
	// WithIrrelevantTimeStampMatchers:
	assertThat(entry1, hasKey("someKey"));
	assertThat(entry1, hasValue("someValue"));
	assertThat(entry1, not(hasCreatedAt(expected.getCreatedAt()))); // they
									// are
									// combinable!

	// er better check the whole object
	assertThat(entry1, hasSameKeyAndValueAs(expected));
    }

    // how it looks like
    private FeatureMatcher<WithIrrelevantTimeStamp, String> hasKeyEqualTo(String expectedKey) {
	return new FeatureMatcher<WithIrrelevantTimeStamp, String>(equalTo(expectedKey), "key", "key") {
	    @Override
	    protected String featureValueOf(WithIrrelevantTimeStamp actual) {
		return actual.getKey();
	    }
	};
    }
}
