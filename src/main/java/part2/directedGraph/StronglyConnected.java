package part2.directedGraph;

/**
 * Created by dineshgurumurthy on 3/30/16.
 */
public class StronglyConnected {
    private Digraph digraph;
    private int[] ids; //these are the connected components
    private boolean[] marked;//marked array
    private int count; // number of connected components
    private Iterable<Integer> reversePost;

    public StronglyConnected(Digraph digraph) {
        this.digraph = digraph;
        this.ids = new int[digraph.V()];
        this.marked = new boolean[digraph.V()];
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph.reverse());
        reversePost = depthFirstOrder.reversePost();
        for (int w : reversePost) {
            if (!marked[w]) {
                dfs(digraph, w);
                count++;
            }

        }

    }

    public Iterable<Integer> getReversePost() {
        return reversePost;
    }

    private void dfs(Digraph digraph, int v) {

        marked[v] = true;
        ids[v] = count;

        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
    }

    public int[] getIds() {
        return ids;
    }
}
