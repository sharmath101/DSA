package Stack;

import java.util.Stack;

public class LC84 {

    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int[] nextMinimumHeight = computNextMinimumHeight(heights , heights.length);
        int[] previousMinimumHeight = computPreviousMinimumHeight(heights , heights.length);

        for(int i = 0 ; i < heights.length ; i++){

            maxArea = Math.max(maxArea , (nextMinimumHeight[i] - previousMinimumHeight[i] - 1)*heights[i]);
        }
        return maxArea;

    }
    public int[] computNextMinimumHeight(int[] heights , int n){
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

    public int[] computPreviousMinimumHeight(int[] heights , int n){
        Stack<Integer> stk = new Stack<Integer>();
        int[] ans = new int[n];
        stk.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while(!stk.isEmpty() && heights[i] < heights[stk.peek()]){
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
