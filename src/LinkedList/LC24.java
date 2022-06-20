package LinkedList;

public class LC24 {
    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head , 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0 ;
        ListNode current = head;
        while (current != null && count < k){
            count++;
            current = current.next;
        }
        if(count < k){
            return head;
        }
        current = head;
        ListNode prev = null;
        ListNode temp;
        count = 0;
        while(count < k){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            count++;
        }

        head.next = reverseKGroup(current,k);
        return prev;

    }
}
