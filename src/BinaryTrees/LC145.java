package BinaryTrees;

import java.util.ArrayList;
import java.util.Stack;

public class LC145 {
    public List<Integer> postorderTraversal(TreeNode root) {

        return iterativePostOrderTraversal(root);
    }

    private List<Integer> iterativePostOrderTraversal(TreeNode root) {
        // left | right | root .val;
        Stack<Pair> stk = new Stack<>();
        List<Integer> lst = new ArrayList<Integer>();
        if(root == null){
            return lst;
        }
        stk.push(new pair(root , false));
        while(!stk.isEmpty()){
            Pair pairAtTop = stk.pop();
            if(pairAtTop.getTag() == true){
                lst.add(pairAtTop.getNode().val);
            }
            else{
                stk.push(new Pair(pairAtTop.getNode() , true));
                if(pairAtTop.getNode().right != null){
                    stk.push(new pair(pairAtTop.getNode().right , false));
                }
                if(pairAtTop.getNode().left != null) {
                    stk.push(new pair(pairAtTop.getNode().left, false));
                }
            }
        }

        return lst;


    }

    public class Pair {
        private TreeNode node;
        private boolean tag;
        Pair(TreeNode node , boolean tag){
            this.node = node;
            this.tag = tag;
        }

        public TreeNode getNode() {
            return node;
        }

        public boolean getTag() {
            this.tag = tag;
        }
    }
}
