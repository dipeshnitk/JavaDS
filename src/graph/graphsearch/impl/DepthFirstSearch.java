package graph.undirected;

import graph.Graph;
import graph.GraphSearch;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Depth First Search implementation on a Graph
 * Created by Dipesh Gupta on 3/13/2016.
 */
public class DepthFirstSearch implements GraphSearch {
    private int sourceVertex; // the source vertex
    private boolean[] marked; // is there a path between source vertex to vertex
    private int[] edgeTo; // the last edge between source vertex to vertex
    private int count;

    @Override
    public boolean connectedTo(int vertex) {
        return marked[vertex];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public Optional<Iterable<Integer>> pathTo(int vertex) {
        if(connectedTo(vertex)==false)return Optional.empty();
        Deque<Integer> stack= new LinkedList<>();
        for(int v= vertex;v!=sourceVertex;v=edgeTo[v]){
            stack.push(v);
        }
        stack.push(sourceVertex);
        return Optional.of(stack);
    }

    private void depthFirstSearch(final Graph graph, final int sourceVertex){
        count++;
        marked[sourceVertex]= true;
        for(int vertex:graph.getAllVerticesConnectedTo(sourceVertex)){
            if(marked[vertex]!=true){
                edgeTo[vertex]=sourceVertex;
                depthFirstSearch(graph,vertex);
            }
        }

        // Java 8 implementation
/*        StreamSupport.stream(graph.getAllVerticesConnectedTo(sourceVertex).spliterator(),false)
                .forEach(vertex -> {
                    if(marked[vertex]!=true){
                        edgeTo[vertex]=sourceVertex;
                        depthFirstSearch(graph,sourceVertex);
                    }
                });*/
    }

    private DepthFirstSearch(final Graph graph, final int sourceVertex) {
        this.sourceVertex=sourceVertex;
        this.marked= new boolean[graph.numberOfVeritices()];
        this.edgeTo= new int[graph.numberOfVeritices()];
        depthFirstSearch(graph,sourceVertex);
    }

    public static DepthFirstSearch create(final Graph graph, final int sourceVertex){
       return new DepthFirstSearch(graph, sourceVertex);

    }
}
