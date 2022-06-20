package Hashing;

import java.util.HashMap;

public class LEETCODE992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int result = 0;
        HashMap<Integer , Integer> mp = new HashMap<>();

        int start = 0;
        int end = 0;

        while(end < nums.length){
            mp.put(nums[end] , mp.getOrDefault(nums[end] , 0) + 1 );
            while (mp.size() > k) {
                mp.put(nums[start], mp.getOrDefault(nums[start], 0) - 1);
                if (mp.get(nums[start]) == 0) mp.remove(nums[start]);
                start++;
            }
            result += end - start + 1;
        }

        return result;
    }
}
