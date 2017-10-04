/**
 * Easter.java - This class is to represent the date of Easter.
 * It takes in a year and calculates the day and month.
 * The class has methods to return the day, month and year.
 * @author Sophia Mallaro
 * @see Easter
 */
public class Easter {
    private int year; //Year of Easter
    private int day; //Day of Easter
    private final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private String month;

    /**
     * This is a constructor for creating a new Easter object.
     * @param year The year of Easter
     */
    Easter(int year) {
        if(year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        }
        int a = year % 19;
        int b = java.lang.Math.floorDiv(year,100);
        int c = year % 100;
        int d = java.lang.Math.floorDiv(b,4);
        int e = b % 4;
        int f = java.lang.Math.floorDiv((b+8),25);
        int g = java.lang.Math.floorDiv((b-f+1),3);
        int h = ((19*a + b - d - g + 15) % 30);
        int i = java.lang.Math.floorDiv(c,4);
        int k = c % 4;
        int l = (32 + 2*e + 2*i - h - k) % 7;
        int m = java.lang.Math.floorDiv((a + 11*h + 22*l), 451);
        int month = java.lang.Math.floorDiv((h + l - 7*m + 114), 31);
        this.day = ((h+ l - 7*m + 114) % 31) + 1;
        this.month = months[month-1];
    }
    /**
     *Reurns the month of easter as a String
     *@return month
     */
    public String getMonth() {
        return month;
    }

    /**
     * Returns the day of easter as an integer
     * @return day
     */
    public int getDay() { return day; }

    /**
     * Returns the year of easter as an integer
     * @return year
     */
    public int getYear() { return year; }
}
