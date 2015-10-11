package excise;

import javax.swing.tree.TreeNode;

public class T104 {
	public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        else {
        	int k1 = maxDepth(root.getChildAt(0));
        	int k2 = maxDepth(root.getChildAt(1));
			return 1+ (k1>k2?k1:k2);
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
