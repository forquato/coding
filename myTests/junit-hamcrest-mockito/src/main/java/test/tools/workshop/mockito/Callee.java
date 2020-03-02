package test.tools.workshop.mockito;

public interface Callee extends ConferenceMember {
	boolean isAvailable();

	void processIncommingCall(Call call);
}
