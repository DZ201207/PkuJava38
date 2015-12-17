package excise;

public class T110 {
	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(heigth(root.left) - heigth(root.right)) > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}

	public static int heigth(TreeNode root) {
		if (root == null)
			return 0;
		int lh = heigth(root.left);
		int rh = heigth(root.right);
		return lh > rh ? lh + 1 : rh + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = null;
		root.right.right = new TreeNode(3);
		root.right.right.left = null;
		root.right.right.right = null;
		System.out.println(isBalanced(root));

	}
}
