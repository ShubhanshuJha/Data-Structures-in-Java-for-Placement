package list;

public interface List <X> {
	void add(X data);
	void add(int index, X data);
	X removeValue(X data);
	X remove(int index);

	boolean isEmpty();
	int size();
}

