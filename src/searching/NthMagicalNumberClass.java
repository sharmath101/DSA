package searching;

public class NthMagicalNumberClass {

    public int nthMagicalNumber(int n, int a, int b) {

        int MOD = 1_000_000_007;
        int lcm = (a*b)/gcd(a, b);

        long start = 0;
        long end = ((long)n*Math.min(a , b));
        while(start < end){
            long middle = (start + end)/2;
            if(middle/a + middle/b - middle/lcm < n){
                start = middle + 1;
            }else{
                end = middle;
            }
        }
        return (int) (start%MOD);
    }
    int gcd(int a , int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a , a);
    }

}
