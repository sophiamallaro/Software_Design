/**
 * EasterTest.java - This class uses JUnit 4 to test the dates of 20 easters
 * to check the validity of the class
 * @author Sophia Mallaro
 * @see EasterTest
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class EasterTest {
    //Arrays of Easter Dates from 1990-2009
    //Source of Easter Test Days: http://www.gmarts.org/index.php?go=413
    private static final String[] months = {"April", "March", "April", "April", "April",
            "April", "April", "March", "April", "April",
            "April", "April", "March", "April", "April",
            "March", "April", "April", "March", "April"};
    private static final int[] days = {15, 31, 19, 11, 3, 16, 7, 30, 12, 4,
            23, 15, 31, 20, 11, 27, 16, 8, 23, 12};

    /**
     * This method creates 20 easter objects and tests the date against
     * a list of known dates
     * @throws Exception Throws an exception if the test proves the class invalid
     */
    @Test
    public void testDates() throws Exception {
        for(int i=0; i<20; i++) {
            Easter easter = new Easter(1990+i);
            assertEquals(months[i], easter.getMonth());
            assertEquals(days[i], easter.getDay());
        }
    }
}
