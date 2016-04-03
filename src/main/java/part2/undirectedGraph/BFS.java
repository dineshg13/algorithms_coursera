package part2.undirectedGraph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by dineshgurumurthy on 3/24/16.
 */
public class BFS {
    private Graph graph;
    private boolean[] marked;
    private int[] edgeTo;
    private int s; //source vertex

    public BFS(Graph graph, int s) {
        this.graph = graph;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];

        bfs(s);
    }

    private void bfs(int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        marked[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
//            System.out.println("Next:" + v);
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    queue.offer(w);
                    edgeTo[w] = v;
                }

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

}
