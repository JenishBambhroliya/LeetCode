class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        
        // Check if the current tree node can start a valid path
        if (doesPathExist(head, root)) {
            return true;
        }
        
        // Otherwise, continue checking in the left and right subtrees
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    // Recursive function to check if the linked list matches the path in the tree
    private boolean doesPathExist(ListNode head, TreeNode root) {
        // If we reached the end of the linked list, we've matched the path
        if (head == null) {
            return true;
        }
        
        // If the tree node is null, we cannot match further
        if (root == null) {
            return false;
        }
        
        // Check if the current node in the linked list matches the current tree node
        if (head.val != root.val) {
            return false;
        }
        
        // Continue checking the left and right subtrees with the next node in the linked list
        return doesPathExist(head.next, root.left) || doesPathExist(head.next, root.right);
    }
}
