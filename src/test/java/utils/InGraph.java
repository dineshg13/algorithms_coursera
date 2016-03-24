package utils;

import org.junit.Test;

/**
 * Created by dineshgurumurthy on 3/24/16.
 */
public class InGraph {

    @Test
    public void testFileInput() {
        String filePath = "/Users/dineshgurumurthy/dev/coursera/resources/algs4-data";
        String fileName = filePath + "/" + "tinyG.txt";
        In in = new In(fileName);

        Runnable r = () -> System.out.println("Dinesh is coding");
        int lc = 0;
        while (!in.isEmpty()) {
            lc++;

            System.out.println(" line num: " + lc + ":" + in.readInt() + "->" + in.readInt());
        }
    }
}
