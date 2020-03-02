package test.tools.workshop.junit;

import static org.junit.rules.RuleChain.outerRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import test.tools.workshop.junit.helpers.ExampleRule;
import test.tools.workshop.junit.helpers.InitializerRule;

public class JUnit5RuleChainTest {

    private final InitializerRule someRuleThatYouNeedToAccessWithoutAnnotation = new InitializerRule();

    @Rule // works with ClassRule, too
    public TestRule someComplexTestSetup = outerRule(new ExampleRule("some rule"))
	    .around(new ExampleRule("some other rule")).around(someRuleThatYouNeedToAccessWithoutAnnotation);

    @Test
    public void testName() throws Exception {

    }
}
