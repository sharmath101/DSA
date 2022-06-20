package sorting;

import java.io.*;
import java.util.*;

public class CF44BPROBLEMB {

    FastScanner in;
    PrintWriter out;

    static final String FILE = "";

    public  int lowerBound(long arr[], long key){
        int left=0;
        int right=arr.length;
        int mid;

        while(left<right)
        {
            mid=(left+right)/2;
            if(key<=arr[mid])
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return left;
    }

    public  int upperBound(long arr[], long key){
        int left=0;
        int right=arr.length;
        int mid;

        while(left<right)
        {
            mid=(left+right)/2;
            if(key>=arr[mid])
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        return left;
    }

    public void solve() {
        int n = in.nextInt();
        long x = in.nextLong();
        long k = in.nextLong();
        long arr[] = new long[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = in.nextLong();
        }

        Arrays.sort(arr);
        long answer = 0;
        for (int i = 0; i < n; i++) {
            long temp = ((arr[i] - 1)/x) + k;
            long lowValue = temp*x;
            lowValue = Math.max(lowValue , arr[i]);
            long highValue = temp*x + x - 1;
            answer = answer + upperBound(arr , highValue) - lowerBound(arr , lowValue);
        }
        out.println(answer);
    }

    public void run() {
        if (FILE.equals("")) {
            in = new CF44BPROBLEMB.FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            try {
                in = new CF44BPROBLEMB.FastScanner(new FileInputStream(FILE +
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
        (new CF44BPROBLEMB()).run();
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
