package test.tools.workshop.mockito;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import org.junit.Test;

public class Mockito5DefaultAnswers {

    @Test
    public void defaultSpy() throws Exception {
	ThingsProvider provider = spy(ThingsProvider.class);

	assertThat(provider.getBoolean(), is(true));
	assertThat(provider.getInt(), is(42));
	assertThat(provider.getString(), is("someString"));
	assertThat(provider.getList(), contains("string1", "string2"));
	assertThat(provider.getArray(), arrayContaining("string1", "string2"));
	assertThat(provider.getObject().get(), is("originalText"));
    }

    @Test
    public void defaultMock() throws Exception {
	ThingsProvider provider = mock(ThingsProvider.class);

	assertThat(provider.getBoolean(), is(false));
	assertThat(provider.getInt(), is(0));
	assertThat(provider.getString(), is(nullValue()));
	assertThat(provider.getList(), is(empty()));
	assertThat(provider.getArray(), is(nullValue()));
	assertThat(provider.getObject(), is(nullValue()));
    }

    @Test
    public void smartNulls() throws Exception {
	ThingsProvider provider = mock(ThingsProvider.class, RETURNS_SMART_NULLS);

	assertThat(provider.getBoolean(), is(false));
	assertThat(provider.getInt(), is(0));
	assertThat(provider.getString(), is(""));
	assertThat(provider.getList(), is(empty()));
	assertThat(provider.getArray(), is(emptyArray()));
	assertThat(provider.getObject(), is(not(nullValue())));
	// provider.getObject().get();// is forbidden by mockito
    }

    @Test
    public void returnsMocks() throws Exception {
	ThingsProvider provider = mock(ThingsProvider.class, RETURNS_MOCKS);

	assertThat(provider.getBoolean(), is(false));
	assertThat(provider.getInt(), is(0));
	assertThat(provider.getString(), is(""));
	assertThat(provider.getList(), is(empty()));
	assertThat(provider.getArray(), is(emptyArray()));
	assertThat(provider.getObject().get(), is(""));
	// each time new mock:
	assertThat(provider.getObject(), is(not(provider.getObject())));
    }

    @Test
    public void returnsDeepStubs() throws Exception {
	ThingsProvider provider = mock(ThingsProvider.class, RETURNS_DEEP_STUBS);

	assertThat(provider.getBoolean(), is(false));
	assertThat(provider.getInt(), is(0));
	assertThat(provider.getString(), is(nullValue()));
	assertThat(provider.getList(), hasSize(0));
	assertThat(provider.getList().get(0), is(nullValue()));
	assertThat(provider.getArray(), is(nullValue()));
	assertThat(provider.getObject().get(), is(nullValue()));
	// each time same mock:
	assertThat(provider.getObject(), is(provider.getObject()));
    }
}
