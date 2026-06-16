public class JUNE162026 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //use a temp.next

        //because for one pass : we use slow and fast pointer 
        //which involves use of head
        //and in .next pointing head's position will be altered

        //dummy.next returns the memory address (reference) of the very first node of your final, modified linked list.


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;

        //creating a gap of n steps 
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}

//time complexity: O(n)
//space complexity: O(1)