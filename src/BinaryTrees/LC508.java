package BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC508 {
    int maxValue;
    HashMap<Integer,Integer> resultHashMap
    public int[] findFrequentTreeSum(TreeNode root) {
        maxValue = 0;
        resultHashMap = new HashMap<>();
        List<Integer> lst = new ArrayList<>();

        postOrderTraversal(root);

        for (int val : resultHashMap.keySet()){
            if(resultHashMap.get(val) == Integer.valueOf(maxValue)){
                lst.add(val);
            }
        }

        int result [] = new int[lst.size()];
        for (int index = 0; index < lst.size(); index++) {
            result[index] = lst.get(index);
        }
        return result;
    }

    private int postOrderTraversal(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = postOrderTraversal(root.left);
        int right = postOrderTraversal(root.right);

        int result = left + right + root.val;
        int count = resultHashMap.getOrDefault(result , 0) + 1;
        maxValue = Math.max(count , maxValue);
        resultHashMap.put(result , count);
        return result;

    }
}
