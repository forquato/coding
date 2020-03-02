package test.tools.workshop.junit;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

public class JUnit4BuiltInTestRulesTest {
    /*
     * you can use this template to create expected exceptions rules fast:
     * ${staticImp:importStatic(org.junit.rules.ExpectedException.none)}
     * ${imp:import(org.junit.Rule,org.junit.rules.ExpectedException)}@Rule
     * public ExpectedException exception = none();
     */

    @Rule
    public ExpectedException exception = none();

    @Rule
    public TemporaryFolder folder = new TemporaryFolder(); // can be called with
							   // parent folder

    @Test
    public void comparingToExpectedInTestAnnotationWeCanValidateCauseAndMessageToo() throws Exception {
	exception.expect(RuntimeException.class);
	exception.expectCause(isA(IOException.class));
	exception.expectMessage("substring");

	throw new IllegalArgumentException("Message containing substring", new IOException("the cause"));
    }

    @Test
    public void youCanUseTemporaryFoldersThatAreRemovedAfterTheTests() throws Exception {
	File root = folder.getRoot();
	assertThat(root.exists(), is(true));

	File anyTemporaryFile = folder.newFile();
	assertThat(anyTemporaryFile.exists(), is(true));
    }
}
