package Queue;

public class MyCircularDeque {
    int[] arr;
    int front;
    int rear;
    int count;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;
        count = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        front = (front - 1 + arr.length)% arr.length;
        if(isEmpty()){
            rear = front;
        }
        arr[front] = value;
        count++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        rear = (rear + 1)% arr.length;
        if(isEmpty()){
            front = rear;
        }
        arr[rear] = value;
        count++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1)% arr.length;
        count--;
        return true;

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        rear = (rear - 1 + arr.length)% arr.length;
        count--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return arr[front];

    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return arr[rear];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(count == 0){
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(count == arr.length){
            return true;
        }
        return false;
    }
}
