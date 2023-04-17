import queue.Queue;
import queue.LinkedList;
public class Main {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q);

		q.offer(4);
		q.offer(5);

		System.out.println(q.dequeue());
		System.out.println(q.poll());
		System.out.println(q);
	}
}

