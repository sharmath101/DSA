package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class LC239 {   public int[] maxSlidingWindow(int[] nums, int k){
    Deque<Integer> deque = new LinkedList<>();
    Vector<Integer> vec = new Vector<>();

    for(int i = 0 ; i < k ; i++){
        insertAtBack(deque , i , nums);
    }


    for(int i = k ; i < nums.length ; i++){
        vec.add(nums[deque.getLast()]);
        if(deque.getLast() == i - k){
            deque.pollLast();
        }
        insertAtBack(deque , i , nums);
    }
    vec.add(nums[deque.peekLast()]);
    int [] ans = new int[vec.size()];
    for(int i = 0 ; i < ans.length ; i++){
        ans[i] = vec.get(i);
    }
    return ans;
}

    private void insertAtBack(Deque<Integer> deque, int i, int[] nums) {
        while(!deque.isEmpty() && nums[deque.getFirst()] <= nums[i]){
            deque.pollFirst();
        }
        deque.addFirst(i);
    }
}
