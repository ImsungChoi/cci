package ch4;

/**
 * Created by 1002427 on 2016. 1. 5..
 */
public class Edge {
    DirectedVertex in;
    DirectedVertex out;
    boolean isDirected = false;
    int val = 1;

    public Edge(DirectedVertex in, DirectedVertex out) {
        this.in = in;
        this.out = out;
    }

    public Edge(DirectedVertex in, DirectedVertex out, boolean isDirected) {
        this.in = in;
        this.out = out;
        this.isDirected = isDirected;
    }

    public Edge(DirectedVertex in, DirectedVertex out, boolean isDirected, int val) {
        this.in = in;
        this.out = out;
        this.isDirected = isDirected;
        this.val = val;
    }
}
