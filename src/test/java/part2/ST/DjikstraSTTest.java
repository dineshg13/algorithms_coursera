package part2.ST;

import core.AbstractTest;
import org.junit.Test;
import part2.shortestpath.DjikstraST;
import part2.shortestpath.EdgeWeightedDigraph;
import utils.In;
import utils.PrintUtils;

/**
 * Created by dinesh on 4/16/2016.
 */
public class DjikstraSTTest extends AbstractTest {

    @Test
    public void test() {
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(new In(getFilePath("tinyEWD_e.txt")));
        DjikstraST st = new DjikstraST(digraph, 0);
        PrintUtils.print(st.getEdges(6));

    }
}
