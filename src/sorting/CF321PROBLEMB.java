package sorting;

import java.io.*;
import java.util.*;

public class CF321PROBLEMB {
    FastScanner in;
    PrintWriter out;

    static final String FILE = "";

    public void solve() {

        int numberOfFriends = in.nextInt();
        int minimumMoneyDifference = in.nextInt();
        Friend[] friends = new Friend[numberOfFriends];
        for (int i = 0; i < numberOfFriends; i++) {
            int moneyFriendHas = in.nextInt();
            int friendShipFactor = in.nextInt();
            friends[i] = new Friend(moneyFriendHas , friendShipFactor);
        }

        Arrays.sort(friends, new Comparator<Friend>() {
            @Override
            public int compare(Friend o1, Friend o2) {
                return o1.moneyFriendHas - o2.moneyFriendHas;
            }
        });
        long[] prefixSum = new long[numberOfFriends];
        prefixSum[0] = friends[0].friendShipFactor;
        for(int i = 1 ; i < numberOfFriends ; i++){
            prefixSum[i] = prefixSum[i-1] + friends[i].friendShipFactor;
        }
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < numberOfFriends; i++) {
            int index = binarySearch(friends , i  , numberOfFriends - 1, minimumMoneyDifference + friends[i].moneyFriendHas);
            long totalFactor = friends[i].friendShipFactor;
            if(index != -1){
                totalFactor = getPreComputeSum(prefixSum , index , i);
            }
            ans = Math.max(ans , totalFactor);
        }

        out.println(ans);

    }

    private long getPreComputeSum(long[] prefixSum, int index, int start) {
        if(start > 0){
            return prefixSum[index] - prefixSum[start - 1];
        }
        return prefixSum[index];
    }

    private int binarySearch(Friend[] friends, int low, int high, int minimumMoneyDifference) {
        int result = -1;
        while(low <= high){
            int middle = low + (high-low)/2;
            if(friends[middle].moneyFriendHas < minimumMoneyDifference){
                result = middle;
                low = middle + 1;
            }else{
                high = middle - 1;
            }
        }
        return  result;
    }

    public void run() {
        if (FILE.equals("")) {
            in = new CF321PROBLEMB.FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            try {
                in = new CF321PROBLEMB.FastScanner(new FileInputStream(FILE +
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
        (new CF321PROBLEMB()).run();
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
    class Friend{
        int moneyFriendHas;
        int friendShipFactor;
        public Friend(int moneyFriendHas , int friendShipFactor){
            this.moneyFriendHas = moneyFriendHas;
            this.friendShipFactor = friendShipFactor;
        }
    }
}
