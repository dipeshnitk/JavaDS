package graph.connectedcomponents;

/**
 * Represents the Connected components of a graph
 * A connected component is the maximal set of connected vertices
 * Created by Dipesh Gupta on 3/13/2016.
 */
public interface ConnectedComponents {
    /**
     * Retursn the number of connected components of a Graph
     * @return number connected components
     */
    public int numberOfConnectedComponents();

    /**
     * Returns if or not two vertices are connected
     * @param v first vertex
     * @param w second vertex
     * @return true if v and w are connected else false
     */
    public boolean connected(final int v, final int w);
}
