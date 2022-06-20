package LinkedList;

public class LC92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null){
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;
        ListNode leftNode;
        ListNode leftNodePrev = head;
        ListNode rightNode = null;
        ListNode tempHead = head;
        int count = 0;
        while(tempHead != null && count < right){
            tempHead = tempHead.next;
            count++;
        }
        rightNode = tempHead;
        tempHead = head;
        count = 0;
        while(tempHead != null && count < left){
            leftNodePrev = tempHead;
            tempHead = tempHead.next;
            count++;
        }
        leftNode = tempHead;
        //print(head);
        //print(rightNode);
        //print(leftNode);

        // print(leftNodePrev);


        ListNode rightNodeNext = rightNode.next;
        rightNode.next = null;
        ListNode rotatedList = reverseList(leftNode);
        //print(rotatedList);

        leftNodePrev.next = rotatedList;
        leftNode.next = rightNodeNext;

        return head.next;

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

    public void print(ListNode printNode){
        System.out.println(printNode.val);
    }
}
