package part1.unionfind;

import utils.In;

/**
 * Created by dineshgurumurthy on 3/24/16.
 */
public class QuickFind {

    private int[] ar;

    public QuickFind(int n) {
        ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = i;
        }
    }

    public QuickFind(In in) {
        this(in.readInt());
        while (!in.isEmpty()) {
            union(in.readInt(), in.readInt());
        }
    }


    public void union(int m, int n) {
        if (!connected(m, n)) {
            int p = ar[m];
            int r = ar[n];
            for (int i = 0; i < ar.length; i++) {
                if (ar[i] == p) {
                    ar[i] = r;
                }
            }
        }
    }

    public boolean connected(int m, int n) {
        return ar[m] == ar[n];
    }

    public int[] getResults() {
        return ar;
    }
}
