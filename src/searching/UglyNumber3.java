package searching;

import java.io.File;

public class UglyNumber3 {
    static int MAX_ANS = (int) 2e9;
    public int nthUglyNumber(int n, int a, int b, int c) {
        int result = 0;
        int start = 0;
        int end = MAX_ANS;
        while(start <= end){
            int middle = start + (end - start)/2;
            int solution = getInclusivePrinciple(middle , a , b , c);
            if(solution < n){
                start = middle + 1;
            }else if(solution > n){
                end = middle - 1;
            }else{
                result = middle;
                end = middle - 1;
            }
        }
        return result;
    }


    private int getInclusivePrinciple(long middle, long a, long b, long c) {

        return (int) (middle/a + middle/b + middle/c -middle/lcm(a,b) - middle/lcm(b,c) - middle/lcm(a,c) + middle/lcm(a , lcm(b , c)));
    }

    private long gcd(long a , long b){
        if(a == 0){
            return b;
        }
        return gcd(b%a , a);
    }

    private long lcm(long a , long b){
        return (a*b)/(gcd(a,b));
    }
}
