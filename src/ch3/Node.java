package ch3;

/**
 * Created by imsungchoi on 2015. 12. 31..
 */
public class Node<E> {
    private Node next;
    private E item;

    public Node() {
        this.next = null;
        this.item = null;
    }

    public Node(E item) {
        this.next = null;
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }
}
