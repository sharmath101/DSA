package TwoPointer;

public class LEETCODE11 {
    public int maxArea(int[] height) {

        int length = height.length;
        int resultWaterStored = Math.min(height[0] , height[length - 1])*(length - 1);
        int start = 0;
        int end = length - 1;
        while(start < end){
            int resultWaterStoredAtPoint = Math.min(height[start] , height[end])*(end - start);
            resultWaterStored = Math.max(resultWaterStoredAtPoint , resultWaterStored);
            if(height[start] <= height[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return resultWaterStored;
    }
}
