package LinkedList;

public class LC238 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode current = evenHead;


        while(current != null && current.next != null){
            oddHead.next = current.next;
            oddHead  = oddHead.next;
            current.next = oddHead.next;
            current = current.next;
        }

        oddHead.next = evenHead;
        return head;

    }
}
