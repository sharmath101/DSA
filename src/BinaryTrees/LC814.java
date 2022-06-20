package BinaryTrees;

public class LC814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        root.right = pruneTree(root.right);
        root.left = pruneTree(root.left);
        return (((root.val == 1) || (root.right != null) || (root.left != null) )) ? root : null;
    }
}
