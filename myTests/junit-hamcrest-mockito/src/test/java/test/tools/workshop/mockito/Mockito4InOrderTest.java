package test.tools.workshop.mockito;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.InOrder;

public class Mockito4InOrderTest {

    private final Callee callee = mock(Callee.class);
    private final Call call = mock(Call.class);

    @Test
    public void noOrder() throws Exception {
	callee.isAvailable();
	callee.processIncommingCall(call);

	// this pass
	verify(callee).processIncommingCall(call);
	verify(callee).isAvailable();
    }

    @Test
    public void orderOfCallsOfAMock() throws Exception {
	callee.isAvailable();
	callee.processIncommingCall(call);

	InOrder order = inOrder(callee);
	order.verify(callee).processIncommingCall(call);
	order.verify(callee).isAvailable(); // fail here after wrong call
	order.verifyNoMoreInteractions();
    }

    @Test
    public void orderOfMultipleMocks() throws Exception {
	Callee otherCallee = mock(Callee.class);

	callee.isAvailable();
	callee.processIncommingCall(call);
	otherCallee.isAvailable();
	otherCallee.processIncommingCall(call);

	// this fail
	InOrder order = inOrder(callee, otherCallee);
	order.verify(callee).isAvailable();
	order.verify(otherCallee).isAvailable();
	order.verify(callee).processIncommingCall(call); // fail here after
							 // wrong call
	order.verify(otherCallee).processIncommingCall(call);
	order.verifyNoMoreInteractions(); // for all mocks
    }
}
