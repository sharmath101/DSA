package LinkedList;

public class LC147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode previousNode = dummy;
        ListNode nextNode = null;

        while(head != null){
            nextNode = head.next;

            if(previousNode.val >= head.val){
                previousNode = dummy;
            }

            while(previousNode.next != null && previousNode.next.val < head.val){
                previousNode = previousNode.next;
            }

            head.next = previousNode.next;
            previousNode.next = head;
            head = nextNode;
        }

        return dummy.next;

    }
}
