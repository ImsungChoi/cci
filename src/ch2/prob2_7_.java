package ch2;

import java.util.Stack;

/**
 * Created by Creaple on 2015-12-28.
 *
 * Linked List가 회문인지 검사
 */
public class prob2_7_ {
    public static void main(String[] agrs) {
        Node a = new Node(1);
        a.appendToTail(2);
        a.appendToTail(3);
        a.appendToTail(2);
        a.appendToTail(1);
        Node.printAllNodes(a);
        System.out.println(isPalindrome(a));
    }

    /**
     * Stack 활용
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(Node head) {
        Node node = head;
        Stack<Node> stack = new Stack<Node>();

        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int pop = stack.size();
        pop += (pop % 2 == 1)? 1 : 0;
        pop /= 2;
        while (pop-- > 0) {
            node = stack.pop();
        }

        while(stack.isEmpty() != false) {
            if (stack.pop() != node) {
                return false;
            }
        }

        return true;
    }
}
