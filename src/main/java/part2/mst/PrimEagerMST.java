package part2.mst;

import part1.queues.IndexMinPQ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinesh on 4/14/2016.
 */
public class PrimEagerMST {

    private IndexMinPQ<Edge> priorityQueue;
    private EdgeWeightedGraph graph;
    private List<Edge> edges;
    private boolean[] onTree;

    public PrimEagerMST(EdgeWeightedGraph graph) {
        priorityQueue = new IndexMinPQ<>(graph.V());
        onTree = new boolean[graph.V()];
        edges = new ArrayList<>();
        this.graph = graph;
        visit(graph, 0);
        mst();
    }

    public List<Edge> getEdges() {
        return edges;
    }

    private void visit(EdgeWeightedGraph graph, int v) {
        onTree[v] = true;
        for (Edge e : graph.adj(v)) {
            int w = e.other(v);
            if (!priorityQueue.contains(w)) {
                priorityQueue.insert(w, e);
            } else if (priorityQueue.contains(w) && e.compareTo(priorityQueue.getKey(w)) < 0) {
                priorityQueue.decreaseKey(w, e);
            }
        }

    }

    private void mst() {
        int n = 0;
        while (!priorityQueue.isEmpty() && n < graph.V() - 1) {
            Edge e = priorityQueue.delMinKey();
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
