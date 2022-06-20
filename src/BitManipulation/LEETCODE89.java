package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class LEETCODE89 {
    // 0 -> 0
    // 1 -> 1 2^0 ADD THIS TO THE LIST IN REVERSE ORDER -> 0 , 1
    // 2 -> 10 2^1 ADD THIS TO THE LIST IN REVERSE ORDER -> 0 , 1 , 3 , 2
    // 3 -> 100 2^2 ADD THIS TO THE LIST IN REVERSE ORDER -> 0 , 1 , 3 , 2 , 6 , 7 , 5 , 4

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if(n == 0){
            return result;
        }
        result.add(1);
        int count = 1;
        for(int i = 2 ; i <= n ; i++){
            count <<= 1;
            for(int j = result.size() - 1 ; j>= 0 ; j--){
                result.add(result.get(j) | count);
            }
        }
        return result;
    }

}
