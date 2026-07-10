import java.util.PriorityQueue;

class JULY102026{
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Initialize Min-Heap based on the node's value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Put the head of each list into the min-heap
        for (ListNode root : lists) {
            if (root != null) {
                minHeap.add(root);
            }
        }

        // Dummy node helps seamlessly build the resulting list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Process the heap
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            tail.next = smallest;
            tail = tail.next;

            // If there is a next node in the current list, push it to the heap
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummy.next;
    }
}

//time complexity: O(N log k)
//space complexity: O(k)