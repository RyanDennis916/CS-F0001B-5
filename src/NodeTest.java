
import java.util.logging.Logger;

//import javax.annotation.Generated;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

//@Generated(value = "org.junit-tools-1.0.6")
public class NodeTest
{

//	@Generated(value = "org.junit-tools-1.0.6")
    private Logger logger = Logger.getLogger(NodeTest.class.toString());

    @Before
    public void setUp() throws Exception
    {

    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {

    }

    @After
    public void tearDown() throws Exception
    {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {

    }

    private Node createTestSubject()
    {
        return new Node();
    }

    @MethodRef(name = "toString", signature = "()QString;")
    @Test
    public void testToString() throws Exception
    {
        Node testSubject;
        String result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.toString();
        Assert.assertEquals(true, result.toLowerCase().contains("generic node"));
    }
}