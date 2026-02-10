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
class Solution {
    private int sum(TreeNode root , int total ){
        if(root == null){
            return 0 ;
        }
        total = total * 10 + root.val;

        if(root.left == null && root.right == null){
            return total;
        }
        
        return sum(root.left,total)+sum(root.right , total);
    }

    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }
}