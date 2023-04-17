package queue;
import queue.Queue;

public class LinkedList <X> implements Queue <X> {
    private Node <X> front;
    private Node <X> back;
    private int SIZE;
    public LinkedList() {
        this.front = null;
        this.back = null;
        this.SIZE = 0;
    }

    @Override
    public void offer(X data) {
        enqueue(data);
    }

    @Override
    public X poll() {
        return dequeue();
    }

    @Override
    public void enqueue(X data) {
        ++this.SIZE;
        Node <X> newNode = new Node<> (data);
        if (this.front == null) {
            this.front = newNode;
            this.back = newNode;
        } else {
            this.back.next = newNode;
            newNode.prev = this.back;
            this.back = newNode;
        }
    }

    @Override
    public X dequeue() {
        if (this.front == null)
            throw new NullPointerException("Queue is empty");
        --this.SIZE;
        X data = this.front.data;
        this.front = this.front.next;
        this.front.prev = null;

        if (this.front == null)
            this.back = null;
        return data;
    }

    @Override
    public int size() {
        return this.SIZE;
    }

    @Override
    public boolean isEmpty() {
        return this.SIZE == 0;
    }
    public String toString() {
        if (this.front == null)
            return "[]";
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.front.data);
        Node <X> temp = this.front.next;
        while (temp != null) {
            sb.append(", ").append(temp.data);
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

class Node <X> {
    X data;
    Node <X> next;
    Node <X> prev;
    public Node(X data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
