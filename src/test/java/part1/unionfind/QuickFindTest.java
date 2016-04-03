package part1.unionfind;

import core.AbstractTest;
import org.junit.Test;
import utils.In;
import utils.PrintUtils;

/**
 * Created by dineshgurumurthy on 3/25/16.
 */
public class QuickFindTest extends AbstractTest {

    @Test
    public void test() {
        String fileName = getFilePath("tinyUF.txt");
        In in = new In(fileName);
        QuickFind find = new QuickFind(in);
        PrintUtils.print(find.getResults());
    }
}
