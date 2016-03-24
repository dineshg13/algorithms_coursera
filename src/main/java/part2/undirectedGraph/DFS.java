package part2.undirectedGraph;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by dineshgurumurthy on 3/24/16.
 */
public class DFS {

    private Graph graph;
    private boolean[] marked;
    private int[] edgeTo;
    private int s;//source vertex

    public DFS(Graph graph, int s) {
        this.graph = graph;
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            this.edgeTo[v] = -1;
        }
        this.s = s;
        dfs(s);//source vertex
    }

    public void dfs(int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
//                System.out.println("Next vertex:" + w);
                dfs(w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return new Stack<>();
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(edgeTo[x]);

        }
        return stack;
    }

    public int[] getEdgeTo() {
        return edgeTo;
    }

    public boolean[] getMarked() {
        return Arrays.copyOf(marked, marked.length);
    }
}
