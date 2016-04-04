package part2.mst;

/**
 * Created by dinesh on 4/3/2016.
 */
public class Edge implements Comparable<Edge> {

    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int v) {
        if (v == this.v) {
            return w;
        }
        return v;
    }

    public double weight() {
        return weight;
    }


    @Override
    public int compareTo(Edge that) {
        return Double.valueOf(weight).compareTo(that.weight); //Compare weights
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Edge{");
        sb.append("v=").append(v);
        sb.append(", w=").append(w);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }

}
