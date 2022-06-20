package searching;

public class LeetCode1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 1000000;

        while(start < end){
            int middle = start + (end - start)/2;
            int thresholdValueReceived = isSupported(nums , middle );
            if(thresholdValueReceived <= threshold){
                end = middle;
            }else{
                start = middle + 1;
            }
        }
        return start;
    }

    public int isSupported(int[] nums , int middle ){
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            value = (int) (value + Math.ceil((double)nums[i]/middle));
        }
        return value;
    }

}
