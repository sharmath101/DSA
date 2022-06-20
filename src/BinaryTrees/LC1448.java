package BinaryTrees;

public class LC1448 {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root , -100000);
    }

    public int countGoodNodes(TreeNode root , int pathMax){
        if(root == null){
            return 0;
        }

        int result = root.val >= pathMax ? 1 : 0;
        result = result + countGoodNodes(root.left , Math.max(root.val , pathMax));
        result = result + countGoodNodes(root.right , Math.max(root.val , pathMax));
        return result;
    }
}
