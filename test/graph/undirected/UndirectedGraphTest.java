package graph.undirected;

import graph.Graph;
import graph.undirected.UndirectedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;


/**
 * Created by Dipesh Gupta on 3/8/2016.
 */
public class UndirectedGraphTest {

    @Test
    public void shouldPrepareUndirectedGraphAndTestNumberOfVerticesAndNumberOfEdges() {
        Graph undirectedGraph= UndirectedGraph.createFromStream(getClass().getResourceAsStream("/undirected.txt"));
           /* IntStream.range(0,undirectedGraph.numberOfVeritices()).forEach(i-> {
                StreamSupport.stream(undirectedGraph.getAllVerticesConnectedTo(i).spliterator(),false).forEach(w-> System.out.println(i+"-"+w));
            });*/
        assertEquals(undirectedGraph.numberOfVeritices(),13);
        assertEquals(undirectedGraph.numberOfEdges(),13);
    }

    @Test
    public void shouldAddEdgeBetweenTwoVertices(){
        Graph undirectedGraph= UndirectedGraph.create(4);
        undirectedGraph.addEdgeBetween(0,3);
        undirectedGraph.addEdgeBetween(2,3);
        undirectedGraph.addEdgeBetween(0,2);

        assertEquals(2,undirectedGraph.getAllVerticesConnectedTo(0).spliterator().estimateSize());
    }
}
