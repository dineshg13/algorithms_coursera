package part2;

import core.AbstractTest;
import org.junit.Test;
import part2.undirectedGraph.ConnectedComponents;
import part2.undirectedGraph.DFS;
import part2.undirectedGraph.Graph;
import utils.In;
import utils.PrintUtils;

/**
 * Created by dineshgurumurthy on 3/24/16.
 */
public class GraphTest extends AbstractTest {

    @Test
    public void test() {
        String filePath = getFilePath("tinyG.txt");
        In in = new In(filePath);
        Graph graph = new Graph(in);
//        System.out.println(graph);
        DFS dfs = new DFS(graph, 0);
        System.out.println("Path to 4 from 0");
        PrintUtils.print(dfs.pathTo(4));
        for (int v = 0; v < graph.V(); v++) {
            if (dfs.getEdgeTo()[v] != -1)
                System.out.println("Edge to : " + dfs.getEdgeTo()[v] + "-> " + v);
        }
        ConnectedComponents cc = new ConnectedComponents(graph);
        System.out.println("Number of cc:" + cc.getNum());
        PrintUtils.print(cc.getCc());


    }
}
