/**
 * THis class represents graduate Liberal Arts Student
 * from out of state
 * @author Sophia Mallaro
 * @see OtherLiberalArtsGrad
 */
public class OtherLiberalArtsGrad extends LiberalArtsGrad{
    /**
     * Basic constructor that calls the super constructor with all relevant student information
     * @param firstName Student First Name
     * @param lastName Student Last Name
     * @param studentID Student ID Number
     * @param numberOfRegisteredHours Number of Registered Hours
     * @param placeOfResidence Student place of residence
     */
    OtherLiberalArtsGrad(String firstName, String lastName, String studentID,
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
