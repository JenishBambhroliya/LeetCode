class Solution {
    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = find(parent, parent[i]); // Path compression
        return parent[i];
    }
    
    private void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
    
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4 * n * n;
        int[] parent = new int[size];
        
        // Initialize the Union-Find structure
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int base = 4 * (r * n + c);
                char ch = grid[r].charAt(c);
                
                // Connect internal triangles in the current cell
                if (ch == '/') {
                    union(parent, base + 0, base + 3);
                    union(parent, base + 1, base + 2);
                } else if (ch == '\\') {
                    union(parent, base + 0, base + 1);
                    union(parent, base + 2, base + 3);
                } else {
                    union(parent, base + 0, base + 1);
                    union(parent, base + 1, base + 2);
                    union(parent, base + 2, base + 3);
                }
                
                // Connect with the right neighbor
                if (c + 1 < n) {
                    union(parent, base + 1, base + 4 + 3);
                }
                
                // Connect with the bottom neighbor
                if (r + 1 < n) {
                    union(parent, base + 2, base + 4 * n + 0);
                }
            }
        }
        
        // Count the number of regions (connected components)
        int regions = 0;
        for (int i = 0; i < size; i++) {
            if (find(parent, i) == i) {
                regions++;
            }
        }
        
        return regions;
    }
}
