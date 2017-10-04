/**
 * This class represents undergraduate engineering students from iowa
 * @author Sophia Mallaro
 * @see IowaEngineeringUndergrad
 */
public class IowaEngineeringUndergrad extends EngineeringUndergrad {
    /**
     * Basic constructor that calls the super constructor with all relevant student information
     * @param firstName Student First Name
     * @param lastName Student Last Name
     * @param studentID Student ID Number
     * @param numberOfRegisteredHours Number of Registered Hours
     * @param placeOfResidence Student place of residence
     */
    IowaEngineeringUndergrad(String firstName, String lastName, String studentID,
                        int numberOfRegisteredHours, String placeOfResidence) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, placeOfResidence);
    }
    /**
     * This method returns the tuition rate specified to this student
     * @return tuition rate
     */
    @Override
    public double getTuition() {
        if(getNumberOfRegisteredHours() < EngineeringUndergrad.getFullLoad() ){
            return (super.getTuition() - (getNumberOfRegisteredHours()*0.35*Student.getBaseTuition()));
        }
        else{
            return(super.getTuition() - ((EngineeringUndergrad.getFullLoad()*0.35*Student.getBaseTuition()) + ((getNumberOfRegisteredHours()-EngineeringUndergrad.getFullLoad())*0.1*Student.getBaseTuition())));
        }
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
