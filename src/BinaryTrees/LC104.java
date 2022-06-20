package BinaryTrees;

public class LC104 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);
        return 1 + Math.max(depthLeft , depthRight);
    }
}
