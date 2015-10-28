package excise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class T145 {
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root==null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		HashMap<TreeNode, Boolean> finished = new HashMap<TreeNode, Boolean>();
		TreeNode pNode = root;
		//stack.push(root);
		while (!stack.isEmpty() ||pNode!=null) {
			while (pNode!=null) {
				stack.push(pNode);
				finished.put(pNode, false);
				pNode=pNode.left;
			}
			if (!stack.isEmpty()) {
				pNode = stack.pop();
				if (pNode.right==null || (finished.get(pNode.right)!=null && finished.get(pNode.right))) {
					list.add(pNode.val);
					finished.put(pNode, true);
					pNode=null;
				}else if (!finished.get(pNode)) {
					stack.push(pNode);
					pNode = pNode.right;
				}
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
		List<Integer> list = postorderTraversal(root);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}


	}

}
