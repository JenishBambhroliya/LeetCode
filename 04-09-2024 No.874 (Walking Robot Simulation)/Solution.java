import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions array: North, East, South, West
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0; // Robot's initial position
        int dir = 0; // Starting direction is north
        int maxDistance = 0;

        // Store obstacles as a set of strings for quick lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        for (int command : commands) {
            if (command == -2) {
                // Turn left: counter-clockwise direction change
                dir = (dir + 3) % 4;
            } else if (command == -1) {
                // Turn right: clockwise direction change
                dir = (dir + 1) % 4;
            } else {
                // Move forward `command` steps in the current direction
                for (int i = 0; i < command; i++) {
                    int newX = x + directions[dir][0];
                    int newY = y + directions[dir][1];
                    
                    // Check for obstacle
                    if (!obstacleSet.contains(newX + "," + newY)) {
                        x = newX;
                        y = newY;
                        maxDistance = Math.max(maxDistance, x * x + y * y);
                    } else {
                        // If there's an obstacle, stop the current move
                        break;
                    }
                }
            }
        }

        return maxDistance;
    }
}
