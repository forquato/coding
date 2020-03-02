package test.tools.workshop.bestpractices;

import static test.tools.workshop.bestpractices.TimeProvider.now;

import java.time.LocalDateTime;

public class TimeAndRandomDependencies {
    public LocalDateTime makeSomethingComplexAndReturnUntestableTimeDependentValue() {
	LocalDateTime time = LocalDateTime.now();
	doUnpredictedStuff();
	return time;
    }

    public LocalDateTime makeSomethingComplexAndReturnTestableTimeDependentValue() {
	LocalDateTime time = now().asDateTime();
	doUnpredictedStuff();
	return time;
    }

    private void doUnpredictedStuff() {
	try {
	    Thread.sleep((long) (Math.random() * 10));
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
}
