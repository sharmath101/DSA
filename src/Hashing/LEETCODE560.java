package Hashing;

import java.util.HashMap;

public class LEETCODE560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer , Integer> hash = new HashMap<>();
        hash.put(0 , 1);
        int prefixSum = 0;
        int ans = 0;
        for(int i  = 0 ; i < nums.length ; i++){
            prefixSum += nums[i];
            if(hash.containsKey(prefixSum - k)){
                ans += hash.get(prefixSum - k);
            }
            hash.put(prefixSum , hash.getOrDefault(prefixSum , 0) + 1);
        }
        return ans;
    }
}
