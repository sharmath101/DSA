package Hashing;

import java.util.HashMap;

public class GFGLongestSubArraywithSumK {
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        //Complete the function

        HashMap<Integer , Integer> hash = new HashMap<>();
        hash.put(0 , -1);
        int prefixSum = 0;
        int ans = 0;
        for(int i  = 0 ; i <  n ; i++){
            prefixSum += arr[i];
            if(hash.containsKey(prefixSum - k)){
                ans = Math.max( ans , i - hash.get(prefixSum - k));
            }
            if(!hash.containsKey(prefixSum)){
                hash.put(prefixSum , i);
            }
        }
        return ans;
    }
}
