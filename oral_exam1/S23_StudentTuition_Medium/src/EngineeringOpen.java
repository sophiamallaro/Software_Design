/**
 * This class represents all Engineering open enrolled students
 * @author Sophia Mallaro
 * @see EngineeringOpen
 */
public class EngineeringOpen extends Engineering {
    private static int fullLoad=3;
    private static String status = "Open Enrolled Student";
    /**
     * Basic constructor that calls the super constructor with all relevant student information
     * @param firstName Student First Name
     * @param lastName Student Last Name
     * @param studentID Student ID Number
     * @param numberOfRegisteredHours Number of Registered Hours
     * @param placeOfResidence Student place of residence
     */
    EngineeringOpen(String firstName, String lastName, String studentID,
                    int numberOfRegisteredHours, String placeOfResidence) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, placeOfResidence);
    }
    /**
     * Returns the number of classes considered a full load
     * @return int representation of full load
     */
    public static int getFullLoad() {
        return fullLoad;
    }
    /**
     * Allows Administrators to change the full load
     * @param fullLoad new full load
     */
    public static void setFullLoad(int fullLoad) {
        EngineeringOpen.fullLoad = fullLoad;
    }
    /**
     * Adds student status to the super class print method
     */
    @Override
    public void print() {
        super.print();
        System.out.println("Student Status:     " + EngineeringOpen.status);
    }
}
