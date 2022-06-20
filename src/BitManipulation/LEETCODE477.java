package BitManipulation;

public class LEETCODE477 {
    public int totalHammingDistance(int[] nums) {
        long mask = (1L << 31);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int count = 0;
            for(int j = 0 ; j < nums.length ; j++){
                if((mask & nums[j]) != 0)
                {
                    count++;
                }
            }
            result += count*(nums.length - count);
            mask = (mask >> 1);
        }
        return result;
    }
}
