package LinkedList;

public class GFGFindnkthnodeinLinkedlist {
    public static int nknode(Node head, int k)
    {
        Node ans = head;
        int count = 0;
        while(ans.next != null){
            count++;
            ans = ans.next;
        }
        int index = count/k;
        ans = head;
        while(index-- > 0){
            ans = ans.next;
        }
        return ans.data;
    }
}
