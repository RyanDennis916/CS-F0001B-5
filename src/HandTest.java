
import java.util.logging.Logger;

//import javax.annotation.Generated;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import mockit.Deencapsulation;

//@Generated(value = "org.junit-tools-1.0.6")
/**
 * Test the Hand class.
 */
public class HandTest
{
//  @Generated(value = "org.junit-tools-1.0.6")
    private Logger logger = Logger.getLogger(HandTest.class.toString());
    private Card card = null;
    /**
     * This constant of maximum cards per hand should cover any possible game.
     */
    public static final int MAX_CARDS_PER_HAND = 50;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception
    {
        card = new Card('A', Card.Suit.spades);
    }

    /**
     * @throws Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {

    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception
    {
        card = null;
    }

    /**
     * @throws Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {

    }

    private Hand createTestSubject()
    {
        return new Hand();
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "resetHand", signature = "()V")
    @Test
    public void testResetHand() throws Exception
    {
        Hand testSubject;

        // default test
        testSubject = createTestSubject();
        Assert.assertEquals(0, testSubject.getNumCards());
        testSubject.takeCard(card);
        Assert.assertEquals(1, testSubject.getNumCards());
        testSubject.resetHand();

        Assert.assertEquals(0, testSubject.getNumCards());
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "takeCard", signature = "(QCard;)Z")
    @Test
    public void testTakeCard() throws Exception
    {
        Hand testSubject;
        boolean result;

        // default test
        testSubject = createTestSubject();
        result = testSubject.takeCard(card);

        Assert.assertTrue(result);
        Assert.assertTrue(testSubject.toString().contains("A of spades"));

        /*
         * Test that the student is using an object copy, not a reference copy, inside
         * of the takeCard method. Make sure that card and the first card now in the
         * Hand testSubject do not refer to the same object
         */
        String message = "The instructions said:\n"
                + "\"This is an object copy, not a reference copy, since the source of the Card might destroy or change its data after our Hand gets it -- we want our local data to be exactly as it was when we received it.\"\n"
                + "So you must clone the card instead of using the original card object. You do that by creating a new Card object and then using: \n"
                + "set(card.getRank(), card.getSuit())\n";
        Assert.assertNotSame(message, card, testSubject.inspectCard(0));

        // test that a hand can get full and eventually takeCard returns a false
        int takenCards = 1;
        while (result)
        {
            result = testSubject.takeCard(card);
            if (result)
            {
                ++takenCards;
                if (takenCards > MAX_CARDS_PER_HAND)
                {
                    Assert.fail("A Hand object should not be able to take more than " + MAX_CARDS_PER_HAND + " Card objects.");
                }
            }
        }
        Assert.assertFalse(result);

        /*
         * Make sure invalid cards are not cloned and taken into the myCards array (but
         * still return true if there was room).
         */
        Card validCard = new Card();
        Card invalidCard = new Card('~', CardInterface.Suit.diamonds); // Card must implement CardInterface
        // When there is no more room in the hand, calling takeCard should return false.
        result = testSubject.takeCard(validCard);
        Assert.assertFalse("When there is no more room in the hand, calling takeCard should return false.", result);
        result = testSubject.takeCard(invalidCard);
        Assert.assertFalse("When there is no more room in the hand, calling takeCard should return false.", result);
        // Playing 2 cards to make room
        testSubject.playCard();
        testSubject.playCard();
        // Taking cards when there is room should result in true
        result = testSubject.takeCard(validCard);
        Assert.assertTrue(result);
        result = testSubject.takeCard(invalidCard);
        Assert.assertTrue(result);
        // Make sure the invalid card wasn't actually cloned and taken
        Card topCard = testSubject.inspectCard(testSubject.getNumCards() - 1);
        Assert.assertFalse("You should NOT have put a clone of an invalid card into the array.",
                invalidCard.equals(topCard));
        Assert.assertTrue("You should NOT have put a clone of an invalid card into the array.",
                validCard.equals(topCard));
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "playCard", signature = "()QCard;")
    @Test
    public void testPlayCard() throws Exception
    {
        Hand testSubject;
        Card result;

        // default test
        testSubject = createTestSubject();
        Assert.assertTrue(testSubject.takeCard(card));
        Assert.assertNotNull(testSubject.toString());
        Assert.assertTrue(testSubject.toString().contains("A of spades"));
        result = testSubject.playCard();
        Assert.assertFalse(testSubject.toString().contains(" of "));
        result = testSubject.playCard();
        Assert.assertNotNull("Calling playCard on an empty hand should result in an error card", result);
//      Assert.assertTrue(result.getErrorFlag());
        Assert.assertTrue(result.isErrorFlag()); // Student used 'is' predicate
        // naming
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "inspectCard", signature = "(I)QCard;")
    @Test
    public void testInspectCard() throws Exception
    {
        Hand testSubject;
        int k = 0;
        Card result;

        // test 1
        testSubject = createTestSubject();
        Card validCard = new Card('3', Card.Suit.hearts);
        Assert.assertTrue(testSubject.takeCard(validCard));
        k = 0;
        result = testSubject.inspectCard(k);
        Assert.assertNotNull(result); // A failure here means student didn't use zero-indexing properly
        Assert.assertFalse(result.isErrorFlag()); // Student used 'is' predicate
        // naming
//      Assert.assertFalse(result.getErrorFlag());
        Assert.assertTrue("The result of inspectCard(0) should equal to the validCard taken first into the hand.",
                validCard.equals(result));

        // test 2
        testSubject = createTestSubject();
        k = -1;
        result = Deencapsulation.invoke(testSubject, "inspectCard", new Object[]
        { k });
//      Assert.assertEquals(true, result.getErrorFlag());
        Assert.assertTrue(result.isErrorFlag()); // Student used 'is' predicate
        // naming

        // test 3
        testSubject = createTestSubject();
        k = 1;
        result = Deencapsulation.invoke(testSubject, "inspectCard", new Object[]
        { k });
        Assert.assertNotNull(result);
//      Assert.assertEquals(true, result.getErrorFlag());
        Assert.assertTrue(result.isErrorFlag()); // Student used 'is' predicate
        // naming

        // Assert.fail();
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "toString", signature = "()QString;")
    @Test
    public void testToString() throws Exception
    {
        Hand testSubject;
        String result;

        // default test
        Assert.assertNotNull(testSubject = createTestSubject());
        Assert.assertTrue(testSubject.takeCard(card));// Taking A of spades
        Assert.assertTrue(testSubject.takeCard(new Card('J', Card.Suit.diamonds)));
        result = testSubject.toString();
        Assert.assertTrue(result.contains("A of spades"));
        Assert.assertTrue(result.contains("J of diamonds"));
        testSubject.playCard();
        result = testSubject.toString();
        Assert.assertTrue("The A of spades was taken first, so it should be played last.",
                result.contains("A of spades"));
        testSubject.playCard();
        result = testSubject.toString();
        Assert.assertFalse(result.contains(" of "));
    }

    /**
     * @throws Exception
     */
    @MethodRef(name = "getNumCards", signature = "()I")
    @Test
    public void testGetNumCards() throws Exception
    {
        Hand testSubject;
        int result;

        // default test
        testSubject = createTestSubject();
        result = Deencapsulation.invoke(testSubject, "getNumCards");

        Assert.assertEquals(0, result);
    }
}