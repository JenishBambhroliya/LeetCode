import java.util.*;

class Solution {
    public String fractionAddition(String expression) {
        // Initialize the numerator and denominator for the result.
        int numerator = 0;
        int denominator = 1;

        // Use a scanner to find the numerator and denominator in the expression.
        int i = 0;
        while (i < expression.length()) {
            // Read the sign.
            int sign = 1;
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }
            
            // Read the numerator.
            int numStart = i;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                i++;
            }
            int currNumerator = Integer.parseInt(expression.substring(numStart, i));
            
            // Skip the '/' character.
            i++;
            
            // Read the denominator.
            int denStart = i;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                i++;
            }
            int currDenominator = Integer.parseInt(expression.substring(denStart, i));
            
            // Add or subtract the fraction from the result.
            numerator = numerator * currDenominator + sign * currNumerator * denominator;
            denominator *= currDenominator;
            
            // Simplify the result so far.
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return numerator + "/" + denominator;
    }
    
    // Helper method to compute the greatest common divisor (GCD).
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
