package searching;

import java.util.Arrays;
import java.util.Scanner;

public class MaximizeTheDifference {


    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while(testCase-- > 0){
            int lengthOfArray = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[lengthOfArray];
            for (int i = 0; i < lengthOfArray; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            k = Math.min(k , lengthOfArray - k);
            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < k; i++) {
                sumA = sumA + arr[i];
            }

            for (int i = k; i < lengthOfArray; i++) {
                sumB = sumB + arr[i];
            }

            System.out.println(sumB - sumA);
        }
    }
}
