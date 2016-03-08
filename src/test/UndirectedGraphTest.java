package test;

import graph.Graph;
import graph.undirected.UndirectedGraph;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * Created by Dipesh Gupta on 3/8/2016.
 */
public class UndirectedGraphTest {
    public static void main(String[] args) {
        try{
            Graph undirectedGraph= UndirectedGraph.createFromStream(Files.newInputStream(Paths.get("C:\\code\\Workspace\\src\\test\\undirected.txt")));
            IntStream.range(0,undirectedGraph.numberOfVeritices()).forEach(i-> {
                StreamSupport.stream(undirectedGraph.getAllVerticesConnectedTo(i).spliterator(),false).forEach(w-> System.out.println(i+"-"+w));
            });
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
