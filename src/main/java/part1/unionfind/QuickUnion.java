package part1.unionfind;

import utils.In;

/**
 * Created by dineshgurumurthy on 3/26/16.
 */
public class QuickUnion {
    private int[] ar;

    public QuickUnion(int n) {
        ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = i;
        }
    }

    public QuickUnion(In in) {
        this(in.readInt());
        while (!in.isEmpty()) {
            union(in.readInt(), in.readInt());
        }
    }


    public int root(int m) {
        int r = m;
        while (r != ar[r]) {
            r = ar[r];
        }
        return r;
    }


    public boolean connected(int m, int n) {
        return root(m) == root(n);
    }

    public void union(int m, int n) {
        int mr = root(m);
        int nr = root(n);

        if (mr != nr) {
            ar[mr] = nr;
        }
    }

    public int[] getResults() {
        return ar;
    }

}
