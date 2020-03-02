package test.tools.workshop.mockito;

import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

import java.io.Closeable;

import org.junit.Test;

public class Mockito6WithSettings {
    @Test
    public void name() throws Exception {
	Callee mock = mock(Callee.class);
	Callee mock2 = mock(Callee.class);
	assertThat(mock.toString(), startsWith("Mock for Callee, hashCode: "));
	assertThat(mock2.toString(), startsWith("Mock for Callee, hashCode: "));

	mock = mock(Callee.class, "callee number one");
	mock2 = mock(Callee.class, withSettings().name("callee number two"));
	assertThat(mock.toString(), startsWith("callee number one"));
	assertThat(mock2.toString(), startsWith("callee number two"));
    }

    @Test
    public void withComplexSettings() throws Exception {
	Callee mock = mock(Callee.class,
		withSettings() //
			.name("complex callee")//
			.defaultAnswer(RETURNS_SMART_NULLS)//
			.extraInterfaces(Closeable.class)//
			.serializable());

	assertThat(mock.toString(), startsWith("complex callee"));
	Closeable asC = (Closeable) mock;
	asC.close(); // can be called or mocked
    }
}
