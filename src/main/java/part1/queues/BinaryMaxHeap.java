package part1.queues;

/**
 * Created by dinesh on 4/6/2016.
 */
public class BinaryMaxHeap<Key extends Comparable<Key>> {
    private int n;
    private Key[] ar;

    public BinaryMaxHeap(int capacity) {
        ar = (Key[]) new Comparable[capacity];
    }

    public void insert(Key x) {
        ar[++n] = x;
        swim(n);

    }

    public boolean less(int j, int k) {
        return ar[j] != null && ar[j].compareTo(ar[k]) <= 0;
    }

    public Key[] getAr() {
        return ar;
    }

    private void swim(int k) {
        while (k > 1 && !less(k, k / 2)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    private void sink(int k) {

        while (2 * k < n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;

        }
    }


    public Key deleteMax() {
        Key r = ar[1];
        swap(1, n);
        ar[n] = null;
        n--;
        sink(1);
        return r;
    }

    private void swap(int j, int k) {
        Key temp = ar[k];
        ar[k] = ar[j];
        ar[j] = temp;
    }


}
