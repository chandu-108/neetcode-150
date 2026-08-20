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
    HashMap<Integer,Integer>map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
    return build(preorder,0,0,n-1);
    }
    public TreeNode build(int preorder[],int prestart,int instart,int inend){
        if(instart > inend){
            return null;
        }
        TreeNode root=new TreeNode(preorder[prestart]);

        int rootidx=map.get(root.val);
        int leftsize=rootidx-instart;
        
        root.left=build(preorder,prestart+1,instart,rootidx-1);
        root.right=build(preorder,leftsize+prestart+1,rootidx+1,inend);
    return root;
    }
}
