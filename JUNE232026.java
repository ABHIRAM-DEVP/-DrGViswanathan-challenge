import java.util.Stack;
public class JUNE232026 {    //rename class as MyQueue

    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        peek(); // Ensures output stack has the current front element  ---following peek function is called first 
        return output.pop();                                              
    }                           
    
    public int peek() {                                 
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());    //gets pushed in reversed order hence straight
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

//time complexity: O(1) for push, O(n) for pop and peek in worst case, but amortized O(1) for pop and peek
//space complexity: O(n) where n is the number of elements in the queues

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */