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

public class SEPTEMBER032026{
    private Map<Integer, Integer> inorderIndex = new HashMap<>();
    private int postIndex;
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder){
        this.postorder = postorder;
        postIndex = postorder.length - 1;

        for(int i=0; i<inorder.length; i++){
            inorderIndex.put(inorder[i], i);
        }
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int mid = inorderIndex.get(rootVal);

        root.right = build(mid + 1, inRight);
        root.left = build(inLeft, mid - 1);

        return root;
    }
}

//time complexity: O(n)
//space complexity: O(n)