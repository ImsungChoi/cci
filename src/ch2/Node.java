package ch2;

/**
 * Created by Creaple on 2015-12-28.
 */
public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    static void deleteNode(Node head, int d) {
        Node n = head;

        if (n.data == d) {
            head = head.next;
            return;
        }

        while (n.next !=  null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return;
            }
            n = n.next;
        }
    }

    static void printAllNodes(Node head) {
        Node n = head;
        while(n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
