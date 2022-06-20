package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class GFGNEXTGREATERELEMNT {
    public static long[] nextLargerElement(long[] arr, int n)
    {
        Stack<Integer> stk = new Stack<Integer>();
        Vector<Long> vec = new Vector<Long>();
        long[] ans = new long[n];
        stk.push(0);
        for (int i = 1; i < n; i++) {
            while(!stk.isEmpty() && arr[i] > arr[stk.peek()]){
                ans[stk.pop()] = arr[i];
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            ans[stk.pop()] = -1;
        }
        return ans;

    }
}
