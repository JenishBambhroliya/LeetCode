import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;
        
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int currentMin = array.get(0);
            int currentMax = array.get(array.size() - 1);
            
            // Calculate distance using the current array's min and the previous max
            maxDistance = Math.max(maxDistance, Math.abs(currentMax - minVal));
            // Calculate distance using the current array's max and the previous min
            maxDistance = Math.max(maxDistance, Math.abs(maxVal - currentMin));
            
            // Update global min and max
            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }
        
        return maxDistance;
    }
}
