class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;  // Single character case
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + 1;  // Start with maximum number of turns
                for (int k = i; k < j; k++) {
                    int total = dp[i][k] + dp[k + 1][j];
                    if (s.charAt(k) == s.charAt(j)) {
                        total--;  // Merge turn if same character
                    }
                    dp[i][j] = Math.min(dp[i][j], total);
                }
            }
        }

        return dp[0][n - 1];
    }
}
