/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class JULY012026{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addListsWithCarry(l1, l2, 0);
    }

    private ListNode addListsWithCarry(ListNode l1, ListNode l2, int carry) {
        // Base case: If both lists are empty and there is no carry, we are done
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sum = carry;
        
        // Add l1's value and move to next if it exists
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        
        // Add l2's value and move to next if it exists
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }

        // Create the current node with the single digit
        ListNode resultNode = new ListNode(sum % 10);

        // Recursively calculate the next node, passing the new carry
        resultNode.next = addListsWithCarry(l1, l2, sum / 10);

        return resultNode;
    }
}

//time complexity: O(max(m, n)) where m and n are the lengths of the two linked lists
//space complexity: O(max(m, n)) due to recursion stack