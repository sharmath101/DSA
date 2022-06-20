package sorting;

import java.util.Arrays;

public class SegragteEvenOddNumbers {
    void segregateEvenOdd(int arr[], int n) {
        Arrays.sort(arr);
        int[] result = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2 == 0){
                result[start++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2 == 1){
                result[start++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }

    }
}
