/**
 * Converter.java -  This class does the logic for the arabic to roman conversion.
 * @author Sophia Mallaro
 * @see Converter
 */
public class Converter {
    private final int arabic;
    private String roman;

    /**
     * This is a constructor for the converter class. It takes
     * in an integer to be converted.
     * @param arabic An arabic integer
     */
    public Converter(int arabic) { this.arabic = arabic; }

    /**
     * This method allows the user to obtain the roman numberal form of the integer
     * with which the object was constructed. If the integer is out of range for this
     * assignment, the method returns "Invalid input".
     * @return Returns the roman numberal form of the arabic integer
     */
    public String getRoman() { //Roman Numeral Calculation
        if(arabic > 3999 || arabic < 0) {
            return "Invalid Input";
        }
        else {
            String thousands= ""; //get thousands place
            int calc = arabic;
            int remainder = (arabic % 1000);
            calc = calc - remainder;
            switch(calc) {
                case 0:
                    thousands = "";
                    break;
                case 1000:
                    thousands = "M";
                    break;
                case 2000:
                    thousands = "MM";
                    break;
                case 3000:
                    thousands = "MMM";
                    break;
                default:
                    break;
            }
            String hundreds = ""; //Get hundreds place
            calc = remainder;
            remainder = calc % 100;
            calc = calc - remainder;
            if(calc < 500) {
                int num = calc / 100;
                while(num> 0) {
                    hundreds = hundreds + "C";
                    num--;
                }
                if(hundreds.equals("CCCC")) {
                    hundreds = "CD";
                }
            }
            else {
                hundreds = "D";
                calc = calc - 500;
                int num = calc / 100;
                while(num>0) {
                    hundreds = hundreds + "C";
                    num--;
                }
                if(hundreds.equals("DCCCC")){
                    hundreds = "CM";
                }
            }

            String tens = ""; //Get hundreds place
            calc = remainder;
            remainder = calc % 10;
            calc = calc - remainder;
            if(calc < 50) {
                int num = calc / 10;
                while(num> 0) {
                    tens = tens + "X";
                    num--;
                }
                if(tens.equals("XXXX")) {
                    tens = "XL";
                }
            }
            else {
                tens = "L";
                calc = calc - 50;
                int num = calc / 10;
                while(num>0) {
                    tens = tens + "X";
                    num--;
                }
                if(tens.equals("LXXXX")){
                    tens = "XC";
                }
            }
            String ones = "";
            calc = remainder;
            if(calc < 5) {
                while(calc> 0) {
                    ones = ones + "I";
                    calc--;
                }
                if(ones.equals("IIII")) {
                    ones = "IV";
                }
            }
            else {
                ones = "V";
                calc = calc - 5;
                while(calc>0) {
                    ones = ones + "I";
                    calc--;
                }
                if(ones.equals("VIIII")){
                    ones = "IX";
                }
            }
            return (thousands+hundreds+tens+ones);
        }
    }
}
