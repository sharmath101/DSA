package searching;

public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        return twoPointerApproach(target,nums);
    }
    private int NlogNApproach(int target, int[] nums){
        int ans = Integer.MAX_VALUE;
        int prefixSum[] = new int[nums.length + 1];
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        for(int i = 0 ; i< prefixSum.length ; i++){
            int count = binarySearch(i + 1 , prefixSum.length - 1 , prefixSum , target + prefixSum[i]);
            if(count == prefixSum.length){
                break;
            }
            if(count - i < ans){
                ans = count;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    private int binarySearch(int start, int end, int[] prefixSum, int target) {
        while(start <= end){
            int middle = start + (end - start)/2;
            if(prefixSum[middle] < target){
                start = middle + 1;
            }else{
                end = middle - 1;
            }
        }
        return start;
    }

    private int twoPointerApproach(int target, int[] nums){
        int length  = nums.length;
        int ans = 0;
        int left = 0;
        int leastIndex = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            ans += nums[i];
            while(ans >= target){
                leastIndex = Math.min(i  +  1 - left , leastIndex);
                ans -= nums[left++];
            }

        }
        return leastIndex == Integer.MAX_VALUE ? 0 : leastIndex;
    }
}
