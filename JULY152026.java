import java.util.Stack;
public class JULY152026 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        for (int i=0; i<=n; i++){
            int currentHeight = (i==n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}


//time complexity: O(n) - Each bar is pushed and popped from the stack at most once.
//space complexity: O(n) - The stack can hold all the bars in the worst case.