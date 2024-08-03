import java.util.HashMap;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        
        HashMap<Integer, Integer> targetCount = new HashMap<>();
        HashMap<Integer, Integer> arrCount = new HashMap<>();
        
        for (int num : target) {
            targetCount.put(num, targetCount.getOrDefault(num, 0) + 1);
        }
        
        for (int num : arr) {
            arrCount.put(num, arrCount.getOrDefault(num, 0) + 1);
        }
        
        return targetCount.equals(arrCount);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] target1 = {1, 2, 3, 4};
        int[] arr1 = {2, 4, 1, 3};
        System.out.println(sol.canBeEqual(target1, arr1)); // Output: true
        
        int[] target2 = {7};
        int[] arr2 = {7};
        System.out.println(sol.canBeEqual(target2, arr2)); // Output: true
        
        int[] target3 = {3, 7, 9};
        int[] arr3 = {3, 7, 11};
        System.out.println(sol.canBeEqual(target3, arr3)); // Output: false
    }
}
