
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
 * Tests for the Card class
 */
public class CardTest {

	private static final CardInterface.Suit DEFAULT_SUIT = CardInterface.Suit.spades;
	private static final char DEFAULT_RANK = 'A';
	// @Generated(value = "org.junit-tools-1.0.6")
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(CardTest.class.toString());

	/**
	 * @throws Exception if the setup before this class fails.
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * @throws Exception if the setup before a test fails.
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws Exception if the tear down after a test fails.
	 */
	@After
	public void tearDown() throws Exception {

	}

	/**
	 * @throws Exception if the tear down after this class fails.
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	private Card createTestSubject() {
		return new Card(DEFAULT_RANK, DEFAULT_SUIT);
	}

	/**
	 * @throws Exception
	 */
	@MethodRef(name = "Suit", signature = "(CQSuit;)Z")
	@Test
	public void testSuit() throws Exception {
		CardInterface.Suit[] expected = { CardInterface.Suit.clubs, CardInterface.Suit.diamonds,
				CardInterface.Suit.hearts, DEFAULT_SUIT };
		Assert.assertArrayEquals(
				"Student didn't put the suits in the enum in the specified order with the specified names, or has the wrong number of suit elements",
				expected, CardInterface.Suit.values());
	}

	/**
	 * @throws Exception
	 */
	@MethodRef(name = "set", signature = "(CQSuit;)Z")
	@Test
	public void testSet() throws Exception {
		Card testSubject;
		char value = ' ';
		CardInterface.Suit suit = null;
		boolean result;

		// default test
		testSubject = createTestSubject();
		// Make the testSubject invalid
		result = testSubject.set(value, suit);
		Assert.assertFalse(result);
		Assert.assertTrue(testSubject.isErrorFlag());
		Assert.assertEquals(
				"You must set invalid value and suit data too, just make sure you set the errorFlag to true.", value,
				testSubject.getRank());
		Assert.assertEquals(suit, testSubject.getSuit());
		result = testSubject.set(value, DEFAULT_SUIT);
		Assert.assertFalse(result);
		Assert.assertTrue(testSubject.isErrorFlag());
		Assert.assertEquals(
				"You must set invalid value and suit data too, just make sure you set the errorFlag to true.", value,
				testSubject.getRank());
		Assert.assertEquals(DEFAULT_SUIT, testSubject.getSuit());
		// Make the testSubject valid
		value = 'J';
		suit = CardInterface.Suit.hearts;
		result = testSubject.set(value, suit);
		Assert.assertTrue(result);
		Assert.assertFalse("After making an invalid card valid, isErrorFlag() should return false.",
				testSubject.isErrorFlag());
		Assert.assertEquals(value, testSubject.getRank());
		Assert.assertEquals(suit, testSubject.getSuit());
	}

	/**
	 * @throws Exception
	 */
	@MethodRef(name = "getValue", signature = "()C")
	@Test
	public void testGetValue() throws Exception {
		Card testSubject;
		char result;

		// default test
		testSubject = createTestSubject();
		// result = testSubject.getVal();
		result = testSubject.getRank();// Student uses getValue instead of getVal
		Assert.assertEquals(DEFAULT_RANK, result);
	}

	/**
	 * @throws Exception
	 */
	@MethodRef(name = "getSuit", signature = "()QSuit;")
	@Test
	public void testGetSuit() throws Exception {
		Card testSubject;
		CardInterface.Suit result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getSuit();
		Assert.assertEquals(DEFAULT_SUIT, result);
	}

	/**
	 * @throws Exception
	 */
	@MethodRef(name = "isErrorFlag", signature = "()Z")
	@Test
	public void testIsErrorFlag() throws Exception {
		Card testSubject;
		// boolean result;

		// default test
		testSubject = createTestSubject();
		// result = testSubject.getErrorFlag();
		Assert.assertFalse(testSubject.isErrorFlag()); // Student used 'is' predicate
		// naming
		// Assert.assertFalse(result); // Student used 'is' predicate naming
		testSubject.set('~', testSubject.getSuit());
		// Assert.assertTrue(testSubject.getErrorFlag());
		Assert.assertTrue(testSubject.isErrorFlag()); // Student used 'is' predicate
		// naming
		testSubject = new Card('~', testSubject.getSuit());
		Assert.assertTrue(testSubject.isErrorFlag()); // Student used 'is' predicate
		testSubject = new Card(testSubject);
		Assert.assertTrue(
				"Use the set method so that the input card's data is validated and the errorFlag is set correctly. "
						+ "Don't directly set the member instance variables in the constructors.",
				testSubject.isErrorFlag()); // Student correctly used 'is' predicate
	}

