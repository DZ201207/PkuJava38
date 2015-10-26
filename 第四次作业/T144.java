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
        //�洢����ǰ���������������list
        List<Integer> prel = new ArrayList<Integer>();
        //��Ϊ��
        if(root==null){
            return prel;
        }
        //��ջ
        Stack<TreeNode> st = new Stack<TreeNode>();

        //�Ѹ��ڵ���ջ
        st.push(root);
        
        while(!st.isEmpty()){
            //ջ��Ԫ�س�ջ������temp���ڳ�ջԪ��
            TreeNode temp =st.pop();
            
            //ѹջ˳��Ϊ �ң��󣬸���ǰ�����˳��Ϊ��, ���ң�
            //���ڸ��ڵ�ı�����չ�����о����ҽڵ����ڵ㣩��ͬʱ�ģ����Ը��ڵ��ջ��ͬʱ���ɼ����������У�Ȼ���о����ҽڵ����ڵ㣬�����Ϊ�ռ�����ջ��
            prel.add(temp.val);
            //���ҽڵ㲻Ϊ�գ�����ҽڵ�ѹ��ջ��
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