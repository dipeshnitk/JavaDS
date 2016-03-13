package graphsearch;

import graph.Graph;
import graph.graphsearch.impl.BreadthFirstSearch;
import graph.undirected.UndirectedGraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dipesh Gupta on 3/13/2016.
 */
public class BreadthFirstSearchTest {
    private Graph graph= UndirectedGraph.create(4);
    @Before
    public void setup(){
        graph.addEdgeBetween(0,2);
        graph.addEdgeBetween(2,0);
        graph.addEdgeBetween(1,3);

    }
    @Test
    public void shouldReturnCorrectStatusOfWhetherOrNotTheGivenVertexIsConnectedToSourceVertex() {
        //test
        BreadthFirstSearch bfs= BreadthFirstSearch.create(graph,1);
        assertEquals(true,bfs.connectedTo(3));
        assertEquals(true,bfs.connectedTo(1));
        assertEquals(false,bfs.connectedTo(0));
        assertEquals(false,bfs.connectedTo(2));
    }

    @Test
    public void shouldReturnCorrectSequenceOfBreadthFirstSearch() {
        graph = UndirectedGraph.create(7);
        graph.addEdgeBetween(0,1);
        graph.addEdgeBetween(0,2);
        graph.addEdgeBetween(0,3);
        graph.addEdgeBetween(4,6);
        graph.addEdgeBetween(1,4);
        graph.addEdgeBetween(2,4);
        BreadthFirstSearch bfs= BreadthFirstSearch.create(graph,0);
        //test
        List<Integer> expected= Arrays.asList(0,1,4,6);
        Optional<Iterable<Integer>> optional= bfs.pathTo(6);

        assertEquals(true,optional.isPresent());
        assertEquals(expected.toString(),optional.get().toString());


    }
}
