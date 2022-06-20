package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF371A {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder outPut = new StringBuilder();
        HashMap<String , Integer> map = new HashMap<>();
        int t = fs.nextInt();
        for (int i = 0; i < t; i++) {
            char c = fs.next().charAt(0);
            long x = fs.nextLong();
            StringBuilder result = new StringBuilder(19);
            for(int j = 0 ; j < 19 ; j++){
                long modulo = x%10;
                if(modulo % 2 == 0){
                    result.append("0");
                }else{
                    result.append("1");
                }
                x = x/10;
            }
            String resultString = result.reverse().toString();
            if(c == '+'){
                map.put(resultString , map.getOrDefault(resultString , 0) + 1);
            }else if(c == '-'){
                map.put(resultString , map.getOrDefault(resultString , 0) - 1);
            }else{
                outPut.append(map.getOrDefault(resultString , 0)).append("\n");
            }


        }

        System.out.println(outPut);

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
