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
    private int sum = Integer.MIN_VALUE ;
    private int solve(TreeNode root){
        if(root == null) return 0 ;

        int left = Math.max(0 ,solve(root.left)) ;
        int right = Math.max(0 ,solve(root.right)) ;

        int currSum = root.val + left + right ;
        sum = Math.max(sum , currSum) ;

        return root.val + Math.max(left , right) ; 
    }

    public int maxPathSum(TreeNode root) {
       solve(root);
        return sum ;
    }
}