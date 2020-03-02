package test.tools.workshop.junit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static test.tools.workshop.junit.helpers.MockitoAnnotationsRule.injectMockitoMocksIn;

import java.util.function.Supplier;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Mock;

public class JUnit7MockitoAnnotationsWithoutRunnerTest {
    // the good news, you can often avoid usage of runners (like
    // MockitoJUnitRunner) with befores:
    // @Before
    // public void setUp() throws Exception {
    // MockitoAnnotations.initMocks(this);
    // }

    // or better with a custom rule:
    @Rule
    public TestRule mocks = injectMockitoMocksIn(this);

    @Mock
    public Supplier<String> supplier;

    @Test
    public void testName() throws Exception {
	when(supplier.get()).thenReturn("value");

	assertThat(supplier.get(), is("value"));
    }
}
