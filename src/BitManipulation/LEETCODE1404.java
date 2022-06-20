package BitManipulation;

public class LEETCODE1404 {
    public int numSteps(String s) {
        int result = 0;
        int carry = 0;
        for (int i = s.length() - 1; i >= 1 ; i--) {
            if(s.charAt(i) - '0' + carry == 1){
                carry = 1;
                result = result + 2;

            }else{
                result++;
            }
        }
        return result + carry;
    }
}
