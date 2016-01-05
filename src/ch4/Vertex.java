package ch4;

import java.util.List;

/**
 * Created by 1002427 on 2016. 1. 5..
 */
public class Vertex {
    int val;
    List<Vertex> neighbors;

    public Vertex (int val, List<Vertex> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
