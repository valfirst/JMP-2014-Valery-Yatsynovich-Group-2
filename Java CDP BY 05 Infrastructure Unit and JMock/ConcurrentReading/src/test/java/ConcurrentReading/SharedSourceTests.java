package ConcurrentReading;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Julia on 11/1/14.
 */
@RunWith(org.junit.runners.JUnit4.class)
public class SharedSourceTests {

    private static final String FILE_PATH = "someTestFile.txt";
    private static final String SUCCESS = "success";
    private static SharedSource sharedSource = null;
    Mockery context = new JUnit4Mockery();

    @BeforeClass
    public static void setUp() throws InvalidInput {
        sharedSource = new SharedSource(FILE_PATH);
    }

    @Test
    public void testWriteToSource() throws InvalidInput {
        final ISharedSource sharedSource1 = context.mock(ISharedSource.class);
        final String line = "someLine";

        context.checking(new Expectations(){{
            one(sharedSource1).write(line);
            will(returnValue(SUCCESS));
        }});

        sharedSource1.write(line);

        context.assertIsSatisfied();
    }

    @Test
    public void testReadFromSource(){
        final ISharedSource sharedSource1 = context.mock(ISharedSource.class);

        context.checking(new Expectations(){{
            oneOf(sharedSource1).read();
            will(returnValue(false));
        }});

        sharedSource1.read();

        context.assertIsSatisfied();
    }


}
