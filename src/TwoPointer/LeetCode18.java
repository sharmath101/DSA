package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i  < nums.length ; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1 ; j < nums.length ; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                else{
                    int remainedTarget = target - nums[i] - nums[j];
                    int start = j + 1;
                    int end = nums.length - 1;
                    while(start < end){
                        if(nums[start] + nums[end] < remainedTarget ){
                            start++;
                        }else if(nums[start] + nums[end] > remainedTarget){
                            end--;
                        }else {
                            List<Integer> resultArray = new ArrayList<>();
                            resultArray.add(nums[i]);
                            resultArray.add(nums[j]);
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
        }
        return result;
    }
}
