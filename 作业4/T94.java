package excise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T94 {
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root==null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pNode = root;
		//stack.push(root);
		while (!stack.isEmpty() || pNode!=null) {
			while (pNode!=null) {
				stack.push(pNode);
				pNode=pNode.left;
			}
			if (!stack.isEmpty()) {
				pNode = stack.pop();
				list.add(pNode.val);
				pNode=pNode.right;
			}
			
		}	
		return list;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> list = inorderTraversal(root);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}