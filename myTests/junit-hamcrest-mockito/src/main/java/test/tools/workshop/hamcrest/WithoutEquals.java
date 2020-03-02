package test.tools.workshop.hamcrest;

public class WithoutEquals {
    private final String key;
    private final String value;

    public WithoutEquals(String key, String value) {
	this.key = key;
	this.value = value;
    }

    public String getKey() {
	return key;
    }

    public String getValue() {
	return value;
    }

}
