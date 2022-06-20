package BitManipulation;

public class LEETCODE260 {
    public int[] singleNumber(int[] nums) {
        int overAllXor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            overAllXor = (overAllXor^nums[i]);
        }
        overAllXor = overAllXor & (-overAllXor);
        int val1 = 0;
        int val2 = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if((overAllXor&nums[i]) != 0){
                val1 = val1^nums[i];
            }else{
                val2 = val2^nums[i];
            }
        }
        int [] result = new int[2];
        result[0] = val1;
        result[1] = val2;
        return result;
    }
}
