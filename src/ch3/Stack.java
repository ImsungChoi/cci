package ch3;

/**
 * Created by imsungchoi on 2015. 12. 31..
 */
public class Stack<E> {
    private Node<E> top;

    public Stack(){
        top = null;
    }

    public void push(E item) {
        Node<E> node = new Node<>();
        node.setItem(item);
        node.setNext(top);
        top = node;
    }

    public E pop() {
        E item = top.getItem();
        top = top.getNext();
        return item;
    }

    public E peek() {
        return top.getItem();
    }

    public boolean isEmpty() {
        return (top == null);
    }
}
