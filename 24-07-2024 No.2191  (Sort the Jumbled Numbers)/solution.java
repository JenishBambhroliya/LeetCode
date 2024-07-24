import java.util.Arrays;



//--------------------------------------------------------------------------(LeetCode Solution Start)----------------------------------------------------------------------------------------------



class Solution {
    // Helper function to get the mapped value of a number
    private int getMappedValue(int num, int[] mapping) {
        StringBuilder mappedValue = new StringBuilder();
        String numStr = String.valueOf(num);
        for (char digit : numStr.toCharArray()) {
            mappedValue.append(mapping[digit - '0']);
        }
        return Integer.parseInt(mappedValue.toString());
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Create an array of pairs (original number, mapped value)
        int n = nums.length;
        int[][] pairedArray = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairedArray[i][0] = nums[i];
            pairedArray[i][1] = getMappedValue(nums[i], mapping);
        }

        // Sort the array based on the mapped values, and maintain relative order using stable sort
        Arrays.sort(pairedArray, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return 0; // Maintain original relative order if mapped values are the same
            }
        });

        // Extract the sorted numbers based on the original values
        for (int i = 0; i < n; i++) {
            nums[i] = pairedArray[i][0];
        }

        return nums;
    }
}


//--------------------------------------------------------------------------(LeetCode Solution End)----------------------------------------------------------------------------------------------



// Example usage:
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums = {990, 332, 981};
        int[] sortedNums = solution.sortJumbled(mapping, nums);
        System.out.println(Arrays.toString(sortedNums));  // Output: [332, 990, 981]
    }
}
