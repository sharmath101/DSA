package LinkedList;

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode firstHead = l1;
        ListNode secondHead = l2;
        ListNode currentNode = dummyHead;
        int carry = 0;

        while(firstHead != null || secondHead != null ){
            int x = (firstHead != null) ? firstHead.val : 0;
            int y = (secondHead != null) ? secondHead.val : 0;
            int sum = x + y + carry;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            carry = sum/10;

            if(firstHead!= null){
                firstHead = firstHead.next;
            }
            if(secondHead != null){
                secondHead = secondHead.next;
            }


        }

        if(carry > 0){
            currentNode.next = new ListNode(carry);
        }


        return dummyHead.next;

    }
}
