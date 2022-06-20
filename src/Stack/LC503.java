package Stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

public class LC503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<Integer>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans , -1);
        for (int i = 0; i < 2*n; i++) {
            while(!stk.isEmpty() && nums[i%n] > nums[stk.peek()]){
                ans[stk.pop()] = nums[i%n];
            }
            stk.push(i%n);
        }
        return ans;
    }
}
