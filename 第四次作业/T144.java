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
    public List<Integer> preorderTraversal(TreeNode root) {
        //存储树的前序遍历的输出结果的list
        List<Integer> prel = new ArrayList<Integer>();
        //树为空
        if(root==null){
            return prel;
        }
        //堆栈
        Stack<TreeNode> st = new Stack<TreeNode>();

        //把根节点入栈
        st.push(root);
        
        while(!st.isEmpty()){
            //栈顶元素出栈，且另temp等于出栈元素
            TreeNode temp =st.pop();
            
            //压栈顺序为 右，左，根（前序遍历顺序为根, 左，右）
            //由于根节点的遍历和展开（研究其右节点和左节点）是同时的，所以根节点出栈的同时即可加入遍历结果中，然后研究其右节点和左节点，如果不为空即可入栈。
            prel.add(temp.val);
            //若右节点不为空，则把右节点压入栈中
            if(temp.right!=null){
                st.push(temp.right);
            }
            if(temp.left!=null){
                st.push(temp.left);
            }
            
        }
        
        return prel;
    }
}