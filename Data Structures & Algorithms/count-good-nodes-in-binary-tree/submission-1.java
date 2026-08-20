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
    public int goodNodes(TreeNode root) {
        int cnt=0;
        if(root==null){
            return 0;
        }
        Queue<TreeNode>q=new LinkedList<>();
        Queue<Integer>maxQ=new LinkedList<>();
        q.offer(root);
        maxQ.offer(root.val);
        while(!q.isEmpty()){
                TreeNode curr=q.poll();
                int maxvalue=maxQ.poll();
                
                if(maxvalue <= curr.val){
                    cnt++;
                }
                int newvalue=Math.max(maxvalue,curr.val);
                if(curr.left!=null){
                    q.offer(curr.left);
                    maxQ.offer(newvalue);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                    maxQ.offer(newvalue);
            }
        }
        return cnt;
    }
}
