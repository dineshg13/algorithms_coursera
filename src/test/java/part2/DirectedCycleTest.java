package part2;

import core.AbstractTest;
import org.junit.Test;
import part2.directedGraph.Digraph;
import part2.directedGraph.DirectedCycle;
import utils.In;
import utils.PrintUtils;

/**
 * Created by dinesh on 4/3/2016.
 */
public class DirectedCycleTest extends AbstractTest {

    @Test
    public void test() {

        String filePath = getFilePath("tinyDG.txt");
        Digraph digraph = new Digraph(new In(filePath));
        System.out.println("DirectedGraph:" + digraph);
        System.out.println("DAG:" + digraph.debugString());

        DirectedCycle directedCycle = new DirectedCycle(digraph);
        System.out.println("is Cycle Present:" + directedCycle.hasCycle());

        PrintUtils.print(directedCycle.getCycle());

    }
}
