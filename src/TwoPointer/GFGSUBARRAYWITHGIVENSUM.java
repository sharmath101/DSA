package TwoPointer;

import java.util.ArrayList;

public class GFGSUBARRAYWITHGIVENSUM {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int currentSum = arr[0];
        int start = 0 ;
        int end = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(end < n){
            if(currentSum < s){
                end++;
                if(end < n){
                    currentSum += arr[end];
                }
            }else if(currentSum > s){
                currentSum -= arr[start];
                start++;
                if(start > end){
                    end++;
                    if(end < n)
                        currentSum = arr[start];
                }
            }
            else{
                result.add(start + 1);
                result.add(end + 1);
                return  result;
            }
        }
        result.add(-1);
        return  result;
    }

}
