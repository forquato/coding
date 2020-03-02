package test.tools.workshop.junit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.function.Supplier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) // they do similar thinks like TestRunners
// you cannot combine multiple runners for one TestClass
public class JUnit6TestRunnersTest {

    @Mock
    public Supplier<String> supplier;

    @Test
    public void testName() throws Exception {
	when(supplier.get()).thenReturn("value");

	assertThat(supplier.get(), is("value"));
    }
}
