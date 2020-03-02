package test.tools.workshop.mockito;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class Mockito1SpyVsMockTest {
    @Test
    public void spyVsMock() throws Exception {
	StringProvider asSpy = spy(StringProvider.class);
	// all methods wrapped but behaves as original
	assertThat(asSpy.get(), is("originalText"));

	StringProvider asMock = mock(StringProvider.class);
	// all methods mocked
	assertThat(asMock.get(), is(nullValue()));
    }

    @Test
    public void originalInstanceVsSpy() throws Exception {
	StringProvider original = new StringProvider();
	original.get();
	// how to check get was called?

	StringProvider asSpy = spy(StringProvider.class);
	asSpy.get();
	verify(asSpy).get();
    }
}
