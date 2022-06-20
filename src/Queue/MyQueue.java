package Queue;

import java.util.Stack;

public class MyQueue {
    public Stack<Integer> stk1 = new Stack<>();
    public Stack<Integer> stk2 = new Stack<>();
    int stk2Front;
    int stk1Bottom;

    public MyQueue() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stk1.empty() && stk2.empty()){
            stk2Front = x;
        }else if(stk1.empty())
        {
            stk1Bottom = x;
        }
        stk1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int ans ;
        if(stk2.isEmpty()){
            while(!stk1.empty()){
                stk2.push(stk1.pop());
            }
        }
        ans = stk2.peek();
        stk2.pop();
        if(!stk2.isEmpty()){
            stk2Front = stk2.peek();
        }
        else if(!stk1.isEmpty()){
           stk2Front = stk1Bottom;
        }
        return ans;
    }

    /** Get the front element. */
    public int peek() {
        if(!this.empty()) {
            return stk2Front;
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stk1.isEmpty() && stk2.isEmpty();
    }
}
