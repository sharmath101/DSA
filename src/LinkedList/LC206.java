package LinkedList;

public class LC206 {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while(current != null){
            ListNode nextTemp = current.next;
            current.next = previous;
            previous = current;
            current = nextTemp;
        }

        return previous;

    }
}
