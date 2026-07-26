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
public class JULY262026{
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        
        while (curr != null) {
            // If there is a left child, we need to find its rightmost node (predecessor)
            if (curr.left != null) {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                
                // Rewire pointers
                predecessor.right = curr.right; // Attach original right subtree to predecessor's right
                curr.right = curr.left;         // Move left subtree to the right side
                curr.left = null;               // Nullify the left pointer
            }
            
            // Move on to the next node on the right
            curr = curr.right;
        }
    }
}

//time complexity: O(N)
//space complexity: O(1)