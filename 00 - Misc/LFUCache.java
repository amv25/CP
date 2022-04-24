import java.util.*;

class Node {
    int freq;
    int key;
    int value;
    Node prev;
    Node next;

    Node(int freq, int key, int value) {
        this.freq = freq;
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(freq: " + this.freq + ", key: " + this.key + ", value: " + this.value + ")";
    }
}

class LFUCache {
    int capacity;
    int minFreq;
    HashMap<Integer, Node> mainMap;
    HashMap<Integer, ArrayList<Node>> freqMap;
    
    LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.mainMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    void put(int key, int value) {
        if(this.capacity == 0) {
            return;
        }

        if(this.mainMap.containsKey(key)) {
            Node node = this.mainMap.get(key);
            node.value = value;
            removeNode(node, true);
            node.freq++;
            addNode(node);
        }
        else {
            Node node = new Node(1, key, value);
            if(this.capacity == this.mainMap.size()) {
                removeNode(this.freqMap.get(this.minFreq).get(1).prev, false);
            }
            this.minFreq = 1;
            addNode(node);
            this.mainMap.put(key, node);
        }
    }

    int get(int key) {
        if(this.mainMap.containsKey(key)) {
            Node node = this.mainMap.get(key);
            removeNode(node, true);
            node.freq++;
            addNode(node);
            return node.value;
        }
        return -1;
    }

    void addNode(Node node) {
        if(this.freqMap.containsKey(node.freq)) {
            Node head = this.freqMap.get(node.freq).get(0);
            dllInsert(head, node, head.next);
            head.value++;
        }
        else {
            Node head = new Node(node.freq, 0, 1);
            Node tail = new Node(node.freq, 0, 0);
            ArrayList<Node> list = new ArrayList<>();

            dllInsert(head, node, tail);
            list.add(head);
            list.add(tail);
            this.freqMap.put(node.freq, list);
        }
    }

    void removeNode(Node node, boolean update) {
        Node temp = node.prev;
        temp.next = node.next;
        node.next.prev = temp;

        Node head = this.freqMap.get(node.freq).get(0);
        if(--head.value == 0) {
            this.freqMap.remove(node.freq);
            if(update && node.freq == this.minFreq) {
                this.minFreq++;
            }
        }

        if(!update) {
            this.mainMap.remove(node.key);
        }
    }

    void dllInsert(Node head, Node node, Node temp) {
        head.next = node;
        node.next = temp;
        node.prev = head;
        temp.prev = node;
    }

    @Override
    public String toString() {
        return Arrays.asList(this.mainMap) + "\n" + Arrays.asList(this.freqMap);
    }
}

class Runner {
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);

        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.put(3, 3);
        lfu.get(2);
        lfu.put(4, 4);

        System.out.println(lfu);
    }
}