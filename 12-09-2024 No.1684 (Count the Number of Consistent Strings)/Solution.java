class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Step 1: Convert allowed string into a set of characters
        Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }
        
        // Step 2: Initialize count for consistent strings
        int consistentCount = 0;
        
        // Step 3: Iterate through each word in the words array
        for (String word : words) {
            boolean isConsistent = true;
            
            // Check if all characters in the word are in the allowed set
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;  // No need to check further if one character is not allowed
                }
            }
            
            // If the word is consistent, increment the count
            if (isConsistent) {
                consistentCount++;
            }
        }
        
        // Return the total number of consistent strings
        return consistentCount;
    }
}
