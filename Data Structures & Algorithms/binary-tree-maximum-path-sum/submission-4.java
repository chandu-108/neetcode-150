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
    int maxSum;
    public int func(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=func(root.left);
        int r=func(root.right);

        int whole_sum=l+r+root.val;
        int left_or_right=Math.max(l,r)+root.val;
        int root_sum=root.val;

        maxSum = Math.max(maxSum,
                Math.max(root_sum, Math.max(whole_sum, left_or_right)));

        return Math.max(left_or_right,root_sum);
    }
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        func(root);
        return maxSum;
    }
}
