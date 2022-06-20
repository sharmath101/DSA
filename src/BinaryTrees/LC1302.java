package BinaryTrees;

public class LC1302 {
    int depth = 0;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        helperDeepestLeavesSum(root , 0);
        return sum;
    }

    public void helperDeepestLeavesSum(TreeNode root , int depthAtNode){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(depthAtNode == depth){
                sum = sum + root.val;
            }else if(depthAtNode > depth){
                depth = depthAtNode;
                sum = root.val;
            }
        }
        helperDeepestLeavesSum(root.left , depthAtNode + 1);
        helperDeepestLeavesSum(root.right , depthAtNode + 1);

    }
}
