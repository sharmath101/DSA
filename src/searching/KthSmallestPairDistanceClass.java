package searching;

import java.util.Arrays;

public class KthSmallestPairDistanceClass {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int small = nums[1]  - nums[0];
        for (int i = 1; i <= length-2; ++i) {
            small = Math.min(small, nums[i + 1] - nums[i]);
        }
        int high = nums[length - 1] - nums[0];

        while(small < high){
            int middle = (small + high)/2;
            if(countPairs(middle , length , k , nums) < k){
                small = middle + 1;
            }else{
                high = middle;
            }
        }
        return small;
    }

    private int countPairs(int middle, int length, int k , int[] nums) {
        int count = 0;
        for(int i = 0 ; i < length ; i++){
            int upperBoundIndex = upperBoundSearch(length - 1, middle , nums);
            count = count + upperBoundIndex - i - 1;
        }
        return count;
    }

    private int upperBoundSearch(int length , int value ,int nums[]) {

        int low = 0;
        int high = length;
        while(low < high){
            int middleArrayElement = (low + high)/2;
            if(value >= nums[middleArrayElement]){
                low = middleArrayElement + 1;
            }else{
                high = middleArrayElement;
            }

        }
        return low;
    }


}
