package part2.Graph;

import core.AbstractTest;
import org.junit.Test;
import part2.directedGraph.DepthFirstOrder;
import part2.directedGraph.Digraph;
import utils.In;
import utils.PrintUtils;

/**
 * Created by dineshgurumurthy on 3/30/16.
 */
public class DirectGraphTest extends AbstractTest {

    @Test
    public void test() {

        String fileName = getFilePath("tinyDAG.txt");
        In in = new In(fileName);
        Digraph digraph = new Digraph(in);
//        Digraph reverse = digraph.reverse();
//        System.out.println(digraph);
//        System.out.println("Reversing graph");
//        System.out.println(reverse);

        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
        System.out.println("Pre Order");
        PrintUtils.print(depthFirstOrder.getPre());
        System.out.println("Post Order");
        PrintUtils.print(depthFirstOrder.getPost());
        System.out.println("Reverse Order");
        PrintUtils.print(depthFirstOrder.reversePost());

    }
}
