package part2.mst;

import part1.queues.IndexMinPQ;
import part1.unionfind.QuickUnion;

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

    public double weight() {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    }

    private static final double FLOATING_POINT_EPSILON = 1E-12;

    public boolean check(EdgeWeightedGraph G) {

        // check weight
        double totalWeight = 0.0;
        for (Edge e : edges()) {
            totalWeight += e.weight();
        }
        if (Math.abs(totalWeight - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", totalWeight, weight());
            return false;
        }

        // check that it is acyclic
        QuickUnion uf = new QuickUnion(G.V());
        for (Edge e : edges()) {
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                System.err.println("Not a forest");
                return false;
            }
            uf.union(v, w);
        }

        // check that it is a spanning forest
        for (Edge e : G.edges()) {
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }

        // check that it is a minimal spanning forest (cut optimality conditions)
        for (Edge e : edges()) {

            // all edges in MST except e
            uf = new QuickUnion(G.V());
            for (Edge f : edges()) {
                int x = f.either(), y = f.other(x);
                if (f != e) uf.union(x, y);
            }

            // check that e is min weight edge in crossing cut
            for (Edge f : G.edges()) {
                int x = f.either(), y = f.other(x);
                if (!uf.connected(x, y)) {
                    if (f.weight() < e.weight()) {
                        System.err.println("Edge " + f + " violates cut optimality conditions");
                        return false;
                    }
                }
            }

        }

        return true;
    }

    private Iterable<? extends Edge> edges() {
        return edges;
    }

}
