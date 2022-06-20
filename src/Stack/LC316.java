package Stack;

import java.util.Stack;

public class LC316 {
    public String removeDuplicateLetters(String s) {
        int [] frequency = new int[26];
        int n = s.length();
        char [] charArray = s.toCharArray();
        boolean[] present = new boolean[26];
        Stack<Character> stk = new Stack<>();
        for(char charAtPosition : charArray){
            frequency[charAtPosition - 'a']++;
        }

        for(char charAtPosition : charArray){
            int index = charAtPosition - 'a';
            frequency[index]--;
            if(present[index]){
                continue;
            }
            while(!stk.isEmpty() && charAtPosition < stk.peek() && frequency[stk.peek() -'a'] > 0){
                present[stk.pop() -'a'] = false;
            }


            stk.push(charAtPosition);
            present[index] = true;
        }


        StringBuilder sb = new StringBuilder("");
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        String res = sb.reverse().toString();
        return res;
    }
}
