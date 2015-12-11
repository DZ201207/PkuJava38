package excise;

public class T235 {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null) return null;
        if(q.val<root.val&&p.val<root.val) return lowestCommonAncestor(root.left, p, q);
        else if(q.val>root.val&&p.val>root.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
