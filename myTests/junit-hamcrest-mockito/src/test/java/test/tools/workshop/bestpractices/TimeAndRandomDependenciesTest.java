package test.tools.workshop.bestpractices;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static test.tools.workshop.bestpractices.DeterministicTimeProviderRule.fixedTime;
import static test.tools.workshop.bestpractices.TimeProvider.now;

import java.time.LocalDateTime;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class TimeAndRandomDependenciesTest {
    @Rule // returns always the same time (don't know which)
    public TestRule time = fixedTime();

    // @Rule // alternative for concrete times
    // public TestRule alternative = fixedTime(//
    // of(2000, MAY, 1).atTime(10, 30), // first
    // of(2001, MAY, 1).atTime(10, 30), // second
    // of(2002, MAY, 1).atTime(10, 30)); // third, fourd, ....

    public TimeAndRandomDependencies underTest = new TimeAndRandomDependencies();

    @Test
    public void testName() throws Exception {
	// can only say that it is not now... thats all
	assertThat(underTest.makeSomethingComplexAndReturnUntestableTimeDependentValue(), is(not(LocalDateTime.now())));

	assertThat(underTest.makeSomethingComplexAndReturnTestableTimeDependentValue(), is(now().asDateTime()));
    }
}
