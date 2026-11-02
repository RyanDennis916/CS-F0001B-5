
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
public class CardQueueTest
{

//	@Generated(value = "org.junit-tools-1.0.6")
    private Logger logger = Logger.getLogger(CardQueueTest.class.toString());

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

    private CardQueue createTestSubject()
    {
        return new CardQueue();
    }

    /**
     * @param testSubject
     * @param result
     */
    void verifyEmptyCardQueue(CardQueue testSubject)
    {
        Card result = null;
        try
        {
            result = testSubject.removeCard();
        } catch (QueueEmptyException e)
        {
            // e.printStackTrace();
            Assert.assertNotNull(e);
        }
        Assert.assertNull(result);
    }

    @MethodRef(name = "addCard", signature = "(QCard;)V")
    @Test
    public void testAddCard() throws Exception
    {
        CardQueue testSubject;
        Card crd = null;

        // test null card
        testSubject = createTestSubject();
        testSubject.addCard(crd);
        Assert.assertEquals("", testSubject.toString().trim());

        // test adding completed Nodes
        testSubject = createTestSubject();
        crd = new Card();
        testSubject.addCard(crd);
        Assert.assertEquals(true, testSubject.toString().toLowerCase().contains("a of spades"));
        crd = new Card('2', Card.Suit.clubs);
        testSubject.addCard(crd);
        Assert.assertEquals(true, testSubject.toString().toLowerCase().contains("2 of clubs"));
    }

    @MethodRef(name = "removeCard", signature = "()QCard;")
    @Test
    public void testRemoveCard() throws Exception
    {
        CardQueue testSubject;
        Card result;

        // default test
        testSubject = createTestSubject();
        verifyEmptyCardQueue(testSubject);

        // test after adding 2 completed Nodes
        testSubject = createTestSubject();
        Card crd = new Card();
        testSubject.addCard(crd);
        Assert.assertEquals(true, testSubject.toString().contains(crd.toString()));
        crd = new Card('2', Card.Suit.clubs);
        testSubject.addCard(crd);
        Assert.assertEquals(true, testSubject.toString().contains(crd.toString()));
        result = testSubject.removeCard();
        Assert.assertNotNull(result);
        Assert.assertEquals(false, testSubject.toString().contains(result.toString()));
        result = testSubject.removeCard();
        Assert.assertNotNull(result);
        Assert.assertEquals(false, testSubject.toString().contains(result.toString()));
        // Queue should be empty now
        verifyEmptyCardQueue(testSubject);
    }
}