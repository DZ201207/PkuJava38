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
    public List<Integer> inorderTraversal(TreeNode root) {
         //存储树的前序遍历的输出结果的list
        List<Integer> inl = new ArrayList<Integer>();
        //树为空
        if(root==null){
            return inl;
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
                inl.add(temp.val);
                continue;
            }
            //在hashset中记录下temp
            hs.add(temp);
            
            //压栈顺序为 右， 根， 左（因为中序遍历顺序为左 根 右）
            
            
            //若右节点不为空，则把右节点压入栈中
            if(temp.right!=null){
                 st.push(temp.right);
            }
            
            //第二次将该元素压入栈中
            st.push(temp);
            
            if(temp.left!=null){
                st.push(temp.left);
            }
            
        }
        
        //中序遍历比前序遍历复杂一些，主要是需要区分得到的节点是需要展开还是直接遍历。一般来说第一次访问节点则展开，并且自己重新入栈，第二次从栈中访问到则计入遍历。这里采用HashSet来判断是否已经访问过。
        
        return inl;
    }
}