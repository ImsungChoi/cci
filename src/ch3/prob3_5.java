package ch3;

/**
 * Created by imsungchoi on 2015. 12. 31..
 *
 * 2개의 Stack으로 Queue 구현
 */
public class prob3_5 {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        for(int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        while(queue.isEmpty() == false) {
            System.out.println(queue.dequeue());
        }
    }
}

class MyQueue<E> {
    Stack<E> in = new Stack<>();
    Stack<E> out = new Stack<>();

    public MyQueue() {

    }

    public void enqueue(E item) {
        in.push(item);
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        if (out.isEmpty()) {
            while(in.isEmpty() == false) {
                out.push(in.pop());
            }
        }

        return out.pop();
    }

    public boolean isEmpty() {
        return (in.isEmpty() && out.isEmpty());
    }
}
