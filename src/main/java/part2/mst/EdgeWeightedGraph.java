package part2.mst;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import utils.In;

/**
 * Created by dinesh on 4/3/2016.
 */
public class EdgeWeightedGraph {
    private int V;//number of vertices
    private int E;
    private Bag<Edge> adj[];


    public EdgeWeightedGraph(int v) {
        V = v;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new HashBag<Edge>();
        }
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt()); // First line is the number of vertices
        this.E = in.readInt(); //Number of next lines should be equial to number of edges
        while (!in.isEmpty()) {
            addEdge(in.readInt(), in.readInt(), in.readDouble());
        }
    }

    private void addEdge(int v, int w, double wt) {
        Edge e = new Edge(v, w, wt);
        adj[v].add(e);//directed weighted Graph
        adj[w].add(e);//undirected weighted Graph
    }

    private void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("EdgeWeightedGraph{");
        builder.append("V=").append(V);
        builder.append(", E=").append(E);
        for (int v = 0; v < V(); v++) {
            builder.append("\nVertex: " + v + ", Edges to :");
            for (Edge w : adj(v)) {
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
            builder.append("\nVertex: " + v + ", Edges to :");
            for (Edge w : adj(v)) {
                builder.append(w + ",");
            }
        }
        return builder.toString();
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}
