package sorting;

public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] resultTantArray = new  int[m + n];
        int i = 0 ;
        int j = 0;
        int k = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                resultTantArray[k++] = nums1[i];
                i++;
            }else{
                resultTantArray[k++] = nums2[j];
                j++;
            }
        }

        while(i < m){
            resultTantArray[k++] = nums1[i++];
        }

        while(j < n){
            resultTantArray[k++] = nums2[j++];
        }

        i = 0;
        j = 0;
        k = 0;
        while(i < m + n){
            nums1[i++] = resultTantArray[k++];
        }


    }
}
