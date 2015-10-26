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
         //�洢����ǰ���������������list
        List<Integer> inl = new ArrayList<Integer>();
        //��Ϊ��
        if(root==null){
            return inl;
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
                inl.add(temp.val);
                continue;
            }
            //��hashset�м�¼��temp
            hs.add(temp);
            
            //ѹջ˳��Ϊ �ң� ���� ����Ϊ�������˳��Ϊ�� �� �ң�
            
            
            //���ҽڵ㲻Ϊ�գ�����ҽڵ�ѹ��ջ��
            if(temp.right!=null){
                 st.push(temp.right);
            }
            
            //�ڶ��ν���Ԫ��ѹ��ջ��
            st.push(temp);
            
            if(temp.left!=null){
                st.push(temp.left);
            }
            
        }
        
        //���������ǰ���������һЩ����Ҫ����Ҫ���ֵõ��Ľڵ�����Ҫչ������ֱ�ӱ�����һ����˵��һ�η��ʽڵ���չ���������Լ�������ջ���ڶ��δ�ջ�з��ʵ������������������HashSet���ж��Ƿ��Ѿ����ʹ���
        
        return inl;
    }
}