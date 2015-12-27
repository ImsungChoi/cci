package ch2;

/**
 * Created by imsungchoi on 2015. 12. 28..
 */
public class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public void append(Node node) {
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public Node delete(int data) {
        Node temp = head;
        Node prev = null;
        while(temp.data != data) {
            prev = temp;
            temp = temp.next;
        }

        if (temp != null) {
            prev.next = temp.next;
            return temp;
        }
        return null;
    }
}

class Node {
    Node next;
    int data;
}
