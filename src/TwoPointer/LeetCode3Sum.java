package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }else{
                int target = -1*nums[i];
                int start = i + 1;
                int end = nums.length - 1;
                while(start < end){
                    if(nums[start] + nums[end] < target ){
                        start++;
                    }else if(nums[start] + nums[end] > target){
                        end--;
                    }else {
                        List<Integer> resultArray = new ArrayList<>();
                        resultArray.add(nums[i]);
                        resultArray.add(nums[start]);
                        resultArray.add(nums[end]);
                        result.add(resultArray);
                        if(nums[start] == nums[end]){
                            break;
                        }
                        int x = nums[start];
                        int y = nums[end];
                        while(nums[start] == x){
                            start++;
                        }
                        while (nums[end] == y){
                            end--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
