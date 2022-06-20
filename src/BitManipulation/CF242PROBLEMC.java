package BitManipulation;

import java.util.Scanner;

public class CF242PROBLEMC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < length; i++) {
            int input = sc.nextInt();
            ans = ans^input;
        }
        int arr[] = new int[length + 1];
        for (int i = 1; i <= length ; i++) {
            arr[i] = i^arr[i - 1];
        }
        for(int i = 1; i <= length ; i++){
            ans = ans^arr[length%i];
            if(((length/i)&1) != 0){
                ans = ans^arr[i - 1];
            }
        }
        System.out.println(ans);
    }
}
