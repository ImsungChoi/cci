package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class AndroidPattern {
    public static void main(String[] args) {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        Vertex v8 = new Vertex(8);
        Vertex v9 = new Vertex(9);

        v1.addReachable(v2);
        v1.addReachable(v4);
        v1.addReachable(v5);
    }

//    public static int calc(Vertex v) {
//
//    }
}

class Vertex {
    int value;
    List<Vertex> reachable;

    Vertex(int value) {
        this.value = value;
        this.reachable = new ArrayList<>();
    }

    void addReachable(Vertex v) {
        this.reachable.add(v);
    }
}
