
//========================================================================(Leetcode Solution start)================================================================================================= 

class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] countA = new int[n + 1]; // countA[i] will store the number of 'a's from index 0 to i-1
        int[] countB = new int[n + 1]; // countB[i] will store the number of 'b's from index 0 to i-1

        // Calculate the prefix counts for 'a' and 'b'
        for (int i = 0; i < n; i++) {
            countA[i + 1] = countA[i] + (s.charAt(i) == 'a' ? 1 : 0);
            countB[i + 1] = countB[i] + (s.charAt(i) == 'b' ? 1 : 0);
        }

        int minDeletions = Integer.MAX_VALUE;
        
        // Try to balance at each index
        for (int i = 0; i <= n; i++) {
            // Deletions needed to remove all 'b's before index i + deletions needed to remove all 'a's after index i
            int deletions = countB[i] + (countA[n] - countA[i]);
            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "aababbab";
        System.out.println(sol.minimumDeletions(s1)); // Output: 2

        String s2 = "bbaaaaabb";
        System.out.println(sol.minimumDeletions(s2)); // Output: 2
    }
}

//========================================================================(Leetcode Solution end)================================================================================================= 
