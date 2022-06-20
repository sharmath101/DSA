package Hashing;

import java.util.HashMap;

public class GfGConsecutiveArrayElements {
    boolean areConsecutives(long arr[], int N)
    {
        HashMap<Long , Long> mp = new HashMap<>();
        
        long min = Long.MAX_VALUE;
        for(int i = 0 ; i < N ; i++){
            mp.put(arr[i] , (long) 0);
            min = Math.min(min , arr[i]);
        }
        for (long i = min; i < min + N; i++) {
            if (!mp.containsKey(i)) {
                return false;
            }
        }
        return true;

    }
}
