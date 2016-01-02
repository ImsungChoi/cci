package ch3;

/**
 * Created by imsungchoi on 2015. 12. 31..
 *
 * min 값을 반환해주는 Stack
 */
public class prob3_2_ {
    public static void main(String[] args) throws Exception {
        StackWithMin stack = new StackWithMin();

        for(int i = 20; i > 0; i--) {
            stack.push(i);
            stack.push(i);
            System.out.println(stack.getMin());
        }

        while(stack.isEmpty() == false) {
            System.out.println(stack.getMin());
            System.out.println(stack.pop());
        }
    }
}

class StackWithMin {
    private Stack<Integer> minTracker = null;
    private Stack<Integer> stack = null;

    public StackWithMin() {
        this.stack = new Stack<>();
        this.minTracker = new Stack<>();
    }

    public void push(int item) {
        stack.push(item);
        if (getMin() >= item) {
            minTracker.push(item);
        }
    }

    public int pop() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception();
        }

        if (stack.peek() == getMin()) {
            minTracker.pop();
        }

        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getMin() {
        if (minTracker.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        return minTracker.peek();
    }
}

