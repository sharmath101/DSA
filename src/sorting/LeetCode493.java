package sorting;

public class LeetCode493 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums , 0 , nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        int count = 0;
        while(start < end){
            int middle = start + (end - start)/2;
            count  =  mergeSort(nums , start , middle) + mergeSort(nums , middle + 1 , end);
            int j = middle + 1;
            for( int i = start ; i <= middle ; i++){
                long value = 2;
                while(j <= end && nums[i] > value*nums[j]){
                    j++;
                }
                count = count + (j - middle - 1);
            }
            merge(nums , start , middle ,  end);

        }
        return  count;
    }

    private void merge(int[] nums, int l, int m, int h) {
        int i=0, j=0, k=l, n1= m+1-l, n2=h-m, swaps=0 ;
        int[] left= new int[m+1-l], right = new int[h-m];

        for(int z=0; z<n1; z++) left[z]= nums[l+z];
        for(int z=0; z<n2; z++) right[z]= nums[m+1+z];

        while(i<n1 && j<n2) {
            if(left[i]<=right[j]) nums[k++] = left[i++];
            else nums[k++] = right[j++];
        }
        while(i<n1) nums[k++] = left[i++];
        while(j<n2) nums[k++] = right[j++];
    }
}
