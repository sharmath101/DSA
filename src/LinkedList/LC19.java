package LinkedList;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode previous = head;
        ListNode next = head;
        int count = 0;
        while(count < n){
            next = next.next;
            count++;
        }
        if(next == null){
            return head.next;
        }

        while(next.next != null){
            previous = previous.next;
            next = next.next;
        }


        previous.next = previous.next.next;
        return head;

    }
}
