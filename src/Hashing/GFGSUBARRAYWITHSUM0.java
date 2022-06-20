package Hashing;

import java.util.HashMap;

public class GFGSUBARRAYWITHSUM0 {

    static boolean findsum(int arr[],int n)
    {
        HashMap<Integer , Integer> hash = new HashMap<>();
        hash.put(0 , 1);
        int prefixSum = 0;
        for(int i  = 0 ; i <  n ; i++){
            prefixSum += arr[i];
            if(hash.containsKey(prefixSum)){
                return true;
            }else{
                hash.put(prefixSum , 1);
            }
        }
        return  false;
    }
}
