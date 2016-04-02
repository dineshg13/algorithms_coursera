package part2.undirectedGraph;

import java.util.Stack;

/**
 * Created by dineshgurumurthy on 3/24/16.
 */
public class DFSNonRecursive {
    private Graph graph;
    private boolean[] marked;
    private int[] edgeTo;
    private int s;//source vertex

    public DFSNonRecursive(Graph graph, int s) {
        this.graph = graph;
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            this.edgeTo[v] = -1;
        }
        this.s = s;
        dfs(s);//source vertex
    }

    private void dfs(int s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        marked[s] = true;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            System.out.println("Next:" + v);
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    stack.push(w);
                    edgeTo[w] = v;
                    marked[w] = true;
                }
            }
        }

    }

}
