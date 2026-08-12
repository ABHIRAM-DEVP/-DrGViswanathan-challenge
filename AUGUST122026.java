import java.util.HashMap;
import java.util.Map;
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
public class AUGUST122026{
    public TreeNode buildTree(int[] preorder, int[] inorder){
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i< inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }
    
    private TreeNode helper(int[] preorder, int preStart, int preEnd, 
                            int[] inorder, int inStart, int inEnd, 
                            Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inRootIndex = inorderMap.get(root.val);
        int numsLeft = inRootIndex - inStart;        
        root.left = helper(preorder, preStart + 1, preStart + numsLeft, 
                           inorder, inStart, inRootIndex - 1, inorderMap);
                           
        root.right = helper(preorder, preStart + numsLeft + 1, preEnd, 
                            inorder, inRootIndex + 1, inEnd, inorderMap);
                            
        return root;
    }
}

//Time Complexity: O(N)
//Space Complexity: O(N)