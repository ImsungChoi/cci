package ch2;

import java.util.HashMap;

/**
 * Created by Creaple on 2015-12-28.
 *
 * 비정렬 연결리스트에서 중복 노드 제거 (임시 버퍼 없을 경우는?)
 *
 */
public class prob2_1 {
    public static void main(String[] args) {
        Node head = new Node(0);
        for(int i = 0; i < 10; i++) {
            head.appendToTail(i);
            head.appendToTail(i);
        }

        Node.printAllNodes(head);
        //Node.printAllNodes(deleteDuplicateNode(head));
        Node.printAllNodes(deleteDuplicateNodeWithoutBuffer(head));
    }

    /**
     * Hash Table을 이용해서 중복 노드 제거 방법
     */
    public static Node deleteDuplicateNode(Node head) {
        Node n = head;
        Node prev = null;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        while(n != null) {
            if (map.get(n.data) == null) {
                map.put(n.data, true);
                prev = n;
            } else {
                prev.next = n.next;
            }
            n = n.next;
        }

        return head;
    }

    /**
     * Hash Table 없이 중복 노드 제거 방법
     *
     * @param head
     * @return
     */
    public static Node deleteDuplicateNodeWithoutBuffer(Node head) {
        if (head == null) {return null;}
        Node current = head;

        while(current != null) {
            Node runner = current;
            while(runner.next != null) {
                if(current.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }

        return head;
    }
}
