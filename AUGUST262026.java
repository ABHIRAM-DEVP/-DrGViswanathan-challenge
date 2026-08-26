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
import java.util.List;
import java.util.Queue;

import java.util.Collections;

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

public class AUGUST262026{
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //level order : bfs
        
        List<List<Integer>>result = new ArrayList<>();
        if(root == null)return result;
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int len = q.size();
            List<Integer>currentLevel = new ArrayList<>(); //resets everytime for loop ends and next while loop is about to execute

            for(int i=0; i< len; i++){
                TreeNode temp = q.poll();
                currentLevel.add(temp.val);

                if(temp.left !=null){
                    q.add(temp.left);
                }
                if(temp.right !=null){
                    q.add(temp.right);
                }
            }
            result.add(currentLevel);
        }
        Collections.reverse(result);
        return result;
    }
}

//time complexity : O(n) where n is number of nodes in the tree
//space complexity : O(n) where n is number of nodes in the tree