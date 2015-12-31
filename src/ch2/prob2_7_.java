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
        if (head == null) {
            return false;
        }

        Node fast = head;
        Node slow = head;
        Stack<Node> stack = new Stack<>();

        while(fast != null && fast.next != null) {
            stack.push(slow);
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null) {
            slow = slow.next;
        }

        while(stack.isEmpty() != false) {
            Node node = stack.pop();
            if(node != slow) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
