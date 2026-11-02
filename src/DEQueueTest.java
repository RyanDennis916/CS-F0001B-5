
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
public class DEQueueTest
{

//	@Generated(value = "org.junit-tools-1.0.6")
    private Logger logger = Logger.getLogger(DEQueueTest.class.toString());

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

    private DEQueue createTestSubject()
    {
        return new DEQueue();
    }

    @MethodRef(name = "addToBack", signature = "(QNode2;)V")
    @Test
    public void testAddToBack() throws Exception
    {
        DEQueue testSubject;
        Node2 newNode2 = null;

        // test 1
        testSubject = createTestSubject();
        newNode2 = null;
        testSubject.addToBack(newNode2);
        String result = testSubject.toString();
        Assert.assertEquals("", result);

        Card crd1 = new Card('2', Card.Suit.spades);
        testSubject.addToBack(new CardNode2(crd1));
        Card crd2 = new Card('A', Card.Suit.spades);
        testSubject.addToBack(new CardNode2(crd2));
        result = testSubject.toString();
        String crd1string = crd1.toString();
        String crd2string = crd2.toString();
        Assert.assertEquals(true, result.contains(crd1string) && result.contains(crd2string));
        int crd1start = result.indexOf(crd1string);
        int crd2start = result.indexOf(crd2string);
        Assert.assertEquals(true, crd2start > crd1start);
    }

    @MethodRef(name = "removeFromFront", signature = "()QNode2;")
    @Test
    public void testRemoveFromFront() throws Exception
    {
        DEQueue testSubject;
        Node2 result = null;

        // default empty test
        testSubject = createTestSubject();
        verifyEmptyDEQueueWithRemoveFromFront(testSubject);

        Card crd1 = new Card('2', Card.Suit.spades);
        String crd1string = crd1.toString();
        testSubject.addToFront(new CardNode2(crd1));
        Card crd2 = new Card('A', Card.Suit.spades);
        String crd2string = crd2.toString();
        testSubject.addToFront(new CardNode2(crd2));
        String testSubjectString = testSubject.toString();
        Assert.assertEquals(true, testSubjectString.contains(crd1string) && testSubjectString.contains(crd2string));
        int crd1start = testSubjectString.indexOf(crd1string);
        int crd2start = testSubjectString.indexOf(crd2string);
        Assert.assertEquals(true, crd2start < crd1start);

        result = testSubject.removeFromFront();
        Assert.assertNotNull(result);
        Assert.assertEquals(crd2string, result.toString());
        testSubjectString = testSubject.toString();
        Assert.assertEquals(true, testSubjectString.contains(crd1string));
        Assert.assertEquals(false, testSubjectString.contains(crd2string));

        result = testSubject.removeFromFront();
        Assert.assertNotNull(result);
        Assert.assertEquals(crd1string, result.toString());
        testSubjectString = testSubject.toString();
        Assert.assertEquals(false, testSubjectString.contains(crd1string));
        result = null;
        verifyEmptyDEQueueWithRemoveFromFront(testSubject);

        Card crd3 = new Card('3', Card.Suit.spades);
        String crd3string = crd3.toString();
        testSubject.addToBack(new CardNode2(crd3));
        Card crd4 = new Card('4', Card.Suit.spades);
        String crd4string = crd4.toString();
        testSubject.addToBack(new CardNode2(crd4));
        testSubjectString = testSubject.toString();
//		Assert.assertEquals("3 of spades   4 of spades   ", testSubjectString);
        result = testSubject.removeFromFront();
        Assert.assertNotNull(result);
        Assert.assertEquals(crd3string, result.toString());
        testSubjectString = testSubject.toString();
        Assert.assertEquals(true, testSubjectString.contains(crd4string));
        Assert.assertEquals(false, testSubjectString.contains(crd3string));
    }

