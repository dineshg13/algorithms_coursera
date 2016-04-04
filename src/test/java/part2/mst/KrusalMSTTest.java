package part2.mst;

import core.AbstractTest;
import org.junit.Test;
import utils.In;

/**
 * Created by dinesh on 4/3/2016.
 */
public class KrusalMSTTest extends AbstractTest {

    @Test
    public void test() {

        EdgeWeightedGraph graph = new EdgeWeightedGraph(new In(getFilePath("tinyEWG.txt")));
        KrusalMST mst = new KrusalMST(graph);
        System.out.println("MST:");
        mst.getEdges().forEach(edge -> System.out.println(edge));
    }

}
