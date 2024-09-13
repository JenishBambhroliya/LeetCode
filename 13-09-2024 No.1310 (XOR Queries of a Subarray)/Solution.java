public class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        
        // Step 1: Build the prefix XOR array
        int[] prefixXOR = new int[n];
        prefixXOR[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
        }
        
        // Step 2: Process each query
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            // XOR from arr[left] to arr[right]
            if (left == 0) {
                result[i] = prefixXOR[right]; // When left is 0, it's just the prefixXOR[right]
            } else {
                result[i] = prefixXOR[right] ^ prefixXOR[left - 1];
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] arr1 = {1, 3, 4, 8};
        int[][] queries1 = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        int[] result1 = solution.xorQueries(arr1, queries1);
        // Expected output: [2, 7, 14, 8]
        System.out.println(Arrays.toString(result1));

        int[] arr2 = {4, 8, 2, 10};
        int[][] queries2 = {{2, 3}, {1, 3}, {0, 0}, {0, 3}};
        int[] result2 = solution.xorQueries(arr2, queries2);
        // Expected output: [8, 0, 4, 4]
        System.out.println(Arrays.toString(result2));
    }
}
