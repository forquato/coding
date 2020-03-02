package test.tools.workshop.junit;

import static org.junit.Assert.fail;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import test.tools.workshop.junit.helpers.ExampleRule;
import test.tools.workshop.junit.helpers.InitializerRule;

public class JUnit3CustomTestRuleTest {

    // test rules are executed in non deterministic order
    @Rule
    public InitializerRule initializerRule = new InitializerRule();
    @Rule
    public TestRule exampleRule = new ExampleRule("on test level");

    @ClassRule
    public static TestRule exampleClassRule = new ExampleRule("on class level");

    @Test
    public void successfulTest() throws Exception {
	System.out.println("successful test");
	initializerRule.getInitializer().doIfInitialized();
    }

    @Test
    public void failingTest() throws Exception {
	System.out.println("successles test");
	fail("expected fail");
    }
}
