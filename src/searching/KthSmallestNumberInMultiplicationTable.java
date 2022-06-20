package searching;

public class KthSmallestNumberInMultiplicationTable {
    public int countNumberLessThenTarget(int value , int m , int n , int k){
        int count = 0;
        for(int i = 1 ; i <= m ; i++){
            count += Math.min(value/i , n);
        }

        return  count;

    }

    public int findKthNumber(int m, int n, int k){
        int low = 1;
        int high = m*n;
        int ans = 1;
        while(low <= high){
            int middle = low + (high - low)/2;
            int count = countNumberLessThenTarget(middle , m , n , k);
            if(count < k){
                low = middle + 1;
            }else if(count > k){
                high = middle - 1;
            }
            else{
                ans =  middle;
                high = middle - 1;

            }
        }
        return  ans;
    }
}
