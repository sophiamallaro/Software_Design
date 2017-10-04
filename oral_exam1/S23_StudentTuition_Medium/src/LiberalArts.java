/**
 * This class represents all Liberal Arts Students
 * @author Sophia Mallaro
 * @see LiberalArts
 */
public class LiberalArts extends Student {
    private static int fees=400;
    private static double hoursToFees=3;
    private static String collegeName = "College of Liberal Arts and Sciences";
    /**
     * Basic constructor that calls the super constructor with all relevant student information
     * @param firstName Student First Name
     * @param lastName Student Last Name
     * @param studentID Student ID Number
     * @param numberOfRegisteredHours Number of Registered Hours
     * @param placeOfResidence Student place of residence
     */
    LiberalArts(String firstName, String lastName, String studentID,
                int numberOfRegisteredHours, String placeOfResidence) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, placeOfResidence);
    }

    /**
     * Returns the static value of fees associated with this college
     * @return College associated fees and services charge
     */
    public static int getFees() {
        return fees;
    }

    /**
     * Allows administrators to set the fees and services for this college
     * @param fees New fees
     */
    public static void setFees(int fees) {
        LiberalArts.fees = fees;
    }

    /**
     * Returns the number of hours in which a student must be enrolled to be charged
     * the fees and service fees
     * @return number of hours
     */
    public static double getHoursToFees() {
        return hoursToFees;
    }

    /**
     * Allows administrators to set the number of hours in which a student must be enrolled
     * to be charged the fees and services charges
     * @param hoursToFees New number of hours
     */
    public static void setHoursToFees(int hoursToFees) {
        LiberalArts.hoursToFees = hoursToFees;
    }

    /**
     * Returns the college's name in string format
     * @return college name
     */
    public static String getCollegeName() {return collegeName; };

    /**
     * Allows administrators to change the name of the college
     * @param collegeName new college name
     */
    public static void setCollegeName(String collegeName) {LiberalArts.collegeName = collegeName; }

    /**
     * Overrides Student's getTuition to add in Liberal Arts fees and services
     * @return new tuition rate
     */
    @Override
    public double getTuition() {
        if(super.getNumberOfRegisteredHours() > LiberalArts.hoursToFees) {
            return (super.getTuition() + LiberalArts.fees);
        }
        else return super.getTuition();
    }

    @Override
    public void print() {
        super.print();
        System.out.println("College Enrolled:   " + LiberalArts.collegeName);
    }
}
