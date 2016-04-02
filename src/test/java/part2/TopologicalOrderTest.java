package part2;

import org.junit.Test;
import part2.directedGraph.DepthFirstOrder;
import part2.directedGraph.Digraph;
import utils.In;
import utils.PrintUtils;

/**
 * Created by dineshgurumurthy on 3/30/16.
 */
public class TopologicalOrderTest {

    @Test
    public void test() {
        String filePath = "/Users/dineshgurumurthy/dev/coursera/resources/algs4-data";
        String fileName = filePath + "/" + "tinyDAG.txt";
        In in = new In(fileName);
        Digraph digraph = new Digraph(in);
        System.out.println("Printing topological order");
        PrintUtils.print(new DepthFirstOrder(digraph).reversePost());

    }
}
