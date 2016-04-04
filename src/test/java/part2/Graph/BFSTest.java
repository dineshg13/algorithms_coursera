package part2.Graph;

import core.AbstractTest;
import org.junit.Test;
import part2.undirectedGraph.BFS;
import part2.undirectedGraph.Graph;
import utils.In;

/**
 * Created by dineshgurumurthy on 3/24/16.
 */
public class BFSTest extends AbstractTest {

    @Test
    public void test() {
        String fileName = getFilePath("tinyG.txt");
        In in = new In(fileName);
        Graph graph = new Graph(in);
        BFS bfs = new BFS(graph, 0);


    }
}
