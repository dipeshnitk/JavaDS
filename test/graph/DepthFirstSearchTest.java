package graph;

import graph.undirected.DepthFirstSearch;
import graph.undirected.UndirectedGraph;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dipesh Gupta on 3/13/2016.
 */
public class DepthFirstSearchTest {
    @Test
    public void shouldReturnCorrectStatusOfWhetherOrNotTheGivenVertexIsConnectedToSourceVertex(){
        Graph graph= UndirectedGraph.create(4);
        graph.addEdgeBetween(0,2);
        graph.addEdgeBetween(2,0);
        graph.addEdgeBetween(1,3);
        DepthFirstSearch depthFirstSearch= DepthFirstSearch.create(graph,1);

        // Every vertex is connected to itself
        Assert.assertEquals(2,depthFirstSearch.count());
        Assert.assertEquals(true,depthFirstSearch.connectedTo(3));
        Assert.assertEquals(false,depthFirstSearch.connectedTo(0));
        Assert.assertEquals(false,depthFirstSearch.connectedTo(2));
        Assert.assertEquals(true,depthFirstSearch.connectedTo(1));

    }

}

