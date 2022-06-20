package TwoPointer;

public class LEETCODE27 {
    public int removeElement(int[] nums, int val) {
        int j = nums.length;
        int i = 0;
        while(i < j) {
            if(nums[i] == val){
                nums[i] = nums[j - 1];
                j--;
            }
            else{
                i++;
            }
        }
        return j;
    }
}
