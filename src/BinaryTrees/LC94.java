package BinaryTrees;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        return withoutFlagInorderTraversal(root);
    }

    private List<Integer> withoutFlagInorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        if(root == null){
            return lst;
        }

        TreeNode temp = root;
        while(temp != null){
            stk.push(temp);
            temp = temp.left;
        }

        while(!stk.isEmpty()){
            TreeNode peek = stk.pop();
            lst.push(peek.val);
            TreeNode right = peek.right;
            while(right != null){
                stk.push(right);
                right = right.left;
            }

        }
        return lst;
    }


}
