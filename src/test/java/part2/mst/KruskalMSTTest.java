package part2.mst;

import core.AbstractTest;
import org.junit.Test;
import utils.In;

/**
 * Created by dinesh on 4/3/2016.
 */
public class KruskalMSTTest extends AbstractTest {

    @Test
    public void test() {

        EdgeWeightedGraph graph = new EdgeWeightedGraph(new In(getFilePath("tinyEWG.txt")));
        KruskalMST mst = new KruskalMST(graph);
        System.out.println("MST:");
        mst.getEdges().forEach(edge -> System.out.println(edge));
    }

}
