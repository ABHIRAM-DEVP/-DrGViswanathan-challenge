import java.util.Stack;

public class JUNE072026 {
    private  class Node{
        int value;
        Node next;
        int min;

        Node(int value, int min, Node next){
            this.value=value;
            this.min=min;
            this.next=next;
        }
    }
    // 'head' always represents the top of the stack
    private Node head;

    public MinStack() {
        this.head=null;
    }
    
    public void push(int value) {
        if(head == null){
            head = new Node(value, value, null);
        }
        else{
            int currentMin = Math.min(value, head.min);
            head = new Node(value, currentMin, head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.value;
    }
    
    public int getMin() {
        return head.min;
    }
}
