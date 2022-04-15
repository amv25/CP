//146. LRU Cache - Leetcode
//Link - https://leetcode.com/problems/lru-cache/

import java.util.*;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return ("[" + this.key + ", " + this.value + "]");
    }
}

class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        head = new Node(0,0);
        tail = new Node(0,0);
        
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            insertAfterHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        }
        else {
            if (map.size() == capacity) {
                Node beforeTail = tail.prev;
                map.remove(beforeTail.key);
                deleteNode(beforeTail);
            }
            Node node = new Node(key, value);
            insertAfterHead(node);
            map.put(key, node);
        }
    }

    void insertAfterHead(Node node) {
        Node temp = head.next;
        temp.prev = node;
        node.next = temp;
        node.prev = head;
        head.next = node;
    }

    void deleteNode(Node node) {
        Node temp = node.prev;
        temp.next = node.next;
        node.next.prev = temp;
    }

    void print() {
        System.out.println("Printing...");

        System.out.println("Map: " + map);
        
        System.out.print("DLL: ");
        Node node = head;
        while(node.next != null) {
            System.out.print("[" + node.key + ", " + node.value + "], ");
            node = node.next;
        }
        System.out.println("[" + node.key + ", " + node.value + "]");
    }
}

class Runner {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);

        System.out.println("Put: 1, 1");
        obj.put(1,1);

        System.out.println("Put: 2, 2");
        obj.put(2,2);

        System.out.println("Put: 1, 3");
        obj.put(1,3);

        System.out.println("Get 2: " + obj.get(2));
        System.out.println("Get 3: " + obj.get(2));

        System.out.println("Put: 3, 4");
        obj.put(3,4);

        obj.print();
    }
}