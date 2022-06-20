package sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF218PROBLEMC {
    PrintWriter out;
    FastScanner in;
    static final String FILE = "";

    public void solve() {
        String burgerString = in.next();
        long nb = in.nextLong();
        long ns = in.nextLong();
        long nc = in.nextLong();
        long pb = in.nextLong();
        long ps = in.nextLong();
        long pc = in.nextLong();
        long money = in.nextLong();
        long rb = 0;
        long rs = 0;
        long rc = 0;
        for (int i = 0; i < burgerString.length(); i++) {
            char charAt = burgerString.charAt(i);
            if(burgerString.charAt(i) == 'B'){
                rb++;
            }else if(burgerString.charAt(i) == 'S'){
                rs++;
            }else{
                rc++;
            }
        }

        long low = 0 ;
        long high = (long) 1e13;
        long count = 0;
        while(low <= high){
            long mid  = low + (high-low)/2;
            long value = Math.max( 0 , mid*rb - nb)*pb + Math.max( 0 , mid*rs - ns)*ps + Math.max(0 , mid*rc - nc)*pc;
            if(value <= money){
                count = mid;
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        out.println(count);

    }

    public void run() {
        if (FILE.equals("")) {
            in = new CF218PROBLEMC.FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            try {
                in = new CF218PROBLEMC.FastScanner(new FileInputStream(FILE +
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
        (new CF218PROBLEMC()).run();
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
