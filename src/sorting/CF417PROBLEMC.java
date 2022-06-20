package sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF417PROBLEMC {
    FastScanner in;
    PrintWriter out;

    static final String FILE = "";

    public void solve() {
        int n = in.nextInt();
        long suverniors = in.nextLong();
        long arr[] = new long[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = in.nextLong();
        }
        int low = 0 ;
        int high = n;
        int possibleValue = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(arr , mid) <= suverniors){
                possibleValue = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        out.print(possibleValue + " " + isPossible(arr , possibleValue));
    }

    private long isPossible(long[] arr , int mid) {
        long costTillKSuverniors = 0;
        int n = arr.length;
        long totalCost[] = new long[n];
        for(int i = 0 ; i < n ; i++){
            totalCost[i] = (long)(arr[i] + (i + 1)*mid);
        }
        Arrays.sort(totalCost);
        for(int i = 0 ; i < mid ; i++){
            costTillKSuverniors += totalCost[i];
        }
        return  costTillKSuverniors;
    }

    public void run() {
        if (FILE.equals("")) {
            in = new CF417PROBLEMC.FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            try {
                in = new CF417PROBLEMC.FastScanner(new FileInputStream(FILE +
                        ".in"));
                out = new PrintWriter(new FileOutputStream(FILE +
                        ".out"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        solve();
        out.close();
    }

    public static void main(String[] args) {
        (new CF417PROBLEMC()).run();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }
    }
}
