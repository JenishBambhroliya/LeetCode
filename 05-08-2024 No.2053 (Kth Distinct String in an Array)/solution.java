import java.util.*;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        // HashMap to count the frequency of each string
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        // First pass: Count the frequency of each string
        for (String s : arr) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }
        
        // Second pass: Find the k-th distinct string
        int count = 0;
        for (String s : arr) {
            if (frequencyMap.get(s) == 1) {
                count++;
                if (count == k) {
                    return s;
                }
            }
        }
        
        // If there are fewer than k distinct strings
        return "";
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test cases
        String[] arr1 = {"d", "b", "c", "b", "c", "a"};
        int k1 = 2;
        System.out.println(sol.kthDistinct(arr1, k1)); // Output: "a"
        
        String[] arr2 = {"aaa", "aa", "a"};
        int k2 = 1;
        System.out.println(sol.kthDistinct(arr2, k2)); // Output: "aaa"
        
        String[] arr3 = {"a", "b", "a"};
        int k3 = 3;
        System.out.println(sol.kthDistinct(arr3, k3)); // Output: ""
    }
}
