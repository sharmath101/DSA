package Hashing;

import java.util.HashMap;

public class GFGLARGESTSUBARRAYWITHSUM0 {
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer , Integer> hash = new HashMap<>();
        hash.put(0 , -1);
        int prefixSum = 0;
        int ans = 0;
        for(int i  = 0 ; i <  n ; i++){
            prefixSum += arr[i];
            if(!hash.containsKey(prefixSum)){
                hash.put(prefixSum , i);
            }else{
                ans = Math.max( ans , i - hash.get(prefixSum));
            }
        }
        return ans;
    }
}
