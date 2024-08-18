class Solution {
    public int nthUglyNumber(int n) {
        // Initialize dp array to store the ugly numbers
        int[] dp = new int[n];
        dp[0] = 1; // The first ugly number is 1
        
        // Indices for multiples of 2, 3, and 5
        int i2 = 0, i3 = 0, i5 = 0;
        
        // Initial next multiples of 2, 3, and 5
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        
        for (int i = 1; i < n; i++) {
            // The next ugly number is the minimum of these multiples
            int nextUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            dp[i] = nextUglyNumber;
            
            // Update the respective index and next multiple if needed
            if (nextUglyNumber == nextMultipleOf2) {
                i2++;
                nextMultipleOf2 = dp[i2] * 2;
            }
            if (nextUglyNumber == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = dp[i3] * 3;
            }
            if (nextUglyNumber == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = dp[i5] * 5;
            }
        }
        
        // The nth ugly number is now stored in dp[n-1]
        return dp[n - 1];
    }
}
