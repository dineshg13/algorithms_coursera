package part2;

import org.junit.Test;
import part2.undirectedGraph.BFS;
import part2.undirectedGraph.Graph;
import utils.In;

/**
 * Created by dineshgurumurthy on 3/24/16.
 */
public class BFSTest {

    @Test
    public void test() {
        String filePath = "/Users/dineshgurumurthy/dev/coursera/resources/algs4-data";
        String fileName = filePath + "/" + "tinyG.txt";
        In in = new In(fileName);
        Graph graph = new Graph(in);
        BFS bfs = new BFS(graph, 9);

    }
}
