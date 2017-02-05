package part2.shortestpath;

/**
 * Created by dinesh on 4/16/2016.
 */
public class DirectedEdge implements Comparable<DirectedEdge> {
    private int v;
    private int w;
    private double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }


    @Override
    public int compareTo(DirectedEdge that) {
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
