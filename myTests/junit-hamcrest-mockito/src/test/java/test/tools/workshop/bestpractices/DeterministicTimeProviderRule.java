package test.tools.workshop.bestpractices;

import static java.lang.Math.min;
import static java.util.Arrays.asList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.rules.ExternalResource;

public class DeterministicTimeProviderRule extends ExternalResource {

    public static DeterministicTimeProviderRule fixedTime() {
	return new DeterministicTimeProviderRule(new PredefinedTimeProvider(asList(LocalDateTime.now())));
    }

    public static DeterministicTimeProviderRule fixedTime(LocalDateTime first, LocalDateTime... timesToReturn) {
	List<LocalDateTime> times = new ArrayList<>(timesToReturn.length + 1);
	times.add(first);
	times.addAll(asList(timesToReturn));
	return new DeterministicTimeProviderRule(new PredefinedTimeProvider(asList(LocalDateTime.now())));
    }

    private final TimeProvider testInstance;

    private DeterministicTimeProviderRule(TimeProvider testInstance) {
	this.testInstance = testInstance;
    }

    @Override
    protected void before() throws Throwable {
	TimeProvider.setForTests(testInstance);
    };

    @Override
    protected void after() {
	TimeProvider.reset();
    }

    private static class PredefinedTimeProvider extends TimeProvider {
	private final List<LocalDateTime> timesToReturn;
	private int returned = 0;

	public PredefinedTimeProvider(List<LocalDateTime> timesToReturn) {
	    this.timesToReturn = timesToReturn;
	}

	@Override
	public LocalDateTime asDateTime() {
	    return timesToReturn.get(min(returned++, timesToReturn.size() - 1));
	}
    }
}
