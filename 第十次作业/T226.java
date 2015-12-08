/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null; 
        TreeNode temp = root.left; 
        root.left = root.right; 
        root.right = temp; 
        invertTree(root.left); 
        invertTree(root.right); 
        return root;
        /*if(root == null) return null;
        Stack<TreeNode> tnStack = new Stack<TreeNode>();
        tnStack.push(root);
        while(!tnStack.isEmpty()){
            TreeNode cur = tnStack.pop();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if(cur.left != null) tnStack.push(cur.left);
            if(cur.right != null) tnStack.push(cur.right);
        }
        return root;*/
    }
}