class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1: Calculate the length of the linked list
        int n = 0;
        ListNode current = head;
        while (current != null) {
            n++;
            current = current.next;
        }
        
        // Step 2: Determine the base size of each part and the number of larger parts
        int partSize = n / k;        // Base size of each part
        int largerParts = n % k;     // First 'largerParts' parts will have an extra node
        
        // Step 3: Create the result array to store the parts
        ListNode[] result = new ListNode[k];
        current = head;
        
        for (int i = 0; i < k; i++) {
            if (current == null) {
                result[i] = null;  // If no more nodes, make remaining parts null
                continue;
            }
            
            // Start the new part
            result[i] = current;
            int currentPartSize = partSize + (i < largerParts ? 1 : 0); // Larger parts get 1 extra node
            
            // Traverse the current part to disconnect it from the rest of the list
            for (int j = 1; j < currentPartSize; j++) {
                current = current.next;
            }
            
            // Disconnect the current part from the rest of the list
            ListNode nextPart = current.next;
            current.next = null;
            current = nextPart;
        }
        
        return result;
    }
}
