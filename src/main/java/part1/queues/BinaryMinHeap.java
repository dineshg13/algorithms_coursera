package part1.queues;

/**
 * Created by dinesh on 4/6/2016.
 */
public class BinaryMinHeap<Key extends Comparable<Key>> {
    private int n;
    private Key[] keys;

    public BinaryMinHeap(int capacity) {
        keys = (Key[]) new Comparable[capacity];
    }

    public void insert(Key x) {
        keys[++n] = x;
        swim(n);

    }

    public boolean greater(int j, int k) {
        return keys[j] != null && keys[j].compareTo(keys[k]) >= 0;
    }

    public Key[] getKeys() {
        return keys;
    }

    private void swim(int k) {
        while (k > 1 && !greater(k, k / 2)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    private void sink(int k) {

        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            swap(k, j);
            k = j;

        }
    }


    public Key deleteMin() {
        Key r = keys[1];
        swap(1, n);
        keys[n] = null;
        n--;
        sink(1);
        return r;
    }

    private void swap(int j, int k) {
        Key temp = keys[k];
        keys[k] = keys[j];
        keys[j] = temp;
    }


}
