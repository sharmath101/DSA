package BinaryTrees;

public class LC1315 {
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getEvenSumGrandParent(root , 1 , 1);
    }

    public int getEvenSumGrandParent(TreeNode root , int parentValue , int grandParentValue){
        if(root == null){
            return 0;
        }
        return getEvenSumGrandParent(root.left , root.val , parentValue) + getEvenSumGrandParent(root.right , root.val , parentValue) + (grandParentValue%2 == 0 ? root.val :0);
    }
}
