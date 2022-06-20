package BitManipulation;

public class LEETCODE231 {
    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
}
