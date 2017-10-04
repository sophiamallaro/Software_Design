import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Sophia Mallaro
 * @see PostFixEvaluator
 */
public class PostFixEvaluator {

    public static int evaluate(StringBuffer expression) {

        Stack<Integer> stack = new Stack();
        //Calculate
        for (int i = 0; i < expression.length(); i++) {
            char temp = expression.charAt(i);
            if (temp != ' ') {
                if (Character.isDigit(temp)) {
                    String integer = Character.toString(temp);

                    while(Character.isDigit(expression.charAt(i+1))) {
                        integer += Character.toString(expression.charAt(i+1));
                        i++;
                    }
                    stack.push(Integer.parseInt(integer));
                } else {
                    try {
                        stack.push(calculate(stack.pop(), temp, stack.pop()));
                    } catch(EmptyStackException ex) {
                        System.out.println("Invalid Expression Entered.");
                        System.exit(0);
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            System.out.println("Invalid Expression Entered.");
            System.exit(0);
        }
        return stack.pop().intValue();
    }

    /**
     * This method evaluates a basic arithmatic expression given to values and an operand
     * @param val1 second value to be evaluted
     * @param temp operand
     * @param val2 first value to be evaluated
     * @return evaluation
     */


        public static int calculate(int val1, char temp, int val2) {
            if(temp == '+') {return  val2 + val1; }
            else if(temp == '-') {return val2 - val1;}
            else if(temp == '*') {return val2 * val1;}
            else if(temp == '%') {return val2 % val1; }
            else if(temp == '/') {return val2 / val1; }
            else if(temp == '^') {return (int)Math.pow(val2, val1);}
            return 0;
        }
    }


