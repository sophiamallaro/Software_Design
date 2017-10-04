/**
 * Cycle.java - This is a class used for the calculation of the number of times
 * easter falls on a given day over an inputted number of years starting at an
 * inputted year
 * @author Sophia Mallaro
 * @see Cycle
 */
public class Cycle {
    private int[][] dates = new int[2][32]; //March 22 - April 25
    private int numYears;
    private int startYear;

    /**
     * This is a constructor for creating a new cycle
     * @param numYears The number of years in the cycle
     * @param startYear The start year for the cycle
     */
    Cycle(int numYears, int startYear) {
        if(numYears < 0 || startYear < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        else {
            this.numYears = numYears;
            this.startYear = startYear;
        }
    }

    /**
     * This is a private method used by the display method that
     * creates Easter objects for each year and stores the number of times
     * Easter falls on each date in an array
     */
    private void Calculate() {
        System.out.println("Number of Times Easter Falls on Each Calendar Date Over One Cycle");
        for(int i=startYear; i<numYears+startYear; i++) {
            Easter easter = new Easter(i);
            String month = easter.getMonth();
            if(month.equals("March")) {
                dates[0][easter.getDay()]++;
            }
            else { //April
                dates[1][easter.getDay()]++;
            }
        }
    }

    /**
     * This method outputs each potential day Easter could fall alongside
     * the number of times Easter falls on that date in the given cycle
     */
    public void Display() {
        Calculate();
        for(int i=22; i<32; i++) { //Print March Dates
            System.out.println("March" + " " + i + " - " + dates[0][i]);
        }
        for(int i=1; i<26; i++) { //Print April Dates
            System.out.println("April" + " " + i + " - " + dates[1][i]);
        }
    }

}
