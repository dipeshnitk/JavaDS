package graph;

import java.util.Optional;

/** An abstraction for search algorithms on Graph
 * @see DepthFirstSearch
 * @see BreadthFirstSearch
 * Created by Dipesh Gupta on 3/13/2016.
 */
public interface GraphSearch {
    /**
     * Determines if the source vertex is connected to the provided vertex
     * @param vertex to which we need to determine if the source vertex is connected
     * @return true if the source vertex is connected to the provided vertex in the parameter
     */
    boolean connectedTo(final int vertex);

    /**
     * Gives the number of vertices connected to the source vertex
     * @return the number of vertices connected to the source vertex
     */
    int count();

    /**
     * Returns the path (sequence of vertices) from source vertex to the provided vertex
     * @param vertex
     * @return an optional wrapping the sequence of vertices for the path between source and the destinaltion vertex
     */
    Optional<Iterable<Integer>> pathTo(int vertex);
}
