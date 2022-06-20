package BitManipulation;

import java.util.ArrayList;

public class GfGPowerOf2AndSubsequences {
    static Long numberOfSubsequences(int N, ArrayList<Long> A){
        // code here
        long count = 0;
        for(int i = 0 ; i < N ; i++){
            if(isPowerOf2(A.get(i))){
                count++;
            }
        }
        return (long)(Math.pow(2 , count)) - 1;
    }

    private static boolean isPowerOf2(Long number) {
        if(number == 0){
            return false;
        }else if(number == 1){
            return true;
        }else{
            if((number & number - 1) == 0){
                return true;
            }
        }
        return false;
    }
}
