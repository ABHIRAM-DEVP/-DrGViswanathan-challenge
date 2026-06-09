class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class JUNE092026 {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode nextNode = current.next; //Save the next node
            current.next = previous;          //Reverse the link address
            previous = current;               //Move previous ptr forward
            current = nextNode;               //Move current ptr forward
        } 
        return previous;
    }
}


//time complexity: O(n)
//space complexity: O(1)


