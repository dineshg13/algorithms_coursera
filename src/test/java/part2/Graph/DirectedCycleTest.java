package part2.Graph;

import core.AbstractTest;
import org.junit.Assert;
import org.junit.Test;
import part2.directedGraph.Digraph;
import part2.directedGraph.DirectedCycle;
import utils.In;

/**
 * Created by dinesh on 4/3/2016.
 */
public class DirectedCycleTest extends AbstractTest {

    @Test
    public void test() {

        Digraph digraph = new Digraph(new In(getFilePath("tinyDG.txt")));
        Digraph dag = new Digraph(new In(getFilePath("tinyDAG.txt")));

        System.out.println("DirectedGraph:" + digraph);
        System.out.println("DAG:" + digraph.debugString());

        DirectedCycle directedCycle = new DirectedCycle(digraph);
        Assert.assertTrue(directedCycle.hasCycle());
        Assert.assertFalse(new DirectedCycle(dag).hasCycle());

    }
}
