package test.tools.workshop.junit.helpers;

import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.mockito.MockitoAnnotations;

public class MockitoAnnotationsRule extends ExternalResource {
    // for better readability in tests
    public static TestRule injectMockitoMocksIn(Object testClassInstance) {
	return new MockitoAnnotationsRule(testClassInstance);
    }

    private final Object testClassInstance;

    public MockitoAnnotationsRule(Object testClassInstance) {
	this.testClassInstance = testClassInstance;
    }

    @Override
    protected void before() throws Throwable {
	MockitoAnnotations.initMocks(testClassInstance);
    }
}