    /**
     * @param testSubject
     * @param result
     */
    void verifyEmptyDEQueueWithRemoveFromFront(DEQueue testSubject)
    {
        Node2 result = null;
        try
        {
            result = testSubject.removeFromFront();
        } catch (QueueEmptyException e)
        {
//			e.printStackTrace();
            Assert.assertNotNull(e);
        }
        Assert.assertNull(result);
    }

    /**
     * @param testSubject
     * @param result
     */
    void verifyEmptyDEQueueWithRemoveFromBack(DEQueue testSubject)
    {
        Node2 result = null;
        try
        {
            result = testSubject.removeFromBack();
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
        DEQueue testSubject;
        String result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.toString();
        Assert.assertEquals("", result);
    }

    @MethodRef(name = "addToFront", signature = "(QCardNode2;)V")
    @Test
    public void testAddToFront() throws Exception
    {
        DEQueue testSubject;
        CardNode2 newNode2 = null;

        // test 1
        testSubject = createTestSubject();
        newNode2 = null;
        testSubject.addToFront(newNode2);
        String result = testSubject.toString();
        Assert.assertEquals("", result);

        Card crd1 = new Card('2', Card.Suit.spades);
        testSubject.addToFront(new CardNode2(crd1));
        Card crd2 = new Card('A', Card.Suit.spades);
        testSubject.addToFront(new CardNode2(crd2));
        result = testSubject.toString();
        String crd1string = crd1.toString();
        String crd2string = crd2.toString();
        Assert.assertEquals(true, result.contains(crd1string) && result.contains(crd2string));
        int crd1start = result.indexOf(crd1string);
        int crd2start = result.indexOf(crd2string);
        Assert.assertEquals(true, crd2start < crd1start);
    }

    @MethodRef(name = "removeFromBack", signature = "()QNode2;")
    @Test
    public void testRemoveFromBack() throws Exception
    {
        DEQueue testSubject;
        Node2 result;

        // default empty test
        testSubject = createTestSubject();
        verifyEmptyDEQueueWithRemoveFromBack(testSubject);

        Card crd1 = new Card('2', Card.Suit.spades);
        String crd1string = crd1.toString();
        testSubject.addToBack(new CardNode2(crd1));
        Card crd2 = new Card('A', Card.Suit.spades);
        String crd2string = crd2.toString();
        testSubject.addToBack(new CardNode2(crd2));
        String testSubjectString = testSubject.toString();
        Assert.assertEquals(true, testSubjectString.contains(crd1string) && testSubjectString.contains(crd2string));
        int crd1start = testSubjectString.indexOf(crd1string);
        int crd2start = testSubjectString.indexOf(crd2string);
        Assert.assertEquals(true, crd2start > crd1start);

        result = testSubject.removeFromBack();
        Assert.assertNotNull(result);
        Assert.assertEquals(crd2string, result.toString());
        testSubjectString = testSubject.toString();
        Assert.assertEquals(true, testSubjectString.contains(crd1string));
        Assert.assertEquals(false, testSubjectString.contains(crd2string));

        result = testSubject.removeFromBack();
        Assert.assertNotNull(result);
        Assert.assertEquals(crd1string, result.toString());
        testSubjectString = testSubject.toString();
        Assert.assertEquals(false, testSubjectString.contains(crd1string));
        result = null;
        verifyEmptyDEQueueWithRemoveFromBack(testSubject);

        Card crd3 = new Card('3', Card.Suit.spades);
        String crd3string = crd3.toString();
        testSubject.addToFront(new CardNode2(crd3));
        Card crd4 = new Card('4', Card.Suit.spades);
        String crd4string = crd4.toString();
        testSubject.addToFront(new CardNode2(crd4));
        testSubjectString = testSubject.toString();
//		Assert.assertEquals("4 of spades   3 of spades   ", testSubjectString);
        result = testSubject.removeFromBack();
        Assert.assertNotNull(result);
        Assert.assertEquals(crd3string, result.toString());
        testSubjectString = testSubject.toString();
        Assert.assertEquals(true, testSubjectString.contains(crd4string));
        Assert.assertEquals(false, testSubjectString.contains(crd3string));
    }
}