package LinkedList;

public class LC62 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null ){
            return head;
        }
        int count  = 0;
        ListNode tempHead = head;
        while(tempHead != null){
            tempHead = tempHead.next;
            count++;
        }

        k = k%count;
        ListNode fpart, lpart;
        lpart = head;
        for(int i = 1; i < count - k; i++){
            head = head.next;
        }
        fpart = head.next;
        head.next = null;
        if(fpart == null){
            return lpart;
        }
        ListNode node = fpart;
        while(node.next != null){
            node = node.next;
        }

        node.next = lpart;
        return  fpart;

    }
}
