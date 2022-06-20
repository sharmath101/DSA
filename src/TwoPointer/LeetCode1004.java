package TwoPointer;

public class LeetCode1004 {
    public int longestOnes(int[] nums, int k) {
        int answer = 0;
        int i  = 0;
        int j = 0;
        int countK = 0;
        while(j < nums.length){
            if(nums[j] == 1){
                j++;
            }else{
                if(countK < k){
                   j++;
                   countK++;
                }else{
                    if(nums[i] == 0){
                        countK--;
                    }
                    i++;
                }
            }
            answer = Math.max(answer , j - i + 1);
        }
        return  answer;
    }
}
