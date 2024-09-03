class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        
        // Step 1: Convert the string to its numerical equivalent
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }
        
        // Convert the StringBuilder to an integer (or sum of digits directly)
        int sum = 0;
        for (char c : sb.toString().toCharArray()) {
            sum += c - '0';
        }
        
        // Step 2: Perform the transformation k times
        for (int i = 1; i < k; i++) {
            int tempSum = 0;
            while (sum > 0) {
                tempSum += sum % 10;
                sum /= 10;
            }
            sum = tempSum;
        }
        
        return sum;
    }
}
