/**
 * This class represents graduate liberal arts students from iowa
 * @author Sophia Mallaro
 * @see IowaLiberalArtsGrad
 */
public class IowaLiberalArtsGrad extends LiberalArtsGrad{
    /**
     * Basic constructor that calls the super constructor with all relevant student information
     * @param firstName Student First Name
     * @param lastName Student Last Name
     * @param studentID Student ID Number
     * @param numberOfRegisteredHours Number of Registered Hours
     * @param placeOfResidence Student place of residence
     */
    IowaLiberalArtsGrad(String firstName, String lastName, String studentID,
                        int numberOfRegisteredHours, String placeOfResidence) {
        super(firstName, lastName, studentID, numberOfRegisteredHours, placeOfResidence);
    }
    /**
     * This method returns the tuition rate specified to this student
     * @return tuition rate
     */
    @Override
    public double getTuition() {
        if(getNumberOfRegisteredHours() < LiberalArtsGrad.getFullLoad() ){
            return (super.getTuition() - (getNumberOfRegisteredHours()*0.35*Student.getBaseTuition()));
        }
        else{
            return(super.getTuition() - ((LiberalArtsGrad.getFullLoad()*0.35*Student.getBaseTuition()) + ((getNumberOfRegisteredHours()-LiberalArtsGrad.getFullLoad())*0.1*Student.getBaseTuition())));
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
