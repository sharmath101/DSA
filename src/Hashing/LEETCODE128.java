package Hashing;

import java.util.HashMap;

public class LEETCODE128 {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        HashMap<Integer , Integer> mp = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(mp.containsKey(nums[i])){
                continue;
            }else{
                int ls = 0;
                int rs = 0;

                if(mp.containsKey(nums[i] - 1)){
                    ls = mp.get(nums[i] - 1);
                }
                if(mp.containsKey(nums[i] + 1)){
                    rs = mp.get(nums[i] + 1);
                }
                ans = Math.max(ans , 1 + ls + rs);
                mp.put(nums[i] , 1 + ls + rs);
                mp.put(nums[i] - ls , 1 + ls + rs);
                mp.put(nums[i] + rs , 1 + ls + rs);
            }
        }
        return  ans;
    }
}
