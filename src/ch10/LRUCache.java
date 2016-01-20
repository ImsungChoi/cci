package ch10;

import java.util.HashMap;

/**
 * Created by imsungchoi on 2016. 1. 20..
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache();

        for(int i = 0; i < 15; i++) {
            cache.put(String.valueOf(i), i);
        }

        System.out.println(cache.tail.val);

        for(int i = 0; i < 15; i++) {
            System.out.println(cache.get(String.valueOf(i)));
        }
    }

    int size = 10;
    HashMap<String, Node> map = new HashMap<>();
    Node head, tail;

    public LRUCache() {
    }

    public LRUCache(int size) {
        this.size = size;
    }

    public int get(String key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(String key, int val) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            n.val = val;
            remove(n);
            setHead(n);
        } else {
            if(map.size() == size) {
                map.remove(tail.key);
                remove(tail);
            }
            Node n = new Node(key, val);
            map.put(key, n);
            setHead(n);
        }
    }

    public void setHead(Node node) {
        node.next = head;
        node.prev = null;

        if(head != null) {
            head.prev = node;
        }

        head = node;

        if(tail == null) {
            tail = node;
        }
    }

    public void remove(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if(node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }
}

class Node {
    String key;
    int val;
    Node next;
    Node prev;

    public Node(String key, int val) {
        this.key = key;
        this.val = val;
    }
}
