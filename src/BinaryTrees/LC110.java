package BinaryTrees;

public class LC110 {
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(getHeight(root.left) , getHeight(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return ((Math.abs(leftHeight - rightHeight) <= 1) && (isBalanced(root.left)) && (isBalanced(root.right)));

    }
}
