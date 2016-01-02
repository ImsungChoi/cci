package ch3;

/**
 * Created by imsungchoi on 2015. 12. 31..
 *
 * Stack을 오름차순으로 정렬하는 솔루션 (추가적인 Stack 하나만 사용 가능)
 */
public class prob3_6 {
    public static void main(String[] args) {
        SortedStack stack = new SortedStack();

        for(int i = 0; i < 10; i++) {
            stack.push(i);
        }

        while(stack.isEmpty() == false) {
            System.out.println(stack.pop());
        }
    }
}

class SortedStack {
    Stack<Integer> stack;

    public SortedStack() {
        stack = new Stack<Integer>();
    }

    public void push(int item) {
        Stack<Integer> temp = new Stack<>();

        while(stack.isEmpty() == false) {
            if(stack.peek() < item) {
                temp.push(stack.pop());
            } else {
                break;
            }
        }

        stack.push(item);
        while(temp.isEmpty() == false) {
            stack.push(temp.pop());
        }
    }

    public int pop() {
        if (isEmpty()) {
            return 0;
        }

        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int peek() {
        if (isEmpty()) {
            return 0;
        }
        return stack.peek();
    }
}
