import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countPairsWithDistanceLessThanOrEqualTo(nums, mid);
            
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private int countPairsWithDistanceLessThanOrEqualTo(int[] nums, int dist) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && nums[j] - nums[i] <= dist) {
                j++;
            }
            count += (j - i - 1);
        }
        
        return count;
    }
}
