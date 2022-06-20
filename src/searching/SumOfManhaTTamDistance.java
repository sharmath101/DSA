package searching;

import java.util.Arrays;

public class SumOfManhaTTamDistance {
    public static void main(String[] args) {
        int x[] = { -1, 1, 3, 2 };
        int y[] = { 5, 6, 5, 3 };
        int n = x.length;

        System.out.println(totaldistancesum(x,y, n));
    }

    //distance = abs(x1 - x2) + abs(y1 - y2);
    //abs can open in both direction
    //Sort the array
    //for x array x1 , x2 , x3 , x4 -> x2 + x3 + x4 - 3*x1 for 1st Index
    private static int totaldistancesum(int[] x, int[] y, int n) {
        Arrays.sort(x);
        Arrays.sort(y);
        return distance(x , n) + distance(y , n);
    }

    private static int distance(int[] x, int n) {
        int totalSum = 0;
        int resultSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += x[i];
        }

        for (int i = 0; i < n; i++) {
            totalSum -= x[i];
            resultSum += totalSum - x[i]*(n - 1 - i);
        }

        return  resultSum;

    }


}
