package excise;

import java.util.LinkedList;
import java.util.Queue;

public class T111 {
	

	   public static int minDepth(TreeNode root) {
		   if (root==null) return 0;
		   int deep = 1;
		   int current_level = 1;
		   int next_level = 0;
		   Queue<TreeNode> queue_tree = new LinkedList<TreeNode>();
		   queue_tree.add(root);
		   while (!queue_tree.isEmpty()) 
		   {
			   TreeNode node = queue_tree.remove();
			   current_level--;
			   if (node.left==null&&node.right==null) return deep;
			   if (node.left!=null) 
			   {
				  next_level++;
				  queue_tree.add(node.left);
			   }
			   if (node.right!=null) 
			   {
				  next_level++;
				  queue_tree.add(node.right);
			   }
			   if (current_level==0) {
				  if (next_level!=0) {
					deep++;
				  }
				  current_level = next_level;
				  next_level=0;
			   }
		   }
		   return deep;
	   }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
	class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	  }