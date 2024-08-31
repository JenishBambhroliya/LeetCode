import java.util.*;

class Solution {
    class Node {
        int vertex;
        double prob;
        Node(int v, double p) {
            this.vertex = v;
            this.prob = p;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Create graph
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        // Populate graph with edges
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Node(v, prob));
            graph.get(v).add(new Node(u, prob));
        }
        
        // Max-Heap priority queue (for maximizing probability)
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Node(start, 1.0));
        
        // Array to store the maximum probability to each node
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        
        // Dijkstra-like process to maximize probability
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            double curProb = current.prob;
            
            if (u == end) {
                return curProb;
            }
            
            // Relaxation of edges
            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                double edgeProb = neighbor.prob;
                double newProb = curProb * edgeProb;
                
                if (newProb > maxProb[v]) {
                    maxProb[v] = newProb;
                    pq.offer(new Node(v, newProb));
                }
            }
        }
        
        return 0.0;  // If no path is found, return 0.0
    }
}
