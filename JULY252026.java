/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.Deque;
import java.util.ArrayDeque;

class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
public class JULY252026 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        

        
        while (root != null || !stack.isEmpty()) {
            // Push all left children to the stack (going as far left as possible)
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            // Pop the current smallest node
            root = stack.pop();
            
            // Decrement k; if it hits 0, we found our kth smallest element
            k--;
            if (k == 0) {
                return root.val;
            }
            
            // Explore the right subtree
            root = root.right;
        }
        
        return -1; // Fallback, though constraint guarantees valid k
    }
}

//time complexity:O(H + k)
//space complexity:O(H)