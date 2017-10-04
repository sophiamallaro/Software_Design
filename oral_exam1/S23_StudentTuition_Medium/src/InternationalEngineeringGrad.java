/**
 * This class represents international graduate students
 * in the Colelge of Engineering
 * @author Sophia Mallaro
 * @see InternationalEngineeringGrad
 */
public class InternationalEngineeringGrad extends EngineeringGrad{
    /**
     * Basic constructor that calls the super constructor with all relevant student information
     * @param firstName Student First Name
     * @param lastName Student Last Name
     * @param studentID Student ID Number
     * @param numberOfRegisteredHours Number of Registered Hours
     * @param placeOfResidence Student place of residence
     */
    InternationalEngineeringGrad(String firstName, String lastName, String studentID,
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
            return (super.getTuition() + (getNumberOfRegisteredHours()*Student.getBaseTuition()*0.03));
        }
        else{
            return(super.getTuition() +  (EngineeringGrad.getFullLoad()*Student.getBaseTuition()*0.03));
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
