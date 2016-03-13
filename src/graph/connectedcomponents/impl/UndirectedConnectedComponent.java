package graph.connectedcomponents.impl;

import graph.Graph;
import graph.connectedcomponents.ConnectedComponents;

/**
 * Created by Dipesh Gupta on 3/13/2016.
 */
public class UndirectedConnectedComponent implements ConnectedComponents {

    private boolean[] marked;
    private int[] id;
    private int count;

    private UndirectedConnectedComponent(final Graph graph){
        marked= new boolean[graph.numberOfVeritices()];
        id= new int[graph.numberOfVeritices()];
        for(int v=0;v<graph.numberOfVeritices();v++){
            if(marked[v]==false){
                dfs(graph,v);
            }
        }
    }

    private void dfs(final Graph graph, final int vertex){
       marked[vertex]=true;

    }
    @Override
    public int numberOfConnectedComponents() {
        return count;
    }

    @Override
    public boolean connected(int v, int w) {
        return id[w]==id[v];
    }

    public static UndirectedConnectedComponent create(final Graph graph){
        return new UndirectedConnectedComponent(graph);
    }
}
