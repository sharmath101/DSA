package LinkedList;

public class LC234 {
    public boolean isPalindrome(ListNode head) {
        ListNode tempHead = head;
        ListNode mid = middleNode(head);

        ListNode reverse = reverseList(mid);
        while(reverse != null){
            if(reverse.val != tempHead.val){
                return false;
            }

            reverse = reverse.next;
            tempHead = tempHead.next;
        }

        return true;

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
