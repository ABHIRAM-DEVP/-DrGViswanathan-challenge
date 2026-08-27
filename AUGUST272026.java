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

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class AUGUST272026{
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if(head == null)return null;
        ListNode prev = head;
        ListNode curr = head.next;

        
        
        while(curr !=null){
            if(curr.val == prev.val){
                prev.next = curr.next;
            }
            else{
                prev= curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}

//time complexity: O(n) 
//space complexity: O(1) 