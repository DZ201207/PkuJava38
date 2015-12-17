package excise;

public class T101 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isMirror(root.left, root.right);
	}

	public boolean isMirror(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;
		return isMirror(left.left, right.right)
				&& isMirror(right.left, left.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
