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
        
        //�洢����ǰ���������������list
        List<Integer> postl = new ArrayList<Integer>();
        //��Ϊ��
        if(root==null){
            return postl;
        }
        //��ջ
        Stack<TreeNode> st = new Stack<TreeNode>();
        //hashset��������Ƿ��Ѿ����ʹ�
        HashSet<TreeNode> hs = new HashSet<TreeNode>();
        //�Ѹ��ڵ���ջ
        st.push(root);
        
        while(!st.isEmpty()){
            //ջ��Ԫ�س�ջ������temp���ڳ�ջԪ��
            TreeNode temp =st.pop();
            //�����Ԫ���ǵڶ��γ�ջ�����¼������б���,����������һ�εĲ���
            if(hs.contains(temp)){
                postl.add(temp.val);
                continue;
            }
            //��hashset�м�¼��temp
            hs.add(temp);
            
            //ѹջ˳��Ϊ�����ң��󣨺������˳��Ϊ���ң�����
            
            //�ڶ��ν���Ԫ��ѹ��ջ��
            st.push(temp);
            //���ҽڵ㲻Ϊ�գ�����ҽڵ�ѹ��ջ��
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