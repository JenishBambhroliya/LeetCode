import java.util.Collections;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        // List to store the minutes representation of each time
        List<Integer> minutesList = new ArrayList<>();
        
        // Convert time points to minutes
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            // Convert to total minutes
            int totalMinutes = hours * 60 + minutes;
            minutesList.add(totalMinutes);
        }
        
        // Sort the list of minutes
        Collections.sort(minutesList);
        
        // Initialize the minimum difference with the max possible value
        int minDifference = Integer.MAX_VALUE;
        
        // Find the minimum difference between consecutive time points
        for (int i = 1; i < minutesList.size(); i++) {
            minDifference = Math.min(minDifference, minutesList.get(i) - minutesList.get(i - 1));
        }
        
        // Special case: check the difference between the last and the first time (circular case)
        int circularDifference = (1440 - minutesList.get(minutesList.size() - 1)) + minutesList.get(0);
        minDifference = Math.min(minDifference, circularDifference);
        
        return minDifference;
    }
}
