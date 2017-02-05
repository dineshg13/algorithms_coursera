package interview;

import utils.PrintUtils;

/**
 * Created by dinesh on 2/5/2017.
 */
public class MaxContinousSubsequence {
    private int[] ar;
    private Integer max;

    MaxContinousSubsequence(int n) {
        ar = new int[n];
    }

    public MaxContinousSubsequence(int[] ar) {
        this.ar = ar;
    }

    public Integer[] maxWindow() {
        int[] m = new int[ar.length];
        m[0] = ar[0];
        int max = ar[0];
        Integer[] sub = new Integer[ar.length];
        for (int i = 1; i < ar.length; i++) {
            m[i] = Math.max(m[i - 1] + ar[i], ar[i]);
            max = Math.max(max, m[i - 1]);
        }
        this.max = max;
        return sub;
    }

    public Integer getMax() {
        return max;
    }

    public int[] getAr() {
        return ar;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{-2, 1, -2, 4, -1, 2, 1, -5, 4};
        MaxContinousSubsequence maxContinousSubsequence = new MaxContinousSubsequence(ar);
        PrintUtils.print(maxContinousSubsequence.maxWindow());

        System.out.println("Max:" + maxContinousSubsequence.getMax());


    }

}
