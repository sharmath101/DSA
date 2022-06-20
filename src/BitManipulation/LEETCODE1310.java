package BitManipulation;

public class LEETCODE1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int xorPrefix[] = new int[arr.length];
        xorPrefix[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            xorPrefix[i] = arr[i]^xorPrefix[i - 1];
        }
        int resultArray[] = new int[queries.length];
        for(int i = 0 ; i < queries.length ; i++){
            resultArray[i] = xorPrefix[queries[i][0]]^xorPrefix[queries[i][1]]^arr[queries[i][0]];
        }
        return resultArray;
    }
}
