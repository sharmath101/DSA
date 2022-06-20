package Stack;

import java.util.Stack;

public class LEETCODE1003 {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char inputChar : s.toCharArray()){
            if(inputChar == 'c'){
                if(stk.isEmpty() || stk.pop() != 'b') return false;
                if(stk.isEmpty() || stk.pop() != 'a') return false;
            }else {
                stk.push(inputChar);
            }
        }
        return stk.isEmpty();
    }

}
