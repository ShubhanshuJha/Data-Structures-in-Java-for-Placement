package list;

public class ArrayList <X> implements List <X> {
    private int pointer;
    private X[] data;
    private int SIZE;
    private int capacity;

    public ArrayList() {
        this.capacity = 6;
        this.data = (X[]) new Object[this.capacity];
        this.pointer = 0;
        this.SIZE = 0;
    }
    @Override
    public void add(X data) {
        if (this.SIZE == this.capacity) {
            this.capacity <<= 1;
            X[] temp = (X[]) new Object[this.capacity];
            for (int i = 0; i < this.SIZE; ++i)
                temp[i] = this.data[i];
            this.data = temp;
        }
        ++this.SIZE;
        this.data[this.pointer++] = data;
    }

    @Override
    public void add(int index, X data) {
        if (index > this.SIZE || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.SIZE);
        if (this.SIZE == this.capacity) {
            this.capacity <<= 1;
            X[] temp = (X[]) new Object[this.capacity];
            for (int i = 0; i < this.SIZE; ++i)
                temp[i] = this.data[i];
            this.data = temp;
        }
        ++this.SIZE;
        for (int i = this.pointer; i > index; --i)
            this.data[i] = this.data[i - 1];
        this.data[index] = data;
        this.pointer++;
    }

    @Override
    public X removeValue(X data) {
        if (this.SIZE == 0) throw new NullPointerException("List is empty");
        for (int i = 0; i < this.SIZE; ++i) {
            if (this.data[i].equals(data)) {
                --this.SIZE;
                for (int j = i; j < this.SIZE; ++j)
                    this.data[j] = this.data[j + 1];
                return data;
            }
        }
        return null;
    }

    @Override
    public X remove(int index) {
        if (index >= this.SIZE || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.SIZE);
        --this.SIZE;
        X temp = this.data[index];
        for (int i = index; i < this.SIZE; ++i)
            this.data[i] = this.data[i + 1];
        return temp;
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
        str.append(this.data[0]);
        for (int i = 1; i < this.SIZE; i++)
            str.append(", ").append(data[i]);
        str.append("]");
        return str.toString();
    }
}
