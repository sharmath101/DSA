package BinaryTrees;

public class GFGMIRROR {
    void mirror(Node node) {
        // Your code here
        if(node == null){
            return;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }
}
