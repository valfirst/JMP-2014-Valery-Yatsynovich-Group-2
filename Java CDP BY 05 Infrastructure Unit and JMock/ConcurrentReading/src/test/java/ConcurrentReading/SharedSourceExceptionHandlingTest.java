package ConcurrentReading;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Julia on 11/1/14.
 */
@RunWith(org.junit.runners.JUnit4.class)
public class SharedSourceExceptionHandlingTest {

    private static final String filePath = "someTestFile.txt";
    private static SharedSource sharedSource = null;
    private static SharedSource sharedEmptySource = null;
    Mockery context = new JUnit4Mockery();

    @BeforeClass
    public static void setUp() throws InvalidInput {
        sharedSource = new SharedSource(filePath);
    }

    @Test(expected = InvalidInput.class)
    public void testNullSource() throws InvalidInput {
        sharedEmptySource = new SharedSource(null);
    }

    @Test(expected = InvalidInput.class)
    public void testEmptySource() throws InvalidInput {
        sharedEmptySource = new SharedSource("");
    }

    @Test(expected = InvalidInput.class)
    public void testEmptyWriteLine() throws InvalidInput {
        sharedSource.write("");
    }


}
