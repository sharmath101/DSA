package TwoPointer;

import java.util.Arrays;

public class LEETCODE16 {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int resultSum = nums[0] + nums[1] + nums[nums.length - 1];
        if(nums.length == 3){
            return resultSum;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int absSum = nums[i] + nums[start] + nums[end];

                if(absSum <= target){
                    start++;
                }else if(absSum > target){
                    end--;
                }
                if(Math.abs(absSum - target) < Math.abs(resultSum - target)){
                    resultSum = absSum;
                }
            }

        }
        return  resultSum;
    }
}
