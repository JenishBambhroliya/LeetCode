import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Graph representation using adjacency list
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Pair(v, prob));
            graph.get(v).add(new Pair(u, prob));
        }

        // Priority queue to implement max-heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        pq.offer(new Pair(start, 1.0));

        // Maximum probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        // Dijkstra-like algorithm
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            double prob = current.probability;

            // Early exit if we reach the end node
            if (node == end) {
                return prob;
            }

            // Traverse the neighbors
            for (Pair neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                double edgeProb = neighbor.probability;

                // If we found a higher probability path to the nextNode
                if (maxProb[nextNode] < prob * edgeProb) {
                    maxProb[nextNode] = prob * edgeProb;
                    pq.offer(new Pair(nextNode, maxProb[nextNode]));
                }
            }
        }

        // If no path exists to the end node
        return 0.0;
    }
    
    // Pair class to represent (node, probability)
    class Pair {
        int node;
        double probability;
        
        Pair(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }
}
