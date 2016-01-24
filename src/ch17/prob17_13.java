package ch17;

import java.util.Stack;

/**
 * Created by imsungchoi on 2016. 1. 24..
 */
public class prob17_13 {
    public static void main(String[] args) {
        BiNode n1 = new BiNode(1);
        BiNode n2 = new BiNode(2);
        BiNode n3 = new BiNode(3);
        BiNode n4 = new BiNode(4);
        BiNode n5 = new BiNode(5);
        BiNode n6 = new BiNode(6);
        BiNode n7 = new BiNode(7);

        n2.node1 = n1;
        n2.node2 = n3;

        n5.node1 = n6;
        n5.node2 = n7;

        n4.node1 = n2;
        n4.node2 = n5;

        BiNode[] ret = convert(n4);
        BiNode first = ret[0];
        BiNode tail = ret[1];

        while(first != null) {
            System.out.println(first.data);
            first = first.node2;
        }

        while(tail != null) {
            System.out.println(tail.data);
            tail = tail.node1;
        }
    }

    public static BiNode[] convert(BiNode root) {
        BiNode prev = null;
        BiNode move = null;
        BiNode first = null;
        Stack<BiNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            BiNode n = stack.peek();

            if(move == null || move.node1 == n || move.node2 == n) {
                if(n.node1 != null) {
                    stack.push(n.node1);
                }
            } else {
                n = stack.pop();
                if(prev != null) {
                    prev.node2 = n;
                } else {
                    first = n;
                }
                n.node1 = prev;
                prev = n;

                if(n.node2 != null) {
                    stack.push(n.node2);
                }
            }
            move = n;
        }
        BiNode[] ret = {first, prev};
        return ret;
    }
}

class BiNode {
    BiNode node1, node2;
    int data;

    BiNode(int data) {
        this.data = data;
    }
}
