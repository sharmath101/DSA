package sorting;

public class LeetCode977 {
    public int[] sortedSquares(int[] nums) {
        int[] resultSquaredArray = new int[nums.length];
        int index = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) {
                index = i;
                break;
            }
        }

        if(index >= nums.length){
            int k = 0;
            for(int i = nums.length - 1 ; i >= 0 ; i--){
                resultSquaredArray[k++] = nums[i]*nums[i];
            }
            return resultSquaredArray;
        }
        if(index == 0){
            for (int i = 0; i < nums.length; i++) {
                resultSquaredArray[i] = nums[i]*nums[i];
            }
            return resultSquaredArray;
        }
        else{
            int left = index - 1;
            int k = 0;
            while(left >= 0 && index < nums.length){
                int valueAtIndex = nums[index]*nums[index];
                int valueAtLeft = nums[left]*nums[left];
                if(valueAtIndex >= valueAtLeft){
                    resultSquaredArray[k++] = valueAtLeft;
                    left--;
                }else{
                    resultSquaredArray[k++] = valueAtIndex;
                    index++;
                }
            }

            while(left >= 0){
                resultSquaredArray[k++] = nums[left]*nums[left];
                left--;
            }

            while(index < nums.length){
                resultSquaredArray[k++] = nums[index]*nums[index];
                index++;
            }


        }
        return resultSquaredArray;
    }
}
