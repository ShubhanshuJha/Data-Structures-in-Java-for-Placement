package queue;

public interface Queue <X> {
    void offer(X data);
    X poll();
    void enqueue(X item);
    X dequeue();
    int size();
    boolean isEmpty();
}
