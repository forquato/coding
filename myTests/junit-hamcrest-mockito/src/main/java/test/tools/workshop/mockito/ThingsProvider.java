package test.tools.workshop.mockito;

import static java.util.Arrays.asList;

import java.util.List;

public class ThingsProvider {
    public List<String> getList() {
	return asList("string1", "string2");
    }

    public String[] getArray() {
	return new String[] { "string1", "string2" };
    }

    public StringProvider getObject() {
	return new StringProvider();
    }

    public boolean getBoolean() {
	return true;
    }

    public int getInt() {
	return 42;
    }

    public String getString() {
	return "someString";
    }
}
