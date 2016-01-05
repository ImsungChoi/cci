package ch4;

import java.util.List;

/**
 * Created by 1002427 on 2016. 1. 5..
 */
public class DirectedVertex {
    int val;
    List<Edge> neighbors;
    Color color;

    public DirectedVertex(int val) {
        this.val = val;
        this.neighbors = null;
        this.color = Color.white;
    }

    public DirectedVertex(int val, List<Edge> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
        this.color = Color.white;
    }
}

enum Color {
    white, gray, black;
}
