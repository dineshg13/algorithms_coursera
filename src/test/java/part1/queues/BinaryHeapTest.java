package part1.queues;

import core.AbstractTest;
import org.junit.Test;
import utils.PrintUtils;

/**
 * Created by dinesh on 4/9/2016.
 */
public class BinaryHeapTest extends AbstractTest {

    @Test
    public void test() {
        BinaryMaxHeap heap = new BinaryMaxHeap(10);
        heap.insert(3);
        heap.insert(9);
        heap.insert(10);
        heap.insert(5);
        heap.insert(2);
        heap.insert(4);
        PrintUtils.print(heap.getAr());
        PrintUtils.printLineBreak();
//
//        PrintUtils.printLineBreak();
//        PrintUtils.print(heap.getAr());
//
        while (!heap.isEmpty()) {
            System.out.println(heap.deleteMax());
        }


        String[] strings = {"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};
        BinaryMaxHeap sh = new BinaryMaxHeap(11);
        for (String s : strings) {
            sh.insert(s);
        }
        PrintUtils.printLineBreak();

        while (!sh.isEmpty()) {
            System.out.println(sh.deleteMax());
        }
    }
}
