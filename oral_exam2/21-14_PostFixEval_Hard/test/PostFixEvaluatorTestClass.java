/**
 * EasterTest.java - This class uses JUnit 4 to test the dates of 20 easters
 * to check the validity of the class
 * @author Sophia Mallaro
 * @see EasterTest
 */

import org.junit.Test;
//import org.testng.annotations.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PostFixEvaluatorTestClass {
    private StringBuffer expression = new StringBuffer();
    private int answer;

    @Test
    public void testEvaluate() throws Exception{
        expression.append("10 3 +"); //Test Addition
        answer = 13;
        assertEquals(answer, PostFixEvaluator.evaluate(expression));
        expression.append("10 3 -"); //Test Subtraction
        answer = 7;
        assertEquals(answer, PostFixEvaluator.evaluate(expression));
        expression.append("10 2 %"); //Test Remainder
        answer = 0;
        assertEquals(answer, PostFixEvaluator.evaluate(expression));
        expression.append("10 2 /"); //Test Division
        answer = 5;
        assertEquals(answer, PostFixEvaluator.evaluate(expression));
        expression.append("200 300 *"); //Test Multiplication
        answer = 200 * 300;
        assertEquals(answer, PostFixEvaluator.evaluate(expression));
        expression.append("2 3 ^"); //Test Power
        answer = 8;
        assertEquals(answer, PostFixEvaluator.evaluate(expression));
        expression.append("2 3 + 2 *"); //Testing a more complex expression
        answer = 10;
        assertEquals(answer, PostFixEvaluator.evaluate(expression));
    }
}
