package sorting;

public class MaximumIndex {

    static int maxIndexDiff(int arr[], int n) {

        int leftMin[] = new int[n];
        int rightMax[] = new int[n];
        int maxDiff = -1;
        leftMin[0] = arr[0];
        rightMax[n - 1] = arr[n - 1];
        for(int i = 1 ; i < n ; i++){
            leftMin[i] = Math.min(arr[i] , leftMin[i - 1] );

        }

        for(int i = n - 2 ; i >= 0 ; i--){
            rightMax[i] = Math.max(arr[i] , rightMax[i + 1]);
        }
        int j = 0;
        int i = 0;
        while(j < n && i < n) {
            if(leftMin[i] <= rightMax[j]){
                maxDiff = Math.max(maxDiff , j - i);
                j++;
            }else{
                i++;
            }
        }



        return maxDiff;
    }
}
