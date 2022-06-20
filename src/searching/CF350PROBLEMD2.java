package searching;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF350PROBLEMD2 {
    FastScanner in;
    PrintWriter out;

    static final String FILE = "";

    public void solve() {
        int n = in.nextInt();
        long k = in.nextLong();
        long arrRequired[] = new long[n];
        long arrHas[] = new long[n];
        for (int i = 0; i < n; i++) {
            arrRequired[i] = in.nextLong();
        }
        for (int i = 0; i < n; i++) {
            arrHas[i] = in.nextLong();
        }
        long low = 0, high = 2000000002;
        long value = 0;
        while(low <= high){
            long middle = low + (high - low)/2;
            if(isPossible(arrHas , arrRequired , middle , k)){
                value = middle;
                low = middle + 1;
            }else{
                high = middle - 1;
            }
        }
        out.println(value);
    }

    private boolean isPossible(long[] arrHas, long[] arrRequired, long middle , long k) {
        long count = 0;
        for(int i = 0 ; i < arrHas.length ; i++){
            long required = arrRequired[i]*middle;
            if(required > arrHas[i]){
                count = count + arrRequired[i]*middle - arrHas[i];
            }

        }
        if(count > k ){
            return false;
        }
        return true;
    }


    public void run() {
        if (FILE.equals("")) {
            in = new CF350PROBLEMD2.FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            try {
                in = new CF350PROBLEMD2.FastScanner(new FileInputStream(FILE +
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
        (new CF350PROBLEMD2()).run();
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
