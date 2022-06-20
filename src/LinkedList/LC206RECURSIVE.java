package LinkedList;

public class LC206RECURSIVE {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head.next;
        head.next = null;
        ListNode tempHead = reverseList(temp);
        temp.next = head;
        return tempHead;

    }
}
