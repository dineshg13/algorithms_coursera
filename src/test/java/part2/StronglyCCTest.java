package part2;

import core.AbstractTest;
import org.junit.Test;
import part2.directedGraph.Digraph;
import part2.directedGraph.StronglyConnected;
import utils.In;
import utils.PrintUtils;

/**
 * Created by dineshgurumurthy on 3/30/16.
 */
public class StronglyCCTest extends AbstractTest {


    @Test
    public void test() {

        String fileName = getFilePath("tinyDG.txt");
        In in = new In(fileName);
        Digraph digraph = new Digraph(in);

        StronglyConnected cc = new StronglyConnected(digraph);
        System.out.println("Reverse post");
        PrintUtils.print(cc.getReversePost());

        System.out.println("Strongly connected ");
        PrintUtils.print(cc.getIds());

    }
}
