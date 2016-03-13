package graph.graphsearch.impl;

import graph.Graph;
import graph.graphsearch.GraphSearch;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * Created by Dipesh Gupta on 3/13/2016.
 */
public class BreadthFirstSearch implements GraphSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private int sourceVertex;
    @Override
    public boolean connectedTo(int vertex) {
        return marked[vertex];
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Iterable<Integer>> pathTo(int vertex) {
        if(connectedTo(vertex)==false) return Optional.empty();
        Deque<Integer> stack= new LinkedList<>();
        for(int v= vertex;v!=sourceVertex;v=edgeTo[v]){
            stack.push(v);
        }
        stack.push(sourceVertex);
        return Optional.of(stack);
    }

    private BreadthFirstSearch(final Graph graph, final int sourceVertex){
        this.marked= new boolean[graph.numberOfVeritices()];
        this.edgeTo= new int[graph.numberOfVeritices()];
        this.sourceVertex=sourceVertex;
        breadthFirstSearch(graph, sourceVertex);
    }

    private void breadthFirstSearch(final Graph graph, final int vertex){
        marked[vertex]=true;
        Queue<Integer> queue= new LinkedList<>();
        queue.offer(vertex);
        while(!queue.isEmpty()){
            int v= queue.poll();
            for(int adjacentVertex:graph.getAllVerticesConnectedTo(v)){
                if(marked[adjacentVertex]==false){
                    marked[adjacentVertex]=true;
                    edgeTo[adjacentVertex]=v;
                    queue.offer(adjacentVertex);
                }
            }
        }
    }

    public static BreadthFirstSearch create(final Graph graph, final int sourceVertex){
        return new BreadthFirstSearch(graph,sourceVertex);
    }
}
