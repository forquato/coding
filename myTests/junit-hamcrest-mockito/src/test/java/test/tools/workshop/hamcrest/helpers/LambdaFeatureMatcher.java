package test.tools.workshop.hamcrest.helpers;

import static org.hamcrest.Matchers.equalTo;

import java.util.function.Function;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

public class LambdaFeatureMatcher<T, U> extends FeatureMatcher<T, U> {

    public static <T, U> LambdaFeatureMatcher<T, U> featureEqualTo(U expected, String featureDescription,
	    String featureName, Function<T, U> featureExtractor) {
	return new LambdaFeatureMatcher<>(featureExtractor, equalTo(expected), featureDescription, featureName);
    }

    public static <T, U> LambdaFeatureMatcher<T, U> featureEqualTo(U expected, String featureName,
	    Function<T, U> featureExtractor) {
	return feature(featureName, featureName, equalTo(expected), featureExtractor);
    }

    public static <T, U> LambdaFeatureMatcher<T, U> feature(String featureDescription,
	    String featureName, Matcher<? super U> subMatcher, Function<T, U> featureExtractor) {
	return new LambdaFeatureMatcher<>(featureExtractor, subMatcher, featureDescription, featureName);
    }

    public static <T, U> LambdaFeatureMatcher<T, U> feature(String featureName,
	    Matcher<? super U> subMatcher, Function<T, U> featureExtractor) {
	return feature(featureName, featureName, subMatcher, featureExtractor);
    }

    private final Function<T, U> featureExtractor;

    private LambdaFeatureMatcher(Function<T, U> featureExtractor, Matcher<? super U> subMatcher,
	    String featureDescription, String featureName) {
	super(subMatcher, featureDescription, featureName);
	this.featureExtractor = featureExtractor;
    }

    @Override
    protected U featureValueOf(T actual) {
	return featureExtractor.apply(actual);
    }
}
