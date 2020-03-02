package test.tools.workshop.junit.helpers;

import org.junit.rules.ExternalResource;

import test.tools.workshop.junit.Initializer;

public class InitializerRule extends ExternalResource {

    private final Initializer initializer = new Initializer();

    @Override
    protected void before() throws Throwable {
        initializer.initialize();
    }

    @Override
    protected void after() {
        initializer.cleanUp();
    }

    public Initializer getInitializer() {
        return initializer;
    }
}
