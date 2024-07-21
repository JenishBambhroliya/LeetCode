#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <queue>

using namespace std;

//--------------------------------------------------------------------------(LeetCode Solution Start)----------------------------------------------------------------------------------------------

class Solution {
public:
    vector<vector<int>> buildMatrix(int k, vector<vector<int>>& rowConditions, vector<vector<int>>& colConditions) {
        vector<vector<int>> result(k, vector<int>(k, 0));
        
        vector<int> rowOrder = topologicalSort(k, rowConditions);
        vector<int> colOrder = topologicalSort(k, colConditions);
        
        if (rowOrder.empty() || colOrder.empty()) {
            return {};  // Return empty matrix if any topological sort failed due to a cycle.
        }
        
        unordered_map<int, int> rowIndex, colIndex;
        
        for (int i = 0; i < k; ++i) {
            rowIndex[rowOrder[i]] = i;
            colIndex[colOrder[i]] = i;
        }
        
        for (int i = 1; i <= k; ++i) {
            result[rowIndex[i]][colIndex[i]] = i;
        }
        
        return result;
    }

private:
    vector<int> topologicalSort(int k, vector<vector<int>>& conditions) {
        vector<int> indegree(k + 1, 0);
        unordered_map<int, unordered_set<int>> graph;
        
        for (const auto& cond : conditions) {
            if (graph[cond[0]].insert(cond[1]).second) {
                ++indegree[cond[1]];
            }
        }
        
        queue<int> q;
        for (int i = 1; i <= k; ++i) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        
        vector<int> order;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            order.push_back(node);
            
            for (int neighbor : graph[node]) {
                if (--indegree[neighbor] == 0) {
                    q.push(neighbor);
                }
            }
        }
        
        return order.size() == k ? order : vector<int>();
    }
};

//--------------------------------------------------------------------------(LeetCode Solution End)---------------------------------------------------------------------------------------------

// Driver code for testing
int main() {
    Solution sol;
    int k = 3;
    vector<vector<int>> rowConditions = {{1, 2}, {3, 2}};
    vector<vector<int>> colConditions = {{2, 1}, {3, 2}};

    vector<vector<int>> result = sol.buildMatrix(k, rowConditions, colConditions);

    if (!result.empty()) {
        for (const auto& row : result) {
            for (int val : row) {
                cout << val << " ";
            }
            cout << endl;
        }
    } else {
        cout << "No valid matrix can be formed due to cycles in the conditions." << endl;
    }

    return 0;
}
