package ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by imsungchoi on 2016. 1. 1..
 */
public class prob4_2 {
    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph();
        DirectedVertex v1 = new DirectedVertex(1);
        DirectedVertex v2 = new DirectedVertex(2);

        List<DirectedVertex> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            DirectedVertex v = new DirectedVertex(i);

            if (i > 2) {
                Edge edge = new Edge(list.get(i-1), v, true);
                List<Edge> neighbors = list.get(i - 1).neighbors;
                if (neighbors == null) {
                    list.get(i - 1).neighbors = new ArrayList<Edge>();
                }
                list.get(i - 1).neighbors.add(edge);
            }
            list.add(v);
        }
        g.vertices = list;
        System.out.println(isReachable(g, list.get(2), list.get(9)));
    }

    public static boolean isReachable(DirectedGraph g, DirectedVertex v1, DirectedVertex v2) {
        return isReachableUni(g, v1, v2) || isReachableUni(g, v2, v1);
    }

    public static boolean isReachableUni(DirectedGraph g, DirectedVertex v1, DirectedVertex v2) {
        Queue<DirectedVertex> queue = new LinkedList<>();
        queue.offer(v1);

        while(!queue.isEmpty()) {
            DirectedVertex v = queue.poll();

            if (v == v2) {
                return true;
            }

            v.color = Color.gray;
            if (v.neighbors != null) {
                v.neighbors.stream()
                        .map(edge -> edge.out)
                        .filter(vertex -> vertex.color == Color.white)
                        .forEach(vertex -> queue.offer(vertex));
            }
            v.color = Color.black;
        }
        return false;
    }

}
