class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        
        // Step 1: Calculate the total sum of all n + m rolls
        int totalSum = mean * (n + m);
        
        // Step 2: Calculate the sum of the known rolls
        int currentSum = 0;
        for (int roll : rolls) {
            currentSum += roll;
        }
        
        // Step 3: Calculate the missing sum
        int missingSum = totalSum - currentSum;
        
        // Step 4: Check if the missing sum is feasible
        if (missingSum < n || missingSum > 6 * n) {
            return new int[] {};  // No valid solution
        }
        
        // Step 5: Distribute the missing sum across n rolls
        int[] result = new int[n];
        int quotient = missingSum / n;
        int remainder = missingSum % n;
        
        // Distribute the base value (quotient) to each roll
        for (int i = 0; i < n; i++) {
            result[i] = quotient;
        }
        
        // Distribute the remainder (add 1 to the first 'remainder' elements)
        for (int i = 0; i < remainder; i++) {
            result[i]++;
        }
        
        return result;
    }
}
