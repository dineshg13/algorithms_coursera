package part2.ST;

import core.AbstractTest;
import org.junit.Test;
import part2.shortestpath.EdgeWeightedDigraph;
import utils.In;

/**
 * Created by dinesh on 4/16/2016.
 */
public class EdgeWeightedDigraphTest extends AbstractTest {

    @Test
    public void test() {
        In in = new In(getFilePath("tinyEWD.txt"));
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(in);
        System.out.println(digraph);
    }
}
