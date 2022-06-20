package LinkedList;

public class LC138 {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node currentNode = head;
        Node cloneHead = null;
        Node newNode = null;
        while(currentNode != null){
            Node headNext = currentNode.next;
            newNode = new Node(currentNode.val);
            if(currentNode == head){
                cloneHead = newNode;
            }
            currentNode.next = newNode;
            newNode.next = headNext;
            currentNode = headNext;
        }





        currentNode = head;
        while(currentNode != null){
            if(currentNode.random != null){
                currentNode.next.random = currentNode.random.next;
            }else{
                currentNode.next.random = null;
            }

            currentNode = currentNode.next.next;
        }



        currentNode = head;
        Node cloneHeadNode = cloneHead;

        while(cloneHeadNode.next != null){
            currentNode.next = currentNode.next.next;
            currentNode = currentNode.next;
            cloneHeadNode.next = cloneHeadNode.next.next;
            cloneHeadNode = cloneHeadNode.next;
        }



        currentNode.next = currentNode.next.next;

        return cloneHead;

    }
}
