package test.tools.workshop.hamcrest.helpers;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static test.tools.workshop.hamcrest.helpers.LambdaFeatureMatcher.featureEqualTo;

import java.time.LocalDateTime;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import test.tools.workshop.hamcrest.WithIrrelevantTimeStamp;

public class WithIrrelevantTimeStampMatchers {
    public static Matcher<WithIrrelevantTimeStamp> hasKeyNaive(String expectedKey) {
	return new FeatureMatcher<WithIrrelevantTimeStamp, String>(equalTo(expectedKey), "key", "key") {
	    @Override
	    protected String featureValueOf(WithIrrelevantTimeStamp actual) {
		return actual.getKey();
	    }
	};
    }

    // with lambda matcher:
    public static Matcher<WithIrrelevantTimeStamp> hasKey(String expectedKey) {
	return featureEqualTo(expectedKey, "key", WithIrrelevantTimeStamp::getKey);
    }

    public static Matcher<WithIrrelevantTimeStamp> hasValue(String expectedValue) {
	return featureEqualTo(expectedValue, "value", WithIrrelevantTimeStamp::getValue);
    }

    public static Matcher<WithIrrelevantTimeStamp> hasCreatedAt(LocalDateTime expectedTime) {
	return featureEqualTo(expectedTime, "createdAt", WithIrrelevantTimeStamp::getCreatedAt);
    }

    public static Matcher<WithIrrelevantTimeStamp> hasSameKeyAndValueAs(WithIrrelevantTimeStamp expected) {
	return allOf(hasKey(expected.getKey()), hasValue(expected.getValue()));
    }
}
