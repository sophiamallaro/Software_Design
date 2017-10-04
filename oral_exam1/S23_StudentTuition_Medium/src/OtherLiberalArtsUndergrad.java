/**
 * This class represents out of state undergraduate students
 * in the College of liberal Arts
 * @author Sophia Mallaro
 * @see OtherLiberalArtsUndergrad
 */
public class OtherLiberalArtsUndergrad extends LiberalArtsUndergrad{
    /**
     * Basic constructor that calls the super constructor with all relevant student information
     * @param firstName Student First Name
     * @param lastName Student Last Name
     * @param studentID Student ID Number
     * @param numberOfRegisteredHours Number of Registered Hours
     * @param placeOfResidence Student place of residence
     */
    OtherLiberalArtsUndergrad(String firstName, String lastName, String studentID,
                         int numberOfRegisteredHours, String placeOfResidence) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, placeOfResidence);
    }

    /**
     * This method returns the tuition rate specified to this student
     * @return tuition rate
     */
    @Override
    public double getTuition() {
        return super.getTuition();
    }

    /**
     * This method overrides the print method to add the student's tuition rate
     */
    @Override
    public void print() {
        super.print();
        System.out.println("Semester Tuition:   " + getTuition());
    }
}
