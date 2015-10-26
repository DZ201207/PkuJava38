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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        //存储树的前序遍历的输出结果的list
        List<Integer> postl = new ArrayList<Integer>();
        //树为空
        if(root==null){
            return postl;
        }
        //堆栈
        Stack<TreeNode> st = new Stack<TreeNode>();
        //hashset用来标记是否已经访问过
        HashSet<TreeNode> hs = new HashSet<TreeNode>();
        //把根节点入栈
        st.push(root);
        
        while(!st.isEmpty()){
            //栈顶元素出栈，且另temp等于出栈元素
            TreeNode temp =st.pop();
            //如果该元素是第二次出栈，则记录入遍历列表中,并且跳过第一次的步骤
            if(hs.contains(temp)){
                postl.add(temp.val);
                continue;
            }
            //在hashset中记录下temp
            hs.add(temp);
            
            //压栈顺序为根，右，左（后序遍历顺序为左，右，根）
            
            //第二次将该元素压入栈中
            st.push(temp);
            //若右节点不为空，则把右节点压入栈中
            if(temp.right!=null){
                st.push(temp.right);
            }
            if(temp.left!=null){
                st.push(temp.left);
            }
            
        }
        
        return postl;
    }
}