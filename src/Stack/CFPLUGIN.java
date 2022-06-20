package Stack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class CFPLUGIN {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        String inputString = fs.next();
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < inputString.length(); i++) {
            if(!stk.isEmpty() && stk.peek() == inputString.charAt(i)){
                while(!stk.isEmpty() && stk.peek() == inputString.charAt(i)){
                    stk.pop();
                }
            }else{
                stk.push(inputString.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder("");
        while(!stk.isEmpty()){
            sb.append(stk.peek());
            stk.pop();
        }

        System.out.println(sb.reverse().toString());

    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        Integer[] nextArray(int n, boolean object) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}
