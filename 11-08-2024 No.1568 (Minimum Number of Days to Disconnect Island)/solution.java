class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;

    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Check the initial number of islands
        if (countIslands(grid) != 1) {
            return 0;  // Already disconnected
        }

        // Check if removing one land cell disconnects the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands(grid) != 1) {
                        return 1;  // Disconnected in one day
                    }
                    grid[i][j] = 1;  // Restore the grid
                }
            }
        }

        // If not disconnectable in one day, return 2
        return 2;
    }

    private int countIslands(int[][] g) {
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1 && !visited[i][j]) {
                    dfs(g, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] g, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || g[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for (int[] dir : directions) {
            dfs(g, i + dir[0], j + dir[1], visited);
        }
    }
}
