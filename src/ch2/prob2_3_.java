package ch2;

/**
 * Created by Creaple on 2015-12-28.
 *
 * 중간에 있는 노드 하나를 삭제 (head 접근 불가능)
 */
public class prob2_3_ {
    public static void main(String[] args) {
        Node head = new Node(0);
        for(int i = 1; i < 10; i++) {
            head.appendToTail(i);
        }

        Node.printAllNodes(head);
        deleteNode(head.next.next.next);
        Node.printAllNodes(head);
    }

    /**
     * 다음 노드를 삭제하고, 값을 스왑
     *
     * @param node
     */
    public static void deleteNode(Node node) {
        if(node == null || node.next == null) {
            return;
        }

        int data = node.next.data;
        node.next = node.next.next;
        node.data = data;
    }
}
