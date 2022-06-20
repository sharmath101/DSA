package BinaryTrees;

public class LC404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return solveTheProblem(root , false);
    }

    public int solveTheProblem(TreeNode root , boolean isLeft){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null && isLeft){
            return root.val;
        }
        return solveTheProblem(root.left , true) + solveTheProblem(root.right ,false);
    }
}
