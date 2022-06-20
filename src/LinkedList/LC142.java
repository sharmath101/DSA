package LinkedList;

public class LC142 {
    ListNode slowPointer;
    ListNode fastPointer;
    public ListNode detectCycle(ListNode head) {
        boolean isCyclePresent = false;
        slowPointer = head;
        fastPointer = head;
        isCyclePresent = cyclePresent();
        if(!isCyclePresent){
            return null;
        }
        //print(slowPointer);
        ListNode entryPointer = head;

        while(slowPointer != entryPointer){
            slowPointer = slowPointer.next;
            entryPointer = entryPointer.next;
        }
        return entryPointer;

    }

    private boolean cyclePresent() {
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }
    public void print(ListNode print){
        System.out.println(print.val);
    }

}
