package part2.undirectedGraph;

/**
 * Created by dineshgurumurthy on 3/24/16.
 */
public class ConnectedComponents {
    private Graph graph;
    private int[] cc; //connected components will have same value
    private int num;

    public ConnectedComponents(Graph graph) {
        this.graph = graph;
        boolean[] marked = new boolean[graph.V()];
        cc = new int[graph.V()];
        num = 0;
        for (int v = 0; v < graph.V(); v++) {
            if (!marked[v]) {
                DFS dfs = new DFS(graph, v);
                boolean[] m = dfs.getMarked();
                for (int i = 0; i < m.length; i++) {
                    if (!marked[i]) {
                        marked[i] = m[i];
                        cc[i] = num;
                    }
                }
                num++;
            }
        }

    }

    public int[] getCc() {
        return cc;
    }

    public int getNum() {
        return num;
    }
}
