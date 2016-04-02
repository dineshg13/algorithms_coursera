package part2;

import org.junit.Test;
import part2.directedGraph.Digraph;
import part2.directedGraph.StronglyConnected;
import utils.In;
import utils.PrintUtils;

/**
 * Created by dineshgurumurthy on 3/30/16.
 */
public class StronglyCCTest {


    @Test
    public void test() {

        String filePath = "/Users/dineshgurumurthy/dev/coursera/resources/algs4-data";
        String fileName = filePath + "/" + "tinyDG.txt";
        In in = new In(fileName);
        Digraph digraph = new Digraph(in);

        StronglyConnected cc = new StronglyConnected(digraph);
        System.out.println("Reverse post");
        PrintUtils.print(cc.getReversePost());

        System.out.println("Strongly connected ");
        PrintUtils.print(cc.getIds());

    }
}
