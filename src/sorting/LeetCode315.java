package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode315 {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Data[] numsData = new Data[nums.length];
        int arr[] = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            Data value = new Data(i ,nums[i]);
            numsData[i] = value;
        }

        int[] res = new int[nums.length];
        Arrays.fill(res, 0);

        mergeSort(numsData, 0, nums.length-1, res);

        List<Integer> result = new ArrayList<>();
        for (int i : res) result.add(i);

        return result;


    }

    private void mergeSort(Data[] numsData, int start, int end, int[] res) {

        if (start < end) {
            int mid = start + (end-start)/2;
            mergeSort(numsData, start, mid, res);
            mergeSort(numsData, mid+1, end, res);
            merge(numsData, start, mid, end, res);
        }
    }

    private void merge(Data[] numsData, int start, int mid, int end, int[] res) {
        Data[] tempData = new Data[end - start + 1];
        int left = start;
        int right = mid + 1;
        int k = 0;
        int count = 0;
        while(left <= mid && right <= end){
            if(numsData[left].value <= numsData[right].value){
                res[numsData[left].index] += count;
                tempData[k++] = numsData[left++];
            }else{
                count++;
                tempData[k++] = numsData[right++];

            }
        }
        while(left <= mid){
            res[numsData[left].index] += count;
            tempData[k++] = numsData[left++];
        }

        while(right <= end){
            tempData[k++] = numsData[right++];
        }

        for (int i = start, ti = 0; i <= end; i++, ti++) numsData[i] = tempData[ti];


    }


    public class Data{
        int index;
        int value;
        public Data(int index , int value){
            this.index = index;
            this.value = value;
        }

    }

}
