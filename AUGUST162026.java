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
public class AUGUST162026{
    private int maxSum;

    public int maxPathSum(TreeNode root){
        maxSum = Integer.MIN_VALUE;
        calculateMaxPath(root);
        return maxSum;
    }

    private int calculateMaxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(0, calculateMaxPath(node.left));
        int rightMax = Math.max(0, calculateMaxPath(node.right));
        int currentPathSum = node.val + leftMax + rightMax;

        maxSum = Math.max(maxSum, currentPathSum);
        return node.val + Math.max(leftMax, rightMax);
    }
}

//time complexity: O(n), where n is the number of nodes in the binary tree
//space complexity: O(h), where h is the height of the binary tree (due to recursion stack)