package LinkedList;

public class LC143 {


    public void reorderList(ListNode head) {
        ListNode tempHead = head;
        ListNode middle = middleNode(head);
        ListNode reverse = reverseList(middle);



        while(reverse.next  != null){
            ListNode reverseNext = reverse.next;
            ListNode frontNext = tempHead.next;
            // printNode(reverseNext);
            //printNode(frontNext);
            tempHead.next = reverse;
            reverse.next = frontNext;
            reverse = reverseNext;
            tempHead = frontNext;
        }


    }
    public void printNode (ListNode print){
        System.out.println(print.val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

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
