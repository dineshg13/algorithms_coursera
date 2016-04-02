package part1.unionfind;

import org.junit.Assert;
import org.junit.Test;
import utils.In;
import utils.PrintUtils;

/**
 * Created by dineshgurumurthy on 3/26/16.
 */
public class QuickUnionTest {

    @Test
    public void test() {
        String filePath = "/Users/dineshgurumurthy/dev/coursera/resources/algs4-data/";
        String fileName = filePath + "tinyUF.txt";
        In in = new In(fileName);
        QuickUnion find = new QuickUnion(in);
        PrintUtils.print(find.getResults());

        Assert.assertTrue(find.connected(0, 5));
        Assert.assertTrue(find.connected(0, 7));
        Assert.assertTrue(find.connected(7, 5));
        Assert.assertTrue(find.connected(6, 5));
        Assert.assertTrue(find.connected(2, 6));


        Assert.assertTrue(find.connected(3, 9));
        Assert.assertTrue(find.connected(8, 4));
        Assert.assertTrue(find.connected(3, 8));
        Assert.assertTrue(find.connected(9, 9));

        Assert.assertFalse(find.connected(0, 8));
        Assert.assertFalse(find.connected(5, 8));
        Assert.assertFalse(find.connected(6, 9));

    }
}
