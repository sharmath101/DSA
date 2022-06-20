package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LEETCODE71 {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        String[] result = path.split("/");
        for(String s : result){
            if(s.equals("")){
                continue;
            }
            if(s == ".." && !stk.isEmpty()){
                stk.pop();
            }else if(s == "." || s == ""){
                continue;
            }else{
                stk.push(s);
            }
        }
        List<String> list = new ArrayList<>(stk);
        return "/" +  String.join("/" , list);
    }
}
