package LinkedList;

public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        int length = lists.length;
        return partition(lists , 0 , length - 1);
    }

    private ListNode partition(ListNode[] lists, int start, int end) {
        if(start == end){
            return lists[start];
        }
        if(start < end){
            int middle = (start + end)/2;
            ListNode left = partition(lists , start , middle);
            ListNode right = partition(lists , middle + 1 , end);
            return mergeTwoLists(left , right);
        }else{
            return null;
        }
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

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
