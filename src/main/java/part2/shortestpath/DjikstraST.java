package part2.shortestpath;

import part1.queues.IndexMinPQ;

import java.util.Stack;

/**
 * Created by dinesh on 4/16/2016.
 */
public class DjikstraST {

    private EdgeWeightedDigraph digraph;
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private int s;// this is the source vertex
    private IndexMinPQ<Double> priorityQueue;

    public DjikstraST(EdgeWeightedDigraph digraph, int s) {

        this.digraph = digraph;
        distTo = new double[digraph.V()];
        edgeTo = new DirectedEdge[digraph.V()];
        for (int i = 0; i < digraph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;

        priorityQueue = new IndexMinPQ<>(digraph.V());
        priorityQueue.insert(s, distTo[s]);
        computeST();
    }


    private void visit(int v) {
        for (DirectedEdge e : digraph.adj(v)) {
            relax(e);
        }
    }


    /*
    this method computes the shortest path
     */
    private void computeST() {
        while (!priorityQueue.isEmpty()) {
            int v = priorityQueue.delMin();
            visit(v);
        }

    }

    public Stack getEdges(int v) {
        Stack directedEdges = new Stack();
        for (int x = v; x != s; x = edgeTo[x].from()) {
            directedEdges.add(edgeTo[x]);
        }
        return directedEdges;
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (priorityQueue.contains(w))
                priorityQueue.decreaseKey(w, distTo[w]);
            else
                priorityQueue.insert(w, distTo[w]);
        }
    }
}