	/**
	 * @throws Exception
	 */
	@MethodRef(name = "toString", signature = "()QString;")
	@Test
	public void testToString() throws Exception {
		Card testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toString();
		Assert.assertEquals("a of spades", result.toLowerCase());

		// make the Card bad and test again
		testSubject.set('~', CardInterface.Suit.clubs);
		result = testSubject.toString();
		Assert.assertTrue(result.equalsIgnoreCase("** illegal **") || result.equalsIgnoreCase("**Illegal**")
				|| result.equalsIgnoreCase("[invalid]") || result.equalsIgnoreCase("[ invalid ]")
				|| result.equalsIgnoreCase("** invalid **") || result.equalsIgnoreCase("**invalid**")
				|| result.equalsIgnoreCase("Invalid Card") || result.equalsIgnoreCase("-Invalid Card-"));
	}

	/**
	 * @throws Exception
	 */
	@MethodRef(name = "isValid", signature = "(CQSuit;)Z")
	@Test
	public void testIsValid() throws Exception {
		char value = DEFAULT_RANK;
		CardInterface.Suit suit = DEFAULT_SUIT;
		boolean result;

		// test for detection of valid data
		// result = Card.isValid(value, suit);
		result = Deencapsulation.invoke(Card.class, "isValid", new Object[] { value, suit });
		Assert.assertTrue(result);
		value = 'J';
		suit = CardInterface.Suit.diamonds;
		// result = Card.isValid(value, suit);
		result = Deencapsulation.invoke(Card.class, "isValid", new Object[] { value, suit });
		Assert.assertTrue(result);
		// test for detection of invalid data cancelled because can't pass null
		// good value, bad suit
		// value = 'J';
		// suit = null;
		// result = Deencapsulation.invoke(Card.class, "isValid", new Object[] { value,
		// suit });
		// Assert.assertFalse(result);
		// test for detection of invalid data
		// bad value, good suit
		value = ' ';
		suit = CardInterface.Suit.diamonds;
		result = Deencapsulation.invoke(Card.class, "isValid", new Object[] { value, suit });
		Assert.assertFalse(result);
	}

	/**
	 * @throws Exception
	 */
	@MethodRef(name = "equals", signature = "(QCard;)Z")
	@Test
	public void testEquals() throws Exception {
		Card testSubject;
		Card card = new Card(DEFAULT_RANK, DEFAULT_SUIT);
		boolean result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.equals(card);
		Assert.assertTrue(result);

		// different value test
		testSubject = createTestSubject();
		testSubject.set('J', testSubject.getSuit());
		result = testSubject.equals(card);
		Assert.assertFalse(result);

		// different suit test
		testSubject = createTestSubject();
		testSubject.set(testSubject.getRank(), CardInterface.Suit.clubs);
		result = testSubject.equals(card);
		Assert.assertFalse(result);

		// different errorFlag test
		testSubject = createTestSubject();
		Deencapsulation.setField(testSubject, "errorFlag", true);
		Assert.assertTrue(testSubject.isErrorFlag()); // Student used 'is' predicate
		// naming
		result = testSubject.equals(card);
		Assert.assertEquals("ERROR: Student is not checking if the errorFlag is true", false, result); // if result is
																										// true, ERROR:
																										// Student is
																										// not
																										// checking if
																										// the errorFlag
																										// is true
		// test if error cards are equal
		testSubject = createTestSubject();
		testSubject.set('z', testSubject.getSuit());
		card = new Card('z', DEFAULT_SUIT);
		result = testSubject.equals(card);
		Assert.assertTrue(result);
	}

	/**
	 * @throws Exception
	 */
	@MethodRef(name = "Card", signature = "(QCard;)Z")
	@Test
	public void testCard() throws Exception {
		Card testSubject;
		Card card = new Card(DEFAULT_RANK, DEFAULT_SUIT);
		// boolean result;

		// Check constants from the CardInterface and the Card class
		Assert.assertEquals(String.valueOf(DEFAULT_RANK), String.valueOf(CardInterface.DEFAULT_RANK));
		Assert.assertEquals(String.valueOf(DEFAULT_RANK), String.valueOf(Card.DEFAULT_RANK));
		Assert.assertEquals(DEFAULT_SUIT, CardInterface.DEFAULT_SUIT);
		Assert.assertEquals(DEFAULT_SUIT, Card.DEFAULT_SUIT);

		// test constructors
		testSubject = new Card();
		Assert.assertEquals(testSubject.toString(), card.toString());
		Assert.assertEquals(true, testSubject.equals(card));

		testSubject = new Card();
		Assert.assertEquals(DEFAULT_RANK + " of " + DEFAULT_SUIT.toString(), testSubject.toString());
		testSubject = new Card(card);
		Assert.assertEquals(DEFAULT_RANK + " of " + DEFAULT_SUIT.toString(), testSubject.toString());
		testSubject = new Card(card.getRank());
		Assert.assertEquals(DEFAULT_RANK + " of " + DEFAULT_SUIT.toString(), testSubject.toString());
		// The following constructor is not required until Assignment 2:
		testSubject = new Card(card.getSuit());
		Assert.assertEquals(DEFAULT_RANK + " of " + DEFAULT_SUIT.toString(), testSubject.toString());
	}
}