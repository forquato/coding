package test.tools.workshop.mockito;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class Mockito2WhenThenVerifyTest {

    private final Caller caller = new Caller();
    private final Callee callee = mock(Callee.class);

    @Test
    public void whenThenVerify() throws Exception {
	when(callee.isAvailable()).thenReturn(true);

	caller.makeCallTo(callee);

	verify(callee).processIncommingCall(any(Call.class));
    }

    @Test
    public void verificationMode() throws Exception {
	caller.disturb(callee);

	verify(callee, atLeast(5)).processIncommingCall(any()); // >=
	verify(callee, times(5)).processIncommingCall(any()); // ==
    }

    @Test
    public void notAvailable() throws Exception {
	// when not necessary, because a mock returns always false on boolean
	// calls
	when(callee.isAvailable()).thenReturn(false);

	caller.makeCallTo(callee);

	verify(callee, never()).processIncommingCall(any());
	verify(callee, only()).isAvailable(); // only is same as without a
					      // verification mode but
					      // appending:
					      // verifyNoMoreInteractions(callee);
    }

    @Test(expected = RuntimeException.class)
    public void thenThrow() throws Exception {
	when(callee.isAvailable()).thenThrow(new RuntimeException("no network connection"));

	caller.makeCallTo(callee);
    }

    @Test
    public void changeDangerousBehavior() throws Exception {
	when(callee.isAvailable()).thenThrow(new RuntimeException());

	// if you want to change a behavior of a spy or a mock that has bad
	// behavior, this wouldn't work here
	// when(callee.isAvailable()).thenReturn(true); because isAvailbe throws
	// exception on its call
	// use instead:

	doReturn(true).when(callee).isAvailable();
	assertThat(callee.isAvailable(), is(true));

	// to avoid bad behavior of a void method you can do:
	doNothing().when(callee).processIncommingCall(any());
    }

    @Test
    public void resetMocks() throws Exception {
	when(callee.isAvailable()).thenThrow(new RuntimeException());

	reset(callee); // to use reset is a smell, maybe you should create two
		       // tests instead of resetting something in a test, but
		       // sometime you may need this
	assertThat(callee.isAvailable(), is(false));
    }

    @Test
    public void thenAnswer() throws Exception {
	when(callee.isAvailable()).thenAnswer(invocation -> {
	    System.out.println("if you need to do more that just a return or throw during a mock call");
	    return true;
	});

	assertThat(callee.isAvailable(), is(true));
    }

    @Test
    public void changeBehaviorOfVoidMethods() throws Exception {
	// when(callee.processIncommingCall(any())) doesn't compile
	doAnswer(invocation -> {
	    // actually only necessary for legacy code. If you need this in you
	    // code, mostly you should redesign it
	    Call objectWithThatTheMethodWasCalled = invocation.getArgument(0);
	    objectWithThatTheMethodWasCalled.setOngoing(true);
	    return null; // return null in void methods
	}).when(callee).processIncommingCall(any());
	when(callee.isAvailable()).thenReturn(true);

	Call call = caller.makeCallTo(callee);

	assertThat(call.isOngoing(), is(true));
    }

    @Test // (expected = IllegalStateException.class)
    public void chainReactions() throws Exception {
	doNothing().doThrow(new IllegalStateException("Don't call me twice!")).when(callee).processIncommingCall(any());

	// look at stacktrace if no exception expected
	// only the second processIncommingCall with throw an exception
	caller.disturb(callee);
    }
}
