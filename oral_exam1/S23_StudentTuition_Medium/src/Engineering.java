/**
 * This class represents all Engineering Students.
 * @author Sophia Mallaro
 * @see Engineering
 */
public class Engineering extends Student{
    private static double fees=200;
    private static int hoursToFees=6;
    private static String collegeName = "College of Engineering";
    /**
     * Basic constructor that calls the super constructor with all relevant student information
     * @param firstName Student First Name
     * @param lastName Student Last Name
     * @param studentID Student ID Number
     * @param numberOfRegisteredHours Number of Registered Hours
     * @param placeOfResidence Student place of residence
     */

    Engineering(String firstName, String lastName, String studentID,
                int numberOfRegisteredHours, String placeOfResidence) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, placeOfResidence);
    }

    /**
     * Returns the static value of fees associated with this college
     * @return College associated fees and services charge
     */
    public static double getFees() {
        return fees;
    }

    /**
     * Allows administrators to set the fees and services for this college
     * @param fees New fees
     */
    public static void setFees(int fees) {
        Engineering.fees = fees;
    }

    /**
     * Returns the number of hours in which a student must be enrolled to be charged
     * the fees and service fees
     * @return number of hours
     */
    public static int getHoursToFees() {
        return hoursToFees;
    }

    /**
     * Allows administrators to set the number of hours in which a student must be enrolled
     * to be charged the fees and services charges
     * @param hoursToFees New number of hours
     */
    public static void setHoursToFees(int hoursToFees) {
        Engineering.hoursToFees = hoursToFees;
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
    public static void setCollegeName(String collegeName) {Engineering.collegeName = collegeName; }

    /**
     * Overrides Student's getTuition to add in Engineering fees and services
     * @return new tuition rate
     */
    @Override
    public double getTuition() {
        if(super.getNumberOfRegisteredHours() > Engineering.hoursToFees) {
            return (super.getTuition() + Engineering.getFees());
        }
        else return super.getTuition();
    }

    @Override
    public void print() {
        super.print();
        System.out.println("College Enrolled:   " + Engineering.collegeName);
    }

}
