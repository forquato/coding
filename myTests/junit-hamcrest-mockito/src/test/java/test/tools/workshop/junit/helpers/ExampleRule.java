package test.tools.workshop.junit.helpers;

import org.junit.rules.ExternalResource;

public class ExampleRule extends ExternalResource {

    private final String name;

    public ExampleRule(String name) {
        this.name = name;
    }

    @Override
    protected void before() throws Throwable {
        System.out.println("Executing before method of rule '" + name + "'");
    }

    @Override
    protected void after() {
        System.out.println("Executing after method rule '" + name + "'");
    }

}
