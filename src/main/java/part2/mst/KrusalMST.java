package part2.mst;

import part1.unionfind.QuickUnion;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by dinesh on 4/3/2016.
 */
public class KrusalMST {

    private PriorityQueue<Edge> priorityQueue;
    private QuickUnion quickUnion;
    private EdgeWeightedGraph graph;
    private List<Edge> edges;

    public KrusalMST(EdgeWeightedGraph graph) {
        this.graph = graph;
        quickUnion = new QuickUnion(graph.V());
        priorityQueue = new PriorityQueue<>();
        edges = new ArrayList<>();
        for (int v = 0; v < graph.V(); v++) {
            for (Edge e : graph.adj(v)) {
//                System.out.println(e);
                priorityQueue.add(e);
            }
        }
        mst();
    }

    private void mst() {
        int numE = 0;
        while (!priorityQueue.isEmpty() && numE < graph.V() - 1) {
            Edge e = priorityQueue.poll();
            int v = e.either();
            int w = e.other(v);
            if (!quickUnion.connected(v, w)) {
                quickUnion.union(v, w);
                edges.add(e);
                numE++;
            }
        }

    }

    public List<Edge> getEdges() {
        return edges;
    }

    public PriorityQueue<Edge> getPriorityQueue() {
        return priorityQueue;
    }
}
