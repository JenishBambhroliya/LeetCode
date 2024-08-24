import java.math.BigInteger;

class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        BigInteger original = new BigInteger(n);
        BigInteger[] candidates = new BigInteger[5];

        // Candidate 1: Mirror the first half.
        candidates[0] = getMirroredPalindrome(n);
        
        // Candidate 2: Mirror by increasing the first half
        BigInteger incremented = new BigInteger(n.substring(0, (len + 1) / 2)).add(BigInteger.ONE);
        candidates[1] = getMirroredPalindrome(incremented.toString() + n.substring((len + 1) / 2));
        
        // Candidate 3: Mirror by decreasing the first half
        BigInteger decremented = new BigInteger(n.substring(0, (len + 1) / 2)).subtract(BigInteger.ONE);
        candidates[2] = getMirroredPalindrome(decremented.toString() + n.substring((len + 1) / 2));
        
        // Candidate 4: Consider "999...999" (one less digit)
        candidates[3] = BigInteger.TEN.pow(len - 1).subtract(BigInteger.ONE);
        
        // Candidate 5: Consider "100...001" (one more digit)
        candidates[4] = BigInteger.TEN.pow(len).add(BigInteger.ONE);

        BigInteger closest = null;
        for (BigInteger candidate : candidates) {
            if (candidate.equals(original)) continue; // Skip the original number itself
            if (closest == null || 
                original.subtract(candidate).abs().compareTo(original.subtract(closest).abs()) < 0 || 
                (original.subtract(candidate).abs().compareTo(original.subtract(closest).abs()) == 0 && candidate.compareTo(closest) < 0)) {
                closest = candidate;
            }
        }

        return closest.toString();
    }

    private BigInteger getMirroredPalindrome(String s) {
        int len = s.length();
        String firstHalf = s.substring(0, (len + 1) / 2);
        StringBuilder mirrored = new StringBuilder(firstHalf);
        if (len % 2 != 0) {
            mirrored.setLength(mirrored.length() - 1); // Remove last character if odd length
        }
        mirrored.reverse();
        return new BigInteger(firstHalf + mirrored.toString());
    }
}
