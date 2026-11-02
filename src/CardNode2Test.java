
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
public class CardNode2Test
{

//	@Generated(value = "org.junit-tools-1.0.6")
    private Logger logger = Logger.getLogger(CardNode2Test.class.toString());

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

    private CardNode2 createTestSubject()
    {
        return new CardNode2(null);
    }

    @MethodRef(name = "toString", signature = "()QString;")
    @Test
    public void testToString() throws Exception
    {
        CardNode2 testSubject;
        String result = null;

        // default test
        testSubject = createTestSubject();
        try
        {
            result = testSubject.toString();
        } catch (NullPointerException e)
        {
//			e.printStackTrace();
            Assert.assertNotNull(e);
        }
        Assert.assertNull(result);

        Card crd = new Card();
        testSubject = new CardNode2(crd);
        result = testSubject.toString();
        Assert.assertNotNull(result);
        Assert.assertEquals(true, result.contains(crd.toString()));
    }

    @MethodRef(name = "getData", signature = "()QCard;")
    @Test
    public void testGetData() throws Exception
    {
        CardNode2 testSubject;
        Card result;

        // default test
        testSubject = createTestSubject();
        // result = testSubject.GetData();// Old bad naming
        result = testSubject.getData();
        Assert.assertNull(result);

        Card crd = new Card();
        testSubject = new CardNode2(crd);
        // result = testSubject.GetData();// Old bad naming
        result = testSubject.getData();
        Assert.assertNotNull(result);
        Assert.assertEquals(true, result.equals(crd));
    }
}