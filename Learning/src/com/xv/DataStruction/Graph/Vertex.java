package com.xv.DataStruction.Graph;
import java.util.List;
public class Vertex {
    String name;
    List<Edge> edge;
    boolean visited;
    int indegree;
    public Vertex(String name){
        this.name = name;
    }
    public static void main(String[] args){
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        a.edge = List.of(new Edge(c));
    }

}
class Edge{
    Vertex link;
    int weight;
    public Edge(Vertex link){
        this.link = link;
    }
    public Edge(Vertex link,int weight){
        this.link = link;
        this.weight = weight;
    }


}