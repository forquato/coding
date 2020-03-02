package test.tools.workshop.hamcrest;

import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;

public class WithIrrelevantTimeStamp {
    private final String key;
    private final String value;

    private final LocalDateTime createdAt = now();

    public WithIrrelevantTimeStamp(String key, String value) {
	this.key = key;
	this.value = value;
    }

    public String getKey() {
	return key;
    }

    public String getValue() {
	return value;
    }

    public LocalDateTime getCreatedAt() {
	return createdAt;
    }
}
