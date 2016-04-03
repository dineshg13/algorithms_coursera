package part2.directedGraph;

import java.util.Stack;

/**
 * Created by dinesh on 4/3/2016.
 */
public class DirectedCycle {

    private boolean[] marked;
    private int V;
    private boolean isCycle;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph digraph) {
        V = digraph.V();
        marked = new boolean[V];
        edgeTo = new int[V];
        onStack = new boolean[V];
//        cycle = new Stack<>();

        for (int i = 0; i < V; i++) {
            System.out.println("Processing index:" + i);
            if (!marked[i]) {
                dfs(digraph, i);
//                System.out.println("Done with vertex:" + i);
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    // certify that digraph has a directed cycle if it reports one
    private boolean check() {

        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }


        return true;
    }

    private void dfs(Digraph digraph, int v) {
        onStack[v] = true;
        marked[v] = true;

//        System.out.println("Stack:" + stack);
        for (int w : digraph.adj(v)) {
//            System.out.println("Processing adj:" + w);
            if (isCycle) {
                break;
            }
            if (!marked[w]) {
                edgeTo[w] = v; //edge from V to W
                dfs(digraph, w);
            } else if (onStack[w]) {
//                System.out.println(" In Cycle Stack:" + stack + ", v=" + v);
                cycle = new Stack<>();
                isCycle = true;
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                    if (x == edgeTo[x]) {
                        break;
                    }
                }
                cycle.push(w);
                cycle.push(v);
            }
            //Here we need to check for cycle
        }

        onStack[v] = false;
    }

    public Stack<Integer> getCycle() {
        return cycle;
    }
}

