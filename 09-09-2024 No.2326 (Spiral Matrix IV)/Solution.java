public class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Step 1: Initialize the matrix with -1
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        // Step 2: Spiral traversal variables
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        ListNode curr = head;

        // Step 3: Traverse the matrix in spiral order and fill it with linked list values
        while (curr != null && top <= bottom && left <= right) {
            // Move from left to right along the top row
            for (int i = left; i <= right && curr != null; i++) {
                matrix[top][i] = curr.val;
                curr = curr.next;
            }
            top++;  // Move the top boundary down

            // Move from top to bottom along the right column
            for (int i = top; i <= bottom && curr != null; i++) {
                matrix[i][right] = curr.val;
                curr = curr.next;
            }
            right--;  // Move the right boundary left

            // Move from right to left along the bottom row
            for (int i = right; i >= left && curr != null; i--) {
                matrix[bottom][i] = curr.val;
                curr = curr.next;
            }
            bottom--;  // Move the bottom boundary up

            // Move from bottom to top along the left column
            for (int i = bottom; i >= top && curr != null; i--) {
                matrix[i][left] = curr.val;
                curr = curr.next;
            }
            left++;  // Move the left boundary right
        }

        // Step 4: Return the filled matrix
        return matrix;
    }
}
