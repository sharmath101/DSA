package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ECR19C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] nse = new char[arr.length];
        char minChar = arr[arr.length - 1];
        nse[arr.length - 1] = minChar;
        for(int i = arr.length - 2 ; i >= 0 ; i--){
            if(arr[i] > minChar){
                nse[i] = minChar;
            }else{
                if(arr[i] < minChar){
                    minChar = arr[i];
                }
                nse[i] = minChar;
            }
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stk.isEmpty() && stk.peek() <= nse[i]){
                sb.append(stk.pop());
            }
            stk.push(arr[i]);
        }
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }

        System.out.println(sb);

    }

}
