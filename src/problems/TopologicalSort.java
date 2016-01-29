package problems;

import java.util.*;

/**
 * Created by 1002427 on 2016. 1. 29..
 */
public class TopologicalSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Node> graph = new HashSet<>();

        for(int i = 0; i < 8; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            Node f = getNodes(graph, from);
            Node t = getNodes(graph, to);
            f.adjacent.add(t);
        }

        List<Integer> list = getTopologicalSort(graph);
        Collections.reverse(list);

        System.out.println(graph.size());

        for(int i : list) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> getTopologicalSort(Set<Node> graph) {
        List<Integer> list = new ArrayList<>();

        for(Node n : graph) {
            n.isVisited = false;
        }

        for(Node n : graph) {
            dfsVisit(list, n);
        }
        return list;
    }

    public static void dfsVisit(List<Integer> list, Node n) {
        if(n.isVisited) {
            return;
        }
        n.isVisited = true;

        for(Node direct : n.adjacent) {
            dfsVisit(list, direct);
        }

        list.add(n.val);
    }

    public static Node getNodes(Set<Node> graph, int val) {
        for(Node n : graph) {
            if(n.val == val) {
                return n;
            }
        }

        Node n = new Node(val);
        graph.add(n);
        return n;
    }
}

class Node {
    int val;
    boolean isVisited;
    List<Node> adjacent;

    Node(int val) {
        this.val = val;
        this.isVisited = false;
        adjacent = new ArrayList<>();
    }
}
