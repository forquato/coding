package test.tools.workshop.mockito;

import static test.tools.workshop.mockito.ConferenceType.PRIVATE;

public class Caller implements ConferenceMember {

    public Call makeCallTo(Callee callee) {
	Call call = new Call();
	if (callee.isAvailable()) {
	    callee.processIncommingCall(call);
	}
	return call;
    }

    public void disturb(Callee callee) {
	Call call = new Call();
	callee.processIncommingCall(call);
	callee.processIncommingCall(call);
	callee.processIncommingCall(call);
	callee.processIncommingCall(call);
	callee.processIncommingCall(call);
    }

    public void startPrivateConferenceWith(Callee partner) {
	Conference c = new Conference(PRIVATE, this, partner);
	this.joinConference(c);
	partner.joinConference(c);
    }

    @Override
    public void joinConference(Conference conference) {
	System.out.println("I'm in conference");
    }
}
