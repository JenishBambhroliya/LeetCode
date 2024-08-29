import java.util.HashMap;
import java.util.Map;

class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();

        // Union stones by rows and columns
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + 10001; // Use a large number offset for columns
            uf.union(row, col);
        }

        // Count the number of connected components
        return stones.length - uf.getNumberOfConnectedComponents();
    }

    class UnionFind {
        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            parent = new HashMap<>();
            count = 0;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent.put(rootX, rootY);
                count--;
            }
        }

        public int getNumberOfConnectedComponents() {
            return count;
        }
    }
}
