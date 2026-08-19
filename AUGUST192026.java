import java.util.ArrayList;
import java.util.List;
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
public class AUGUST192026{
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    
    private void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (level == result.size()) {
            result.add(node.val);
        }
        
        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);
    }
}

//time complexity: O(n)
//space complexity: O(h) 