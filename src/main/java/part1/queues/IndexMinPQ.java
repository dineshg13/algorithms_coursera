package part1.queues;

import java.util.NoSuchElementException;

/**
 * Created by dinesh on 4/9/2016.
 */
public class IndexMinPQ<Key extends Comparable<Key>> {

    private Key[] keys;
    private int[] pq;
    private int[] qp;
    private static final int maxN = 1000;
    private int n;
  /*
      keys[i] is the priority of i
    – pq[i]   is the index of the key in heap position i
    – qp[i]   is the heap position of the key with index i
     */

    public IndexMinPQ(int capacity) {

        keys = (Key[]) new Comparable[maxN + 1];    // make this of length maxN??
        pq = new int[capacity + 1];
        qp = new int[capacity];
    }

    public void insert(Key key) {
        insert(n, key);
    }

    public Key[] getKeys() {
        return keys;
    }

    public Key getKey(int v) {
        if (contains(v))
            return keys[v];
        return null;
    }

    public void insert(int k, Key key) {

        if (contains(k))
            throw new IllegalArgumentException("index is already in the priority queue");
        n++;
        keys[k] = key;
        qp[k] = n;
        pq[n] = k;

        swim(n);

    }

    public int[] getPq() {
        return pq;
    }

    public int[] getQp() {
        return qp;
    }

    public boolean less(int j, int k) {
        return keys[pq[j]] != null && keys[pq[j]].compareTo(keys[pq[k]]) <= 0;
    }


    //swim
    private void swim(int k) {

        while (k > 1 && !less(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }

    }

    private void swap(int j, int k) {
        int temp = pq[j];
        pq[j] = pq[k];
        pq[k] = temp;

        qp[pq[j]] = j;
        qp[pq[k]] = k;

    }

    public void change(int k, Key key) {
        keys[k] = key;
        swim(qp[k]); //qp has the index
        sink(qp[k]);

    }

    public void decreaseKey(int i, Key key) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) <= 0)
            throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
        keys[i] = key;
        swim(qp[i]);
    }

    public void increaseKey(int i, Key key) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) >= 0)
            throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
        keys[i] = key;
        sink(qp[i]);
    }

    public boolean contains(int i) {
        return keys[i] != null;
    }


    public int delMin() {
        int k = pq[1];
        swap(1, n);
        keys[k] = null;

        qp[k] = 0;
        pq[n] = -1;

        n--;
        sink(1);
        return k;
    }

    public Key delMinKey() {
        int k = pq[1];
        swap(1, n);
        Key r = keys[k];
        keys[k] = null;

        qp[k] = 0;
        pq[n] = -1;

        n--;
        sink(1);
        return r;
    }

    private void sink(int k) {

        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && !less(j, j + 1))
                j++;
            if (less(k, j))
                break;
            swap(j, k);
            k = j;

        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    int size() {
        return n;
    }

}
