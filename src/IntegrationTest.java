
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;

//import javax.annotation.Generated;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

//import Card.Suit;

//@Generated(value = "org.junit-tools-1.0.6")
public class IntegrationTest
{

    public static final String newLine = System.lineSeparator();
    private static final int MAX_HANDS = 10;
//	@Generated(value = "org.junit-tools-1.0.6")
    private Logger logger = Logger.getLogger(IntegrationTest.class.toString());
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream sysOutStream = System.out;

    @Before
    public void setUp() throws Exception
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {

    }

    @After
    public void tearDown() throws Exception
    {
        System.setOut(sysOutStream);
        System.out.println("outContent:");
        System.out.println(outContent);

        System.setErr(sysOutStream);
        System.out.println("errContent:");
        System.out.println(errContent);

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {

    }

    /**
     * Run all the code that would be in main methods for option A and option B
     * 
     * @throws Exception
     */
    @MethodRef(name = "main", signature = "([QString;)V")
    @Test
    public void testMain() throws Exception
    {
        // Option A
        CardQueue cardQ = new CardQueue();

        cardQ.addCard(new Card('A', Card.Suit.spades));
        cardQ.addCard(new Card('2', Card.Suit.hearts));
        cardQ.addCard(new Card('3', Card.Suit.hearts));
        cardQ.addCard(new Card('4', Card.Suit.clubs));

        System.out.println(IntegrationTest.newLine + "Show contents of queue:" + cardQ);

        try
        {
            System.out.println(IntegrationTest.newLine + IntegrationTest.newLine + "Now remove and show:");
            for (int k = 0; k < 6; k++)
            {
                System.out.print(cardQ.removeCard() + "   ");
            }
            System.out.println();
        } catch (QueueEmptyException ex)
        {
            System.out.println(IntegrationTest.newLine + " *** tried to pop from  empty queue ***");
        }
        Assert.assertEquals(IntegrationTest.newLine
                + "Show contents of queue:A of spades   2 of hearts   3 of hearts   4 of clubs   " + newLine
                + IntegrationTest.newLine + IntegrationTest.newLine + "Now remove and show:" + newLine
                + "A of spades   2 of hearts   3 of hearts   4 of clubs   " + newLine
                + " *** tried to pop from  empty queue ***" + newLine, outContent.toString());
        Assert.assertEquals("", errContent.toString());
        outContent.reset();
        errContent.reset();
        // Option B
//		DEQueue deque = new DEQueue();
//		deque.addToFront(new CardNode2(new Card('2', Card.Suit.spades)));
//		deque.addToFront(new CardNode2(new Card('A', Card.Suit.spades)));
//		deque.addToBack(new CardNode2(new Card('3', Card.Suit.spades)));
//		deque.addToBack(new CardNode2(new Card('4', Card.Suit.spades)));
//		System.out.println(deque.toString());
//		// System.out.println(deque.toStringReversed());
//		try {
//			deque.removeFromFront();
//			deque.removeFromBack();
//		} catch (QueueEmptyException e) {
//			e.printStackTrace();
//		}
//		System.out.println(deque.toString());
//		// System.out.println(deque.toStringReversed());
//		Assert.assertEquals("A of spades   2 of spades   3 of spades   4 of spades   " + newLine
//				+ "2 of spades   3 of spades   " + newLine, outContent.toString());
//		Assert.assertEquals("", errContent.toString());
    }
}