/**
 * Student.java - This is the base class from which all other students inherit
 * @author Sophia Mallaro
 * @see Student
 */
public class Student {
    private String firstName;
    private String lastName;
    private String studentID;
    private int numberOfRegisteredHours;
    private String placeOfResidence;
    private static int baseTuition;
    private double tuition;

    /**
     * This constructor takes in all the basic student information
     * @param firstName Student first name
     * @param lastName Student last name
     * @param studentID Student ID
     * @param numberOfRegisteredHours Number of registered hours
     * @param placeOfResidence Place of Residence
     */
    Student(String firstName, String lastName, String studentID, int numberOfRegisteredHours, String placeOfResidence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.numberOfRegisteredHours = numberOfRegisteredHours;
        this.placeOfResidence = placeOfResidence;
    }

    /**
     * Get method to return the student's first name
     * @return Returns the students first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set method to set the student's first name
     * @param firstName String of first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get method to return the student's last name
     * @return String of the student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set method to set the student's last name
     * @param lastName String of new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get method to return the student's ID number
     * @return String of the student's ID number
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Set method to change the student ID number
     * @param studentID String of new ID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Get method to return the number of hours in which the student is enrolled
     * @return Int of number of enrolled hours
     */
    public int getNumberOfRegisteredHours() {
        return numberOfRegisteredHours;
    }

    /**
     * Set method to change the number of registered hours
     * @param numberOfRegisteredHours Number of registered hours
     */
    public void setNumberOfRegisteredHours(int numberOfRegisteredHours) { this.numberOfRegisteredHours = numberOfRegisteredHours; }

    /**
     * Get method of the student's place of residence
     * @return String containing the student's place of residence
     */
    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    /**
     * Set method to change place of residence
     * @param placeOfResidence String of new place of residence
     */
    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }
    /**
     * Get method to get base tuition. Used by inherited classes to calculate full tuition.
     * @return Returns number of registered hours times the base tuition rate.
     */
    public double getTuition() { return (numberOfRegisteredHours*Student.baseTuition); }

    /**
     * Static method to set base Tuition rate for all students
     * @param baseTuition Int of new base tuition rate
     */
    public static void setBaseTuition (int baseTuition) {
        Student.baseTuition = baseTuition;
    }

    /**
     * Static get method returning the base tuition rate
     * @return Base tuition rate
     */
    public static int getBaseTuition () {
        return baseTuition;
    }

    /**
     * Prints information pertinent to all students.
     * Inherited classes override this to add more information
     */
    public void print() {
        System.out.println("Name:               " + firstName + " " + lastName);
        System.out.println("Student ID:         " + studentID);
        System.out.println("Hours Enrolled:     " + numberOfRegisteredHours);
        System.out.println("Place of Residence: " + placeOfResidence);
    }
}
