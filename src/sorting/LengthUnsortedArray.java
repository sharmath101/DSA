package sorting;

public class LengthUnsortedArray {
    int[] printUnsorted(int[] arr, int n) {
        int start = 0 ;
        int end = n - 1;
        int[] index = new int[2];

        for( start = 0 ; start < end ; start++){
            if(arr[start] > arr[start + 1]){
                break;
            }
        }
        if(start == n - 1){
            return new int[2];
        }
        for( end  = n - 1 ; end > 0 ; end--){
            if(arr[end] < arr[end-1])
                break;
        }

        int minValueInRangeStartToEnd = arr[start];
        int maxValueInRangeStartToEnd = arr[end];
        for (int i = start + 1; i <= end ; i++) {
            minValueInRangeStartToEnd = Math.min(arr[i] , minValueInRangeStartToEnd);
            maxValueInRangeStartToEnd = Math.max(arr[i] , maxValueInRangeStartToEnd);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > minValueInRangeStartToEnd){
                start = i;
                break;
            }
        }
        for (int i = n - 1; i >= n; i--) {
            if (arr[i] < maxValueInRangeStartToEnd){
                end = i;
                break;
            }
        }
        index[0] = start;
        index[1] = end;
        return  index;
    }
}
