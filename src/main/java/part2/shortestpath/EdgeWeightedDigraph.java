package part2.shortestpath;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import utils.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinesh on 4/16/2016.
 */
public class EdgeWeightedDigraph {
    private int V;//number of vertices
    private int E;
    private Bag<DirectedEdge> adj[];
    private List<DirectedEdge> edges;


    public EdgeWeightedDigraph(int v) {
        V = v;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new HashBag<DirectedEdge>();
        }
        edges = new ArrayList<>();

    }

    public EdgeWeightedDigraph(In in) {
        this(in.readInt()); // First line is the number of vertices
        this.E = in.readInt(); //Number of next lines should be equial to number of edges
        edges = new ArrayList<>(E);
        while (!in.isEmpty()) {
            addEdge(in.readInt(), in.readInt(), in.readDouble());
        }
    }

    private void addEdge(int v, int w, double wt) {
        DirectedEdge e = new DirectedEdge(v, w, wt);
        edges.add(e);
        adj[v].add(e);//directed weighted Graph
    }

    private void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("DirectedEdgeWeightedGraph{");
        builder.append("V=").append(V);
        builder.append(", E=").append(E);
        for (int v = 0; v < V(); v++) {
            builder.append("\nVertex: " + v + ", DirectedEdges to :");
            for (DirectedEdge w : adj(v)) {
                builder.append(w + ",");
            }
        }
        builder.append('}');
        return builder.toString();
    }


    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public String debugString() {
        StringBuilder builder = new StringBuilder();
        for (int v = 0; v < V(); v++) {
            builder.append("\nVertex: " + v + ", DirectedEdges to :");
            for (DirectedEdge w : adj(v)) {
                builder.append(w + ",");
            }
        }
        return builder.toString();
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public List<DirectedEdge> getDirectedEdges() {
        return edges;
    }

    public List<DirectedEdge> edges() {
        return edges;
    }
}
