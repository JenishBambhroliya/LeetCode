class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // Calculate the total chalk needed for one full round.
        long totalChalk = 0;
        for (int i = 0; i < chalk.length; i++) {
            totalChalk += chalk[i];
        }
        
        // Reduce k to be within one round.
        k %= totalChalk;
        
        // Determine the student who will replace the chalk.
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        
        // The code should never reach here as the answer will always be found in the loop.
        return -1;
    }
}
