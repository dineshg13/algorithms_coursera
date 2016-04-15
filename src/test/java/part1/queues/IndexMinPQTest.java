package part1.queues;

import core.AbstractTest;
import org.junit.Test;
import utils.In;
import utils.PrintUtils;

/**
 * Created by dinesh on 4/9/2016.
 */
public class IndexMinPQTest extends AbstractTest {

    @Test
    public void test2() {
        String[] strings = {"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};

        IndexMinPQ<String> pq = new IndexMinPQ<String>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }
//        while (!pq.isEmpty()) {
//            System.out.println(strings[pq.delMin()]);
//        }
        PrintUtils.printLineBreak();

        while (!pq.isEmpty()) {
            int i = pq.delMin();
            System.out.println(i + " " + strings[i]);
        }
    }

    //   @Test
    public void test() {

        In in = new In(getFilePath("tinyPQ.txt"));
        IndexMinPQ<String> minPQ = new IndexMinPQ<>(12);
        int c = -1;
        while (!in.isEmpty()) {
            minPQ.insert(++c, in.readString());
        }
//        minPQ.insert(9);
//        minPQ.insert(3);
//        minPQ.insert(10);
//        minPQ.insert(5);
//        minPQ.insert(2);
//        minPQ.insert(4);

        PrintUtils.print(minPQ.getKeys());

        PrintUtils.printLineBreak();
        PrintUtils.print(minPQ.getPq());
        PrintUtils.printLineBreak();

        PrintUtils.print(minPQ.getQp());
//        while (!minPQ.isEmpty()) {
//            System.out.println(minPQ.delMin());
//        }
    }
}
