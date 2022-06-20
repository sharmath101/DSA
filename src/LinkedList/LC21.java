package LinkedList;

public class LC21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = null;
        ListNode headFirst = l1;
        ListNode headSecond = l2;
        ListNode tail = null;
        if(headFirst.val <= headSecond.val){
            head = headFirst;
            tail = headFirst;
            headFirst = headFirst.next;
        }else{
            head = headSecond;
            tail = headSecond;
            headSecond = headSecond.next;
        }

        while(headFirst != null && headSecond != null){
            if(headFirst.val <= headSecond.val){

                tail.next = headFirst;
                tail = tail.next;
                headFirst = headFirst.next;
            }else{

                tail.next = headSecond;
                tail = tail.next;
                headSecond = headSecond.next;
            }
        }

        if(headFirst != null){
            tail.next = headFirst;
        }

        if(headSecond != null){
            tail.next = headSecond;
        }

        return  head;


    }
}
