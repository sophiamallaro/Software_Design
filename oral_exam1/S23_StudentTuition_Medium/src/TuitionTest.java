/**
 * This is the driver class for the student tuition problem. It creates one of the 18 types
 * of students, prints their information, changes the base Tuition, and reprints their information. 
 * @author Sophia Mallaro
 * @see TuitionTest
 */
public class TuitionTest {
    public static void main(String[] args) {
        Student.setBaseTuition(350); //Set initial base tuition
        //Iowa Residents
        IowaLiberalArtsGrad student1 = new IowaLiberalArtsGrad("Mary", "Brown", "00000001", 12, "Cedar Falls, IA");
        IowaEngineeringGrad student2 = new IowaEngineeringGrad("Shelby", "Black", "00000002", 10,  "Cedar Rapids, IA");
        IowaLiberalArtsUndergrad student3 = new IowaLiberalArtsUndergrad("Mark", "Johnson", "00000003", 6, "Urbandale, IA");
        IowaEngineeringUndergrad student4 = new IowaEngineeringUndergrad("Michael", "Thompson", "00000004", 18,  "Central City, IA");
        IowaLiberalArtsOpen student5 = new IowaLiberalArtsOpen("Matthew", "Kremer", "00000005", 4, "Des Moines, IA");
        IowaEngineeringOpen student6 = new IowaEngineeringOpen("Melissa", "Brummel", "00000006", 2, "Dubuque, IA");
        //Domestic Students
        OtherLiberalArtsGrad student7 = new OtherLiberalArtsGrad("Elizabeth", "Behrens", "00000007", 10, "Naperville, IL");
        OtherEngineeringGrad student8 = new OtherEngineeringGrad("Adam", "Deasy", "00000008", 12, "Boston, MA");
        OtherLiberalArtsUndergrad student9 = new OtherLiberalArtsUndergrad("Christina", "Carver", "00000009", 18, "New York, NY");
        OtherEngineeringUndergrad student10 = new OtherEngineeringUndergrad("Hayden", "Fry", "00000010", 22, "Eastland, TX");
        OtherLiberalArtsOpen student11 = new OtherLiberalArtsOpen("Kendall", "Mallaro", "00000011", 6, "Omaha, NE");
        OtherEngineeringOpen student12 = new OtherEngineeringOpen("Ava", "Mallaro", "00000012", 4, "Omaha, NE");
        //International
        InternationalLiberalArtsGrad student13 = new InternationalLiberalArtsGrad("Rikke", "Areldson", "00000013", 8, "Copenhagen, Denmark");
        InternationalEngineeringGrad student14 =new InternationalEngineeringGrad("Dina", "Kardovic", "00000014", 12, "Rozaje, Montenegro");
        InternationalLiberalArtsUndergrad student15 = new InternationalLiberalArtsUndergrad("Nedim", "Kardovic", "00000015", 18, "Budva, Montenegro");
        InternationalEngineeringUndergrad student16 = new InternationalEngineeringUndergrad("Faith", "Aruan", "00000016", 16, "Lagos, Nigeria");
        InternationalLiberalArtsOpen student17 = new InternationalLiberalArtsOpen("Joe", "Schmo", "00000017", 4, "Ontario, Canada");
        InternationalEngineeringOpen student18 = new InternationalEngineeringOpen("Sammy", "Abibiman", "00000018", 19, "Tema, Ghana");
        //Print the 18 students
        student1.print();
        student2.print();
        student3.print();
        student4.print();
        student5.print();
        student6.print();
        student7.print();
        student8.print();
        student9.print();
        student10.print();
        student11.print();
        student12.print();
        student13.print();
        student14.print();
        student15.print();
        student16.print();
        student17.print();
        student18.print();
        //Change the Base Tuition Rate and Reprint
        Student.setBaseTuition(250);
        student1.print();
        student2.print();
        student3.print();
        student4.print();
        student5.print();
        student6.print();
        student7.print();
        student8.print();
        student9.print();
        student10.print();
        student11.print();
        student12.print();
        student13.print();
        student14.print();
        student15.print();
        student16.print();
        student17.print();
        student18.print();
    }
}
