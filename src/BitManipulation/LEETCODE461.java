package BitManipulation;

public class LEETCODE461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
