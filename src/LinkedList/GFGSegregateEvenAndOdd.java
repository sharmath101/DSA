package LinkedList;

public class GFGSegregateEvenAndOdd {
    Node divide(int N, Node head){
        Node evenStart = null;
        Node oddStart = null;
        Node evenEnd = null;
        Node oddEnd = null;
        Node currentNode = head;

        while(currentNode != null){
            if((currentNode.data%2 == 0)){
                if(evenStart == null){
                    evenStart = currentNode;
                    evenEnd = currentNode;
                }else{
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }
            }else{
                if(oddStart == null){
                    oddStart = currentNode;
                    oddEnd = currentNode;
                }else{
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }

            currentNode = currentNode.next;
        }



        if(oddStart == null || evenStart == null){
            return head;
        }
        evenEnd.next = oddStart;
        oddEnd.next = null;
        head = evenStart;
        return head;
    }
}
