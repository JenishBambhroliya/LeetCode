public class Solution {
    // Function to find GCD of two numbers
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        
        // Traverse the list and insert GCD nodes
        while (current != null && current.next != null) {
            int gcdValue = gcd(current.val, current.next.val);
            // Create a new node with GCD value
            ListNode gcdNode = new ListNode(gcdValue);
            
            // Insert this GCD node between current and current.next
            gcdNode.next = current.next;
            current.next = gcdNode;
            
            // Move to the next pair (skip the newly inserted GCD node)
            current = gcdNode.next;
        }
        
        return head;
    }
    
    // Utility function to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Driver method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Create a linked list: 18 -> 6 -> 10 -> 3
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);
        
        // Print the original list
        System.out.println("Original list:");
        solution.printList(head);
        
        // Modify the list by inserting GCD nodes
        head = solution.insertGreatestCommonDivisors(head);
        
        // Print the modified list
        System.out.println("Modified list after inserting GCD nodes:");
        solution.printList(head);
    }
}
