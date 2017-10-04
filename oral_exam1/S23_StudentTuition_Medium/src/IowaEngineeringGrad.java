/**
 * This class represents graduate engineering students from Iowa
 * @author Sophia Mallaro
 * @see IowaEngineeringGrad
 */
public class IowaEngineeringGrad extends EngineeringGrad {
    /**
     * Basic constructor that calls the super constructor with all relevant student information
     * @param firstName Student First Name
     * @param lastName Student Last Name
     * @param studentID Student ID Number
     * @param numberOfRegisteredHours Number of Registered Hours
     * @param placeOfResidence Student place of residence
     */
    IowaEngineeringGrad(String firstName, String lastName, String studentID,
                int numberOfRegisteredHours, String placeOfResidence) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, placeOfResidence);
    }

    /**
     * This method returns the tuition rate specified to this student
     * @return tuition rate
     */
    @Override
    public double getTuition() {
        if(getNumberOfRegisteredHours() < EngineeringGrad.getFullLoad() ){
            return (super.getTuition() - (getNumberOfRegisteredHours()*0.35*Student.getBaseTuition()));
        }
        else{
            return(super.getTuition() - ((EngineeringGrad.getFullLoad()*0.35*Student.getBaseTuition()) + ((getNumberOfRegisteredHours()-EngineeringGrad.getFullLoad())*Student.getBaseTuition()*0.1)));
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
