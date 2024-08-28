public class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int subIslandsCount = 0;
        
        // Iterate through each cell in grid2
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If we find a land cell in grid2, start a DFS
                if (grid2[i][j] == 1) {
                    // Check if this island in grid2 is a sub-island of an island in grid1
                    if (dfs(grid1, grid2, i, j)) {
                        subIslandsCount++;
                    }
                }
            }
        }
        
        return subIslandsCount;
    }
    
    // DFS function to explore the island and check if it's a sub-island
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        // Check boundaries and if the current cell is water in grid2
        if (i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length || grid2[i][j] == 0) {
            return true;
        }
        
        // If the corresponding cell in grid1 is water, it's not a sub-island
        boolean isSubIsland = grid1[i][j] == 1;
        
        // Mark the current cell in grid2 as visited
        grid2[i][j] = 0;
        
        // Explore all 4 possible directions
        isSubIsland &= dfs(grid1, grid2, i + 1, j);
        isSubIsland &= dfs(grid1, grid2, i - 1, j);
        isSubIsland &= dfs(grid1, grid2, i, j + 1);
        isSubIsland &= dfs(grid1, grid2, i, j - 1);
        
        return isSubIsland;
    }
}
