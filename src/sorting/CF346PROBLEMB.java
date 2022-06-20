package sorting;
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class CF346PROBLEMB {
    FastScanner in;
    PrintWriter out;

    static final String FILE = "";

    public void solve() {
        int n = in.nextInt();
        int m = in.nextInt();

        ArrayList[] regions = new ArrayList[m];
        for (int i = 0; i < m; ++i){
            regions[i] = new ArrayList<Candidate>();
        }
        for (int i = 0; i < n; i++) {
            String s = in.next();
            int num = in.nextInt() - 1;
            int point = in.nextInt();

            regions[num].add(new Candidate(point , s));

        }

        for (int i = 0; i < m; i++) {
            Collections.sort(regions[i], new Comparator<Candidate>() {
                public int compare(Candidate a , Candidate b){
                    return b.point - a.point;
                }
            });
            ArrayList<Candidate> candidatesAtIndex = regions[i];
            if(candidatesAtIndex.size() > 2 && candidatesAtIndex.get(1).getPoint() == candidatesAtIndex.get(2).getPoint()){
                    out.println("?");
            }else{
                out.println(candidatesAtIndex.get(0).getName() + " " + candidatesAtIndex.get(1).getName());
            }
        }
    }

    public void run() {
        if (FILE.equals("")) {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            try {
                in = new FastScanner(new FileInputStream(FILE +
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
        (new CF346PROBLEMB()).run();
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

    class Candidate{
        public int point;
        public String name;
        public Candidate(int point , String name){
            this.point = point;
            this.name = name;
        }
        public String getName(){
            return this.name;
        }

        public int getPoint(){
            return  this.point;
        }
    }


}



