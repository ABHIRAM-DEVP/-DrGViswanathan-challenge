// DAY 2 

// 2nd JUNE 2026

// #203. Remove Linked List 
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {

        //for empty linked list or clearing matching targets 
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode iter = head;

        while(iter !=null && iter.next != null){
            if(iter.next.val == val){
                iter.next = iter.next.next;
            }
            else{
                iter=iter.next;
            }
        }
        return head;
    }
}

//time complexity: O(n)
//space complexity: O(1)