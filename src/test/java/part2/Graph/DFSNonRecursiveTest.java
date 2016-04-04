package part2.Graph;

import core.AbstractTest;
import org.junit.Test;
import part2.undirectedGraph.DFSNonRecursive;
import part2.undirectedGraph.Graph;
import utils.In;

/**
 * Created by dineshgurumurthy on 3/24/16.
 */
public class DFSNonRecursiveTest extends AbstractTest {

    @Test
    public void test() {
        String fileName = getFilePath("tinyG.txt");
        In in = new In(fileName);
        Graph graph = new Graph(in);
        DFSNonRecursive bfs = new DFSNonRecursive(graph, 0);

    }
}
