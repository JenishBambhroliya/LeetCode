import java.util.*;


//--------------------------------------------------------------------------------(LeetCode solution start)-----------------------------------------------------------------------------------------

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert the array to a list to use the custom comparator
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // Step 3: Sort the list with a custom comparator
        list.sort((a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) {
                return freqA - freqB; // Sort by frequency in increasing order
            } else {
                return b - a; // Sort by value in decreasing order if frequencies are the same
            }
        });

        // Step 4: Convert the sorted list back to an array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] result1 = sol.frequencySort(nums1);
        System.out.println(Arrays.toString(result1)); // Output: [3, 1, 1, 2, 2, 2]

        int[] nums2 = {2, 3, 1, 3, 2};
        int[] result2 = sol.frequencySort(nums2);
        System.out.println(Arrays.toString(result2)); // Output: [1, 3, 3, 2, 2]

        int[] nums3 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        int[] result3 = sol.frequencySort(nums3);
        System.out.println(Arrays.toString(result3)); // Output: [5, -1, 4, 4, -6, -6, 1, 1, 1]
    }
}
//--------------------------------------------------------------------------------(LeetCode solution end)-----------------------------------------------------------------------------------------
