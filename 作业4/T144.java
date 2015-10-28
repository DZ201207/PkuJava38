package excise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T144 {
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root==null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		//TreeNode pNode = root;
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right!=null) 
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
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
		List<Integer> list = preorderTraversal(root);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
