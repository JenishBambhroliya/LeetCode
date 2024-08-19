class Solution {
    public int minSteps(int n) {
        int steps = 0;
        int factor = 2;
        
        // Factorize the number and add the factors to the steps
        while (n > 1) {
            while (n % factor == 0) {
                steps += factor;
                n /= factor;
            }
            factor++;
        }
        
        return steps;
    }
}
