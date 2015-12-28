package ch2;

/**
 * Created by Creaple on 2015-12-28.
 *
 * pivot 값을 기준으로 작은 값을 가지는 노드는 앞 쪽에 크거나 같은 값을 가지는 노드는 뒤 쪽에 배치
 */
public class prob2_4_ {
    public static void main(String[] agrs) {
        Node head = new Node(0);
        for(int i = 1; i < 10; i++) {
            head.appendToTail(i);
        }

        Node.printAllNodes(head);
        head = partitionByPivot(head, 6);
        Node.printAllNodes(head);
    }

    /**
     * 2개의 Linked List에 데이터를 옮기는 솔루션
     *
     * @param node
     * @param k
     * @return
     */
    public static Node partitionByPivot(Node node, int k) {
        if (node == null) {
            return null;
        }

        Node before = null;
        Node after = null;

        while(node != null) {
            Node temp = node.next;
            if(node.data < k) {
                node.next = before;
                before = node;
            } else {
                node.next = after;
                after = node;
            }
            node = temp;
        }

        if (before == null) {
            return after;
        }

        Node head = before;
        while(before.next != null) {
            before = before.next;
        }
        before.next = after;
        return head;
    }
}
