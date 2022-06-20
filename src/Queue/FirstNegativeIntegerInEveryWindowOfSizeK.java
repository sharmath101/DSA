package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Vector;

public class FirstNegativeIntegerInEveryWindowOfSizeK {
    public long[] printFirstNegativeInteger(long nums[], int n, int k)
    {
        Deque<Long> deque = new LinkedList<>();
        Vector<Long> vec = new Vector<>();

        for(int i = 0 ; i < k ; i++){
            insertAtBack(deque , i , nums);
        }


        for(int i = k ; i < nums.length ; i++){
            vec.add(nums[(int)deque.getLast()]);
            if(deque.getLast() == i - k){
                deque.pollLast();
            }
            insertAtBack(deque , i , nums);
        }
        vec.add(nums[deque.peekLast()]);
        long [] ans = new long[vec.size()];
        for(int i = 0 ; i < ans.length ; i++){
            ans[i] = vec.get(i);
        }
        return ans;
    }

    private void insertAtBack(Deque<Long> deque, int i, long[] nums) {
        while(!deque.isEmpty() && nums[deque.getFirst()] <= nums[i]){
            deque.pollFirst();
        }
        deque.addFirst();
    }
}
