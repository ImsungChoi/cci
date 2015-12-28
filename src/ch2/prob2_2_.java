package ch2;

/**
 * Created by Creaple on 2015-12-28.
 *
 * 뒤에서 k번째 노드를 찾는 방법
 */
public class prob2_2_ {
    public static void main(String[] args) {
        Node head = new Node(0);
        for(int i = 1; i < 10; i++) {
            head.appendToTail(i);
        }

        Node.printAllNodes(head);
        System.out.println(findKthNodeFromEnd(head, 7).data);
        System.out.println(findKthNodeFromEndWithRecursive(head, 7, new IntWrapper()).data);
        System.out.println(findKthNodeFromEndWithTwoPointers(head, 7).data);
    }

    /**
     * Linked List의 총 갯수를 세서 다시 한번 계산
     *
     * @param head
     * @param k
     * @return
     */
    public static Node findKthNodeFromEnd(Node head, int k) {
        if(head == null) {
            return null;
        }

        Node n = head;
        int count = 1;
        while (n.next != null) {
            count++;
            n = n.next;
        }

        if (count < k) {
            return null;
        }

        n = head;
        for (int i = 0; i < count-k; i++) {
            n = n.next;
        }

        return n;
    }

    /**
     * Recursive로 계산 (IntWrapper 활용)
     *
     * @param head
     * @param k
     * @param i
     * @return
     */
    public static Node findKthNodeFromEndWithRecursive(Node head, int k, IntWrapper i) {
        if (head == null) {
            return null;
        }

        Node ret = findKthNodeFromEndWithRecursive(head.next, k, i);
        i.value++;
        if (i.value == k) {
            ret = head;
        }
        return ret;
    }

    /**
     * 2개의 포인터를 이용한 iterative 솔루션
     *
     * @param head
     * @param k
     * @return
     */
    public static Node findKthNodeFromEndWithTwoPointers(Node head, int k) {
        if (head == null) {
            return null;
        }

        Node firstPointer = head;
        Node secondPointer = firstPointer;

        for(int i = 0; i < k-1; i++) {
            if (secondPointer.next == null) {
                return null;
            } else {
                secondPointer = secondPointer.next;
            }
        }

        while(secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return firstPointer;
    }
}




