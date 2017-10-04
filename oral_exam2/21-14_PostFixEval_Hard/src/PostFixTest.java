import java.util.Scanner;

/**
 * @author Sophia Mallaro
 * @see PostFixTest
 */
public class PostFixTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        StringBuffer expression = new StringBuffer(scanner.nextLine());

        try {
            int result = PostFixEvaluator.evaluate(expression);
            System.out.println(result);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
