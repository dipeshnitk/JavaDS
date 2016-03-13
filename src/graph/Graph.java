package graph;

/**
 * Created by Dipesh Gupta on 3/8/2016.
 */
public interface Graph {
    int numberOfVeritices();
    int numberOfEdges();
    void addEdgeBetween(int from, int to);
    Iterable<Integer> getAllVerticesConnectedTo(int vertex);
}
