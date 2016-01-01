package ch3;

/**
 * Created by imsungchoi on 2015. 12. 31..
 *
 * min 값을 반환해주는 Stack
 */
public class prob3_2 {
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();

        for(int i = 100; i > 0; i--) {
            stack.push(i);
            //System.out.println(stack.getMin());
        }

        while(stack.isEmpty() == false) {
            System.out.println(stack.pop());
        }
    }
}

class StackWithMin {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = null;

    public StackWithMin() {
        this.stack = new Stack<>();
    }

    public void push(int item) {
        stack.push(item);
        if (min > item) {
            min = item;
        }
    }

    public int pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getMin() {
        return min;
    }
}