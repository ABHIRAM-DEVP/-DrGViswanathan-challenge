class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class JUNE142026 {
    public boolean hasCycle(ListNode head) {
        // to detect cycle in linked list
        // using two pointer approach 
        // slow and fast pointers
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        //if slow and fast meet at a point this is a cycle  because in circular motion they will meet at an instant

        while(fast!=null && fast.next!=null ){
            slow = slow.next;
            fast  = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
