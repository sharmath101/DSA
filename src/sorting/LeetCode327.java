package sorting;

import java.util.Arrays;

public class LeetCode327 {
    int count = 0;
    int lower;
    int upper;
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sumArray[] = new long[nums.length + 1];
        long[] temp = new long[nums.length + 1];
        sumArray[0] = 0;
        for(int i = 1 ; i <= nums.length ; i++){
            sumArray[i] = sumArray[i - 1] + (long) nums[i - 1];
        }
        this.lower = lower;
        this.upper = upper;
        mergeSort(sumArray , 0 , sumArray.length - 1 , temp);
        return count;
    }

    private void mergeSort(long[] sumArray, int start, int end , long[] temp) {
        if(start >= end){
            return;
        }
        int mid = start + (end - start)/2;
        mergeSort(sumArray , start , mid , temp);
        mergeSort(sumArray , mid + 1 , end , temp);
        merge(sumArray , start , mid , end  , temp);
    }

    private void merge(long[] sumArray, int start, int mid, int end, long[] temp) {
        int low = mid + 1;
        int high = mid + 1;
        for(int left = start ; left <= mid ; left++){
            while(low <= end && sumArray[low] - sumArray[left] < this.lower){
                low++;
            }

            while(high <= end && sumArray[high] - sumArray[left] <= this.upper){
                high++;
            }
            count = count + high - low;
        }

        int index = start;
        int tLeft = start, tRight = mid+1;
        while( tLeft<=mid && tRight<=end ){           //first while()
            if(sumArray[tLeft]>sumArray[tRight]){
                temp[index++] = sumArray[tRight++];
            } else {
                temp[index++] = sumArray[tLeft++];
            }
        }
        while(tLeft<=mid){                          //second while()
            temp[index++] = sumArray[tLeft++];
        }
        while(tRight<=end){                         //third while()
            temp[index++] = sumArray[tRight++];
        }
        for (int i = start; i <= end; i++) {       //copy
            sumArray[i] = temp[i];
        }


    }
}
