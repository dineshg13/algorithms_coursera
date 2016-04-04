package part2.mst;

import core.AbstractTest;
import org.junit.Test;
import utils.In;
import utils.PrintUtils;

/**
 * Created by dinesh on 4/3/2016.
 */
public class PrimMSTTest extends AbstractTest {

    @Test
    public void test() {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(new In(getFilePath("tinyEWG.txt")));
        System.out.println(graph.debugString());
        PrintUtils.printLineBreak();
        PrimMST mst = new PrimMST(graph);
        mst.getEdges().forEach(edge -> System.out.println(edge));

    }
}
