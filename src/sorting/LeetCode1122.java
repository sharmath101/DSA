package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int last = arr1.length - 1;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0 ; i < arr2.length ; i++){
            mp.put(arr2[i] , 0);
        }
        for(int i = 0 ; i < arr1.length ; i++ ){
            if(mp.containsKey(arr1[i])){
                mp.put(arr1[i] , mp.get(arr1[i]) + 1);
            }else{
                result[last--] = arr1[i];
            }
        }
        int start = 0;
        for(int i = 0 ; i < arr2.length ; i++){
            for (int j = 0; j < mp.get(arr2[i]); j++) {
                result[start++] = arr2[i];
            }
        }

        Arrays.sort(result , start , arr1.length);
        return result;
    }
}
