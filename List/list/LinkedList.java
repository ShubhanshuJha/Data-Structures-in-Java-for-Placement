package list;

public class LinkedList <X> implements List<X> {
	private Node<X> head, tail;
	private int SIZE;
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.SIZE = 0;
	}

	@Override
	public void add(X data) {
		++this.SIZE;
		Node<X> newNode = new Node<>(data);
		if (this.head == null) {
			this.head = newNode;
		} else {
			this.tail.next = newNode;
		}
		this.tail = newNode;
	}

	@Override
	public void add(int index, X data) {
		if (index > this.SIZE || index < 0)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.SIZE);
		++this.SIZE;
		Node<X> newNode = new Node<>(data);
		if (index == 0) {
			newNode.next = this.head;
			this.head = newNode;
		} else if (index == this.SIZE - 1) {
			this.tail.next = newNode;
			this.tail = newNode;
		} else {
			Node<X> temp = this.head;
			for (int i = 0; i < index - 1; ++i)
				temp = temp.next;
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	@Override
	public X removeValue(X data) {
		if (this.SIZE == 0) throw new NullPointerException("List is empty");
		if (this.head.data.equals(data)) {
			--this.SIZE;
			this.head = this.head.next;
			return data;
		} else if (this.tail.data.equals(data)) {
			--this.SIZE;
			Node<X> temp = this.head;
			for (; temp.next != this.tail; temp = temp.next);
			temp.next = null;
			this.tail = temp;
			return data;
		} else {
			Node<X> temp = this.head;
			for (; temp.next != null; temp = temp.next) {
				if (temp.next.data.equals(data)) {
					--this.SIZE;
					temp.next = temp.next.next;
					return data;
				}
			}
			return null;
		}
	}

	@Override
	public X remove(int index) {
		if (this.SIZE == 0) throw new NullPointerException("List is empty");
		if (index >= this.SIZE || index < 0)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.SIZE);
		--this.SIZE;
		Node<X> removed;
		if (index == 0) {
			removed = this.head;
			this.head = this.head.next;
			return removed.data;
		} else if (index == 1) {
			removed = this.head.next;
			this.head.next = this.head.next.next;
			return removed.data;
		} else if (index == this.SIZE - 1) {
			Node<X> temp = this.head;
			for (int i = 0; i < index - 1; ++i)
				temp = temp.next;
			removed = temp.next;
			temp.next = null;
			this.tail = temp;
			return removed.data;
		} else {
			Node<X> temp = this.head;
			for (int i = 0; i < index - 1; ++i)
				temp = temp.next;
			removed = temp.next;
			temp.next = temp.next.next;
			return removed.data;
		}
	}

	@Override
	public boolean isEmpty() {
		return this.SIZE == 0;
	}

	@Override
	public int size() {
		return this.SIZE;
	}

	public String toString() {
		if (this.SIZE == 0) return "[]";
		StringBuilder str = new StringBuilder("[");
		str.append(this.head.data);
		for (Node<X> temp = this.head.next; temp != null; temp = temp.next)
			str.append(", ").append(temp.data);
		str.append("]");
		return str.toString();
	}
}

class Node <X> {
	X data;
	Node <X> next;
	Node(X data) {
		this.data = data;
		this.next = null;
	}
}
