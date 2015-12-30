package ch2;

import java.util.Stack;

/**
 * Created by Creaple on 2015-12-28.
 *
 * Linked List 2개로 + 연산 구현
 */
public class prob2_5_ {
    public static void main(String[] agrs) {
        Node n1 = new Node(9);
        for (int i = 1; i < 10; i++) {
            n1.appendToTail(i);
        }

        Node n2 = new Node(9);
        for (int i = 1; i < 10; i++) {
            n2.appendToTail(i);
        }

        Node.printAllNodes(n1);
        Node.printAllNodes(n2);
        Node ret = addTwoLists2WithRecursive(n1, n2);
        Node.printAllNodes(ret);
    }

    /**
     * 자릿수가 오름차순 일 때 (iterative version)
     *
     * @param n1
     * @param n2
     * @return
     */
    public static Node addTwoLists(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return null;
        }

        Node ret = null;
        Node current = null;

        while (n1 != null && n2 != null) {
            int value = 0;

            if (n1 != null) {
                value += n1.data;
                n1 = n1.next;
            }

            if (n2 != null) {
                value += n2.data;
                n2 = n2.next;
            }

            if(ret == null) {
                ret = new Node(value);
                current = ret;
            } else {
                current.next = new Node(value);
                current = current.next;
            }
        }

        current = ret;
        int carry = 0;
        while (current != null) {
            current.data += carry;
            carry = 0;

            if (current.data > 9) {
                current.data -= 10;
                carry = 1;
            }

            if (current.next == null && carry == 1) {
                current.next = new Node(0);
            }

            current = current.next;
        }

        return ret;
    }

    /**
     * 자릿수가 오름차순 일 때 (recursive version)
     *
     * @param n1
     * @param n2
     * @param carry
     * @return
     */
    public static Node addTwoListsWithRecursive(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null & carry == 0) {
            return null;
        }
        int value = carry;
        value += (n1 != null)? n1.data : 0;
        value += (n2 != null)? n2.data : 0;
        n1 = (n1 != null)? n1.next : null;
        n2 = (n2 != null)? n2.next : null;

        Node node = new Node(value % 10);
        Node next = addTwoListsWithRecursive(n1, n2, value / 10);
        node.next = next;
        return node;
    }

    /**
     * 자릿수가 내림차순일 때 (iterative version)
     *
     * @param n1
     * @param n2
     * @return
     */
    public static Node addTwoLists2(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return null;
        }

        Node ret = null;
        Node current = null;

        while (n1 != null && n2 != null) {
            int value = 0;

            if (n1 != null) {
                value += n1.data;
                n1 = n1.next;
            }

            if (n2 != null) {
                value += n2.data;
                n2 = n2.next;
            }

            if(ret == null) {
                ret = new Node(value);
                current = ret;
            } else {
                current.next = new Node(value);
                current = current.next;
            }
        }

        Stack<Node> stack = new Stack<>();
        current = ret;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        int carry = 0;
        while (stack.isEmpty() == false) {
            current = stack.pop();
            current.data += carry;
            carry = 0;

            if(current.data > 9) {
                current.data -= 10;
                carry = 1;
            }
        }

        if (carry == 1) {
            Node newRet = new Node(1);
            newRet.next = ret;
            ret = newRet;
        }

        return ret;
    }

    /**
     * 자릿수가 내림차순일 때 (recursive version)
     *
     * @param n1
     * @param n2
     * @return
     */
    public static Node addTwoLists2WithRecursive(Node n1, Node n2) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while(n1 != null) {
            s1.push(n1);
            n1 = n1.next;
        }
        while(n2 != null) {
            s2.push(n2);
            n2 = n2.next;
        }

        return addNodesWithStacks(s1, s2, 0);
    }

    public static Node addNodesWithStacks(Stack<Node> s1, Stack<Node> s2, int carry) {
        if (s1.isEmpty() && s2.isEmpty() && carry == 0) {
            return null;
        }

        int value = carry;
        Node temp = null;
        if (s1.size() > s2.size()) {
            temp = s1.pop();
            value += temp.data;
        } else if (s1.size() < s2.size()) {
            temp = s2.pop();
            value += temp.data;
        } else if (s1.isEmpty() == false && s2.isEmpty() == false){
            temp = s1.pop();
            value += temp.data;
            temp = s2.pop();
            value += temp.data;
        }
        Node node = new Node(value % 10);
        Node after = addNodesWithStacks(s1, s2, value / 10);
        return insertNode(node, after);
    }

    public static Node insertNode(Node n1, Node n2) {
        if (n2 == null) {
            return n1;
        }
        Node node = n2;
        while(node.next != null) {
            node = node.next;
        }
        node.next = n1;
        return n2;
    }
}
