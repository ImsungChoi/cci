package ch4;

import java.util.List;

/**
 * Created by 1002427 on 2016. 1. 5..
 */
public class DirectedGraph {
    List<DirectedVertex> vertices;
    List<Edge> edges;

    public DirectedGraph() {
        this.vertices = null;
        this.edges = null;
    }

    public DirectedGraph(List<DirectedVertex> vertices) {
        this.vertices = vertices;
        this.edges = null;
    }

    public DirectedGraph(List<DirectedVertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }
}


