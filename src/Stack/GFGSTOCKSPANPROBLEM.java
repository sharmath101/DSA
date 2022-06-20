package Stack;

import java.util.Stack;

public class GFGSTOCKSPANPROBLEM {
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Integer> stk = new Stack<Integer>();
        int[] ans = new int[n];
        stk.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while(!stk.isEmpty() && price[i] <= price[stk.peek()]){
                ans[stk.pop()] = i;
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            ans[stk.pop()] = -1;
        }
        return ans;
    }
}
