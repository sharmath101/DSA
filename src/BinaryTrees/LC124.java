package BinaryTrees;

public class LC124 {
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getMaxSum(root).getFirst();
    }

    public pair getMaxSum(TreeNode root){
        if(root == null){
            return new pair(Integer.MIN_VALUE , 0);
        }

        pair lst = getMaxSum(root.left);
        pair rst = getMaxSum(root.right);
        int pathMaxLst = Math.max(0 , lst.getSecond());
        int pathMaxRst = Math.max(0 , rst.getSecond());
        int max_path_sum = Math.max(Math.max(lst.getFirst(), rst.getFirst()) , root.val + pathMaxRst + pathMaxLst);
        int pathMaxForRoot = root.val + Math.max(pathMaxRst , pathMaxLst);

        return new pair(max_path_sum , pathMaxForRoot);
    }

    public class pair{
        private int first;
        private int second;

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        pair(int first , int second){
            this.first = first;
            this.second = second;
        }
    }
}
