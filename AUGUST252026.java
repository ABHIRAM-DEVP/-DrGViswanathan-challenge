import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
import java.util.ArrayList;
import java.util.LinkedList;
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

public class AUGUST252026{
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode>q = new LinkedList<>();
        List<List<Integer>>result = new ArrayList<>();
        if(root == null)return result;
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer>currentLevel = new ArrayList<>();
            for(int i=0; i<len; i++){
                TreeNode temp = q.poll();
                currentLevel.add(temp.val);
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}

//time complexity: O(n)
//space complexity: O(w)