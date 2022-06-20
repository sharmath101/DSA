package TwoPointer;

import java.util.HashMap;
import java.util.HashSet;

public class GfGEquivalentSubArrays {
    static int countDistinctSubarray(int arr[], int n)
    {
        int count = 0;
        int result = 0;
        int last = 0 ;
        int first = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int k = 0; k < n; k++) {
            hs.add(arr[k]);
        }
        int numberOfDistinctElement = hs.size();
        HashMap<Integer , Integer> mp = new HashMap<>();

        while(last < n && first <= last){
//            if(!mp.containsKey(arr[last])){
//                count++;
//            }
            if(mp.size() < numberOfDistinctElement){
                mp.put(arr[last] , mp.getOrDefault(arr[last] , 0) + 1);
                last++;
            }

            if(mp.size() == numberOfDistinctElement){
                result += n - last + 1;
                if(mp.containsKey(arr[first])){
                    if(mp.get(arr[first]) == 1){
                        mp.remove(arr[first]);
                    }else{
                        mp.put(arr[first] , mp.get(arr[first]));
                    }
                }
                first++;
                // if(mp.size() == numberOfDistinctElement){
                //     result += n - last + 1;
                // }
            }

        }
        return result;
    }
}
