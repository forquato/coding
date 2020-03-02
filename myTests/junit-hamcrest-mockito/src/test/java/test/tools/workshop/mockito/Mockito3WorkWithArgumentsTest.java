package test.tools.workshop.mockito;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;
import static test.tools.workshop.mockito.ConferenceType.PRIVATE;

import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class Mockito3WorkWithArgumentsTest {

    private final Caller caller = new Caller();
    private final Callee callee = mock(Callee.class);

    @Test(expected = IllegalArgumentException.class)
    public void youCanUseMatchersInVerificationsOrWhens() throws Exception {
	Call necessaryCallInstance = new Call();
	doThrow(new IllegalArgumentException("But I whant my call instance!")).when(callee)
		.processIncommingCall(argThat(is(not(necessaryCallInstance))));
	when(callee.isAvailable()).thenReturn(true);

	caller.makeCallTo(callee);
    }

    @Test
    public void captureArguments() throws Exception {
	caller.startPrivateConferenceWith(callee); // how can we validate the
						   // conference?

	ArgumentCaptor<Conference> captor = forClass(Conference.class);
	verify(callee).joinConference(captor.capture());

	Conference startedConference = captor.getValue();
	assertThat(startedConference.getType(), is(PRIVATE));
    }

    @Test
    public void captureArgumentForMultipleCalls() throws Exception {
	caller.disturb(callee);

	ArgumentCaptor<Call> captor = forClass(Call.class);
	verify(callee, times(5)).processIncommingCall(captor.capture());

	List<Call> incommingCalls = captor.getAllValues();
	assertThat(incommingCalls, hasSize(5));

	// assert same call
	Call first = incommingCalls.get(0);
	assertThat(incommingCalls, contains(first, first, first, first, first));
    }
}
