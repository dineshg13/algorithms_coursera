package part2.directedGraph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by dineshgurumurthy on 3/30/16.
 */
public class DepthFirstOrder {

    private Digraph digraph;
    private boolean[] marked;
    private Stack<Integer> reversePost;
    private Queue<Integer> pre;
    private Queue<Integer> post;

    public DepthFirstOrder(Digraph digraph) {
        marked = new boolean[digraph.V()];
        reversePost = new Stack<>();
        pre = new ArrayDeque<>();
        post = new ArrayDeque<>();
        for (int v = 0; v < digraph.V(); v++) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }

    }

    /*
    This is recursive call .
     */
    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        pre.offer(v);
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
        post.offer(v);
        reversePost.push(v);
    }

    public Queue<Integer> getPre() {
        return pre;
    }

    public Queue<Integer> getPost() {
        return post;
    }

    public Stack<Integer> reversePost() {
        return reversePost;
    }

}
