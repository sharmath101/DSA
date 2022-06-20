package BinaryTrees;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        return preOrderIterative(root);
    }

    List<Integer> preOrderIterative(TreeNode root){
        Stack<TreeNode> stk = new Stack<TreeNode>();
        List<Integer> lst = new ArrayList<>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode atTop = stk.pop();
            lst.a
            if(atTop.right){
                stk.push(atTop.right);
            }
            if(atTop.left){
                stk.push(atTop.left);
            }
        }
        return lst;

    }
}
