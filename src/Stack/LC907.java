package Stack;

import java.util.Stack;

public class LC907 {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0, mod = (int)1e9 + 7;
        int [] resultRight = computNextMinimumValue(arr , n);
        int [] resultLeft = computPreviousMinimumOrEqualValue(arr , n);
        for (int i = 0; i < n; i++) {
            res = (res + ((((resultRight[i] - i)%mod)*((i - resultLeft[i])%mod))*arr[i]%mod)%mod)%mod;
        }
        return (int)res;
    }

    public int[] computNextMinimumValue(int[] heights , int n){
        Stack<Integer> stk = new Stack<Integer>();
        int[] ans = new int[n];
        stk.push(0);
        for (int i = 1; i < n; i++) {
            while(!stk.isEmpty() && heights[i] < heights[stk.peek()]){
                ans[stk.pop()] = i;
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            ans[stk.pop()] = n;
        }
        return ans;
    }

    public int[] computPreviousMinimumOrEqualValue(int[] heights , int n){
        Stack<Integer> stk = new Stack<Integer>();
        int[] ans = new int[n];
        stk.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while(!stk.isEmpty() && heights[i] <= heights[stk.peek()]){
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
