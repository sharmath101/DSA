package BinaryTrees;

public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isMirrorImage(root.left , root.right);
    }

    public boolean isMirrorImage(TreeNode left , TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }

        return left.val == right.val && isMirrorImage(left.right , right.left) && isMirrorImage(left.left , right.right);
    }
}
