package part2.undirectedGraph;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import utils.In;

/**
 * Created by dineshgurumurthy on 3/24/16.
 */
public class Graph {
    private int V;
    private int E;
    private Bag<Integer> adj[];

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new HashBag<Integer>();
        }
    }

    public Graph(In in) {
        this(in.readInt()); // First line is the number of vertices
        this.E = in.readInt(); //Number of next lines should be equial to number of edges
        while (!in.isEmpty()) {
            addEdge(in.readInt(), in.readInt());
        }
    }

    /*
    number of vertices
     */
    public int V() {
        return V;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /*
    number of edgers
     */
    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    //degree of vertice
    public int degree(int v) {
        return adj[v].size();
    }

    public int maxDegree() {
        int m = 0;
        for (int i = 0; i < V(); i++) {
            int d = degree(i);
            if (m < d) {
                m = d;
            }
        }
        return m;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Graph{");
        sb.append("V=").append(V);
        sb.append(", E=").append(E);
        sb.append("\n");
        for (int v = 0; v < V(); v++) {
            for (int w : adj[v]) {
                sb.append(v + "->" + w);
                sb.append("\n");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
