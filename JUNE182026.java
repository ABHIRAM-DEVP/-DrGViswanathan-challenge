class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class JUNE182026 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //since we have to return the head of sortedLL 
        ListNode solution = new ListNode();
        ListNode merged = solution;

        while(list1 != null && list2 != null){
            if(list1.val <=list2.val){
                solution.next = list1;
                list1 = list1.next;
            }
            else{
                //list2.val < list1.val
                solution.next = list2;
                list2 = list2.next;
            }
            //since solution.next = list1/2  (that is connection set from upcoming end) but now let's move to the end for further connections into the end
            solution = solution.next; //moving to the end of merged list

        }
        //just attach the remaining part of the non-empty list
        if (list1 != null) {
            solution.next = list1;
        } else {
            solution.next = list2;
        }
        return merged.next; //original pointer to first node of merged list
    }
}

//time complexity: O(n+m) where n and m are the lengths of the two lists
//space complexity: O(1) since we are not using any extra space for merging, we are just rearranging the existing nodes.