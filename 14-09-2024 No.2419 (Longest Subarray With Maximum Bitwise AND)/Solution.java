class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        int maxLen = 0;
        int currentLen = 0;
        
        // Step 1: Find the maximum value in the array
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        // Step 2: Find the longest subarray with all elements equal to maxVal
        for (int num : nums) {
            if (num == maxVal) {
                currentLen++;  // increase length for contiguous maxVal
                maxLen = Math.max(maxLen, currentLen);
            } else {
                currentLen = 0;  // reset the current length when we encounter a different number
            }
        }
        
        return maxLen;
    }
}
