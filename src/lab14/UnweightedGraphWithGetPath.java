package lab14;

import java.util.*;

public class UnweightedGraphWithGetPath<V> extends UnweightedGraph<V> {

    /** Construct a graph from vertices and edges stored in arrays */
    public UnweightedGraphWithGetPath(V[] vertices, int[][] edges) {
        super(vertices, edges);

    }

    public List<Integer> getPath(int u, int v) {
        List<Integer> list = new LinkedList<>();
        SearchTree tree = this.bfs(u);
        tree.printPath(v);
        /*Use inner class SearchTree from UnweightedGraph class.
     Either return list or return null*/
        return list;
    }
}
