package ch3;

/**
 * Created by imsungchoi on 2015. 12. 31..
 */
public class Queue<E> {
    private Node<E> first;
    private Node<E> last;

    public Queue() {
        this.first = null;
        this.last = null;
    }

    public Queue(E item) {
        this.first = new Node<>(item);
        this.last = first;
    }

    public void enqueue(E item) {
        Node<E> node = new Node<>(item);

        if (last == null) {
            last = node;
            first = last;
        } else {
            last.setNext(node);
            last = node;
        }
    }

    public E dequeue() {
        if (first == null) {
            return null;
        }

        E item = first.getItem();
        first = first.getNext();
        if (first == null) {
            last = null;
        }
        return item;
    }

    public E peek() {
        return (first != null)? first.getItem() : null;
    }

    public boolean isEmpty() {
        return (last == null && first == null);
    }
}
