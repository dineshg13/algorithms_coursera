package part1.unionfind;

import org.junit.Test;
import utils.In;
import utils.PrintUtils;

/**
 * Created by dineshgurumurthy on 3/25/16.
 */
public class QuickFindTest {

    @Test
    public void test() {
        String filePath = "/Users/dineshgurumurthy/dev/coursera/resources/algs4-data/";
        String fileName = filePath + "tinyUF.txt";
        In in = new In(fileName);
        QuickFind find = new QuickFind(in);
        PrintUtils.print(find.getResults());
    }
}
