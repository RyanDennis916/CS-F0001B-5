
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
public class QueueTest
{

    static final String GENERIC_NODE = "generic node";
//	@Generated(value = "org.junit-tools-1.0.6")
    private Logger logger = Logger.getLogger(QueueTest.class.toString());

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

    private Queue createTestSubject()
    {
        return new Queue();
    }

    @MethodRef(name = "add", signature = "(QNode;)V")
    @Test
    public void testAdd() throws Exception
    {
        Queue testSubject;
        Node newNode = null;

        // test null newNode
        testSubject = createTestSubject();
        newNode = null;
        testSubject.add(newNode);
        Assert.assertEquals("", testSubject.toString());

        // test adding completed Nodes
        testSubject = createTestSubject();
        newNode = new Node();
        testSubject.add(newNode);
        Assert.assertEquals(true, testSubject.toString().toLowerCase().lastIndexOf(QueueTest.GENERIC_NODE) <= 1);
        newNode = new Node();
        testSubject.add(newNode);
        Assert.assertEquals(true, testSubject.toString().toLowerCase().lastIndexOf(QueueTest.GENERIC_NODE) > 12);
    }

    @MethodRef(name = "remove", signature = "()QNode;")
    @Test
    public void testRemove() throws Exception
    {
        Queue testSubject;
        Node result = null;

        // default test
        testSubject = createTestSubject();
        verifyEmptyQueue(testSubject);

        // test after adding 2 completed Nodes
        testSubject = createTestSubject();
        Node newNode = new Node();
        testSubject.add(newNode);
        int lastIndexOf = testSubject.toString().toLowerCase().lastIndexOf(QueueTest.GENERIC_NODE);
        Assert.assertEquals(true, lastIndexOf <= 1);
        Assert.assertEquals(true, lastIndexOf > 0);
        newNode = new Node();
        testSubject.add(newNode);
        lastIndexOf = testSubject.toString().toLowerCase().lastIndexOf(QueueTest.GENERIC_NODE);
        Assert.assertEquals(true, lastIndexOf > 12);
        result = testSubject.remove();
        Assert.assertNotNull(result);
        lastIndexOf = testSubject.toString().toLowerCase().lastIndexOf(QueueTest.GENERIC_NODE);
//		Assert.assertEquals("(generic node)", testSubject.toString());
        Assert.assertEquals(true, lastIndexOf <= 1);
        Assert.assertEquals(true, lastIndexOf > 0);
        result = testSubject.remove();
        Assert.assertNotNull(result);
        lastIndexOf = testSubject.toString().toLowerCase().lastIndexOf(QueueTest.GENERIC_NODE);
        Assert.assertEquals(true, lastIndexOf == -1);
        // Queue should be empty now
        result = null;
        verifyEmptyQueue(testSubject);
    }

    /**
     * @param testSubject
     * @param result
     */
    void verifyEmptyQueue(Queue testSubject)
    {
        Node result = null;
        try
        {
            result = testSubject.remove();
        } catch (QueueEmptyException e)
        {
//			e.printStackTrace();
            Assert.assertNotNull(e);
        }
        Assert.assertNull(result);
    }

    @MethodRef(name = "toString", signature = "()QString;")
    @Test
    public void testToString() throws Exception
    {
        Queue testSubject;
        String result;

        // default test
        testSubject = createTestSubject();
        Node newNode = new Node();
        testSubject.add(newNode);
        int lastIndexOf = testSubject.toString().toLowerCase().lastIndexOf(QueueTest.GENERIC_NODE);
        Assert.assertEquals(true, lastIndexOf <= 1);
        Assert.assertEquals(true, lastIndexOf > 0);
    }
}