package BinaryTrees;

public class LC111 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helperMinDepth(root);
    }
    public int helperMinDepth(TreeNode root){
        if(root == null){
            return 100005;
        }

        if(root.right == null && root.left == null){
            return 1;
        }

        int leftDepth = helperMinDepth(root.left);
        int rightDepth = helperMinDepth(root.right);

        return 1 + Math.min(leftDepth , rightDepth);

    }
}
