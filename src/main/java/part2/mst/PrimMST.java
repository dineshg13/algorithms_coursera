package part2.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by dinesh on 4/3/2016.
 */
public class PrimMST {
    private PriorityQueue<Edge> priorityQueue;
    private EdgeWeightedGraph graph;
    private List<Edge> edges;
    private boolean[] onTree;

    public List<Edge> getEdges() {
        return edges;
    }

    public PrimMST(EdgeWeightedGraph graph) {
        this.graph = graph;
        onTree = new boolean[graph.V()];
        priorityQueue = new PriorityQueue<>();
        edges = new ArrayList<>();
        //Take
        visit(graph, 0);
        mst();

    }

    private void visit(EdgeWeightedGraph graph, int v) {
        onTree[v] = true;
        for (Edge e : graph.adj(v)) {
            if (!onTree[e.other(v)])
                priorityQueue.add(e);
        }
    }

    private void mst() {
        int n = 0;
        while (!priorityQueue.isEmpty() && n < graph.V() - 1) {
            Edge e = priorityQueue.poll();
            int v = e.either();
            int w = e.other(v);
            if (onTree[v] && onTree[w])
                continue;

            edges.add(e);
            if (!onTree[v]) {
                visit(graph, v);
            } else if (!onTree[w]) {
                visit(graph, w);
            }
        }

    }
}
