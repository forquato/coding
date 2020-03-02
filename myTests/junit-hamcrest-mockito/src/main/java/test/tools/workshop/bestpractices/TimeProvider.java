package test.tools.workshop.bestpractices;

import java.time.LocalDateTime;

public class TimeProvider {
    private static TimeProvider mockableTime = new TimeProvider();

    public static TimeProvider now() {
	return mockableTime;
    }

    static void reset() {
	mockableTime = new TimeProvider();
    }

    static void setForTests(TimeProvider testProvider) {
	mockableTime = testProvider;
    }

    public LocalDateTime asDateTime() {
	return LocalDateTime.now();
    }
}
