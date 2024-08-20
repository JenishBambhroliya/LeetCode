import java.util.Arrays;

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Compute suffix sums
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return helper(piles, 0, 1, dp, suffixSum);
    }

    private int helper(int[] piles, int i, int M, int[][] dp, int[] suffixSum) {
        if (i == piles.length) {
            return 0;
        }
        if (dp[i][M] != -1) {
            return dp[i][M];
        }
        
        int maxStones = 0;
        for (int X = 1; X <= 2 * M && i + X <= piles.length; X++) {
            maxStones = Math.max(maxStones, suffixSum[i] - helper(piles, i + X, Math.max(M, X), dp, suffixSum));
        }
        
        dp[i][M] = maxStones;
        return dp[i][M];
    }
}
