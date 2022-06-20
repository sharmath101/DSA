package LinkedList;

public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0 , head);
        ListNode slowPointer = dummyNode;
        slowPointer.next = head;
        ListNode fastPointer = head;


        while(fastPointer != null){
            while(fastPointer.next != null && fastPointer.val == fastPointer.next.val){
                fastPointer = fastPointer.next;
            }

            if(slowPointer.next == fastPointer){
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }else{
                slowPointer.next = fastPointer.next;
                fastPointer= slowPointer.next;
            }


        }
        return dummyNode.next;

    }
}
