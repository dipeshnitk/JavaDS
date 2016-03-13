package graph.undirected;

import graph.Graph;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Dipesh Gupta on 3/8/2016.
 */
public class UndirectedGraph implements Graph {
    private final int numberOfVertices;
    private final List<Integer>[] indexOfVertices;
    private  int numberOfEdges;


    public UndirectedGraph(final int numberOfVertices){
        this.numberOfVertices=numberOfVertices;
        indexOfVertices= (LinkedList<Integer>[])new LinkedList[numberOfVertices];
        // one way of creating list but it requires type casting
        //indexOfVertices= (List<Integer>[]) IntStream.range(0,numberOfVertices).mapToObj(i -> new LinkedList<Integer>()).toArray();
        IntStream.range(0,numberOfVertices).forEach(i-> indexOfVertices[i]= new LinkedList<>());

    }

    private UndirectedGraph(final Scanner sc){
        this(sc.nextInt());
        numberOfEdges=sc.nextInt();
        IntStream.range(0,numberOfEdges).forEach(i-> addEdgeBetween(sc.nextInt(),sc.nextInt()));
    }
    @Override
    public int numberOfVeritices() {
        return numberOfVertices;
    }

    @Override
    public int numberOfEdges() {
        return numberOfEdges;
    }

    @Override
    public void addEdgeBetween(int from, int to) {
        indexOfVertices[from].add(to);
        indexOfVertices[to].add(from);
    }

    @Override
    public Iterable<Integer> getAllVerticesConnectedTo(int vertex) {
        return indexOfVertices[vertex];
    }

    public static UndirectedGraph create(final int numberOfVertices){
        return new UndirectedGraph(numberOfVertices);
    }

    public static UndirectedGraph createFromStream(final InputStream inputStream){
        try(Scanner sc= new Scanner(inputStream)){
            return new UndirectedGraph(sc);
        }
    }
}
