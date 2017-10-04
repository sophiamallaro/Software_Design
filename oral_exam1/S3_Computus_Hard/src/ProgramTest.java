/**
 * ProgramTest.java - This is the driver class for my easter program.
 * It asks the user to input a year and returns the date of easter on that year.
 * It then calculates the number of times easter falls on each possible date
 * over the total cycle of 5,700,000 years
 * @author Sophia Mallaro
 * @see ProgramTest
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramTest {
    public static void main(String[] args) {
        //Part 1: Recieve year from user and print Easter date
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.print("Enter a year: ");
        try {
            year = scanner.nextInt();
            try {
                Easter easter = new Easter(year);
                System.out.println(easter.getMonth() + " " + easter.getDay() + ", " + year);
            }
            catch(IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        catch(InputMismatchException ex) {
            System.out.println("Invalid input.");
        }

        //Part 2: Print the number of times easter falls on each day over one 5,700,000 year cycle
        try {
            Cycle cycle = new Cycle(5700000, 0);
            cycle.Display();
        } catch(IllegalArgumentException ex) {
            System.out.println(ex.getCause());
        }
    }
}
