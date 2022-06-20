package Stack;

import java.util.Stack;

public class LC85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int rows = matrix.length;

        int columns = matrix[0].length;
        int result = Integer.MIN_VALUE;
        int[] heightAtEachIndex = new int[columns];
        for(int i = 0 ; i < rows ; i++){
            for (int j = 0  ; j < columns ; j++){
                if(matrix[i][j] == '1'){
                    heightAtEachIndex[j] += 1;
                }else {
                    heightAtEachIndex[j] = 0;
                }
            }
            int resultAtEachColumn = largestRectangleArea(heightAtEachIndex);
            result = Math.max(result , resultAtEachColumn);
        }
        return result;
    }

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
