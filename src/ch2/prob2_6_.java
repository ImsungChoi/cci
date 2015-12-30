package ch2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Creaple on 2015-12-28.
 *
 * 순환 연결 리스트에서 순환되는 첫 번째 노드를 반환
 */
public class prob2_6_ {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        System.out.println(findFirstNodeInCircleLinkedList(a).data);
    }

    /**
     * Queue 활용
     *
     * @param head
     * @return
     */
    public static Node findFirstNodeInCircleLinkedList(Node head) {
        Queue<Node> queue = new ArrayDeque<>();

        Node node = head;
        while(node.next != null) {
            for(int i = 0; i < queue.size(); i++) {
                Node temp = queue.poll();
                if (temp == node.next) {
                    return temp;
                }
                queue.add(temp);
            }
            queue.add(node);
            node = node.next;
        }

        return null;
    }
}
