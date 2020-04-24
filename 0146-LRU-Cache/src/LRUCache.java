import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class DoubleLinkedList{


        private int size;
        private Node head;
        private Node tail;

        public DoubleLinkedList(){
            size = 0;
            head = null;
            tail = null;
        }

        public int getSize(){
            return size;
        }

        public void addFirst(Node node){
            if (head == null) {
                head = node;
                head.next = null;
                head.prev = null;
                tail = head;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
                head.prev = null;
            }
            size ++;
        }

        public Node removeLast(){
            if (size == 0) return null;
            Node lastNode = tail;
            Node prev = tail.prev;
            //node为非头结点
            if (prev != null) prev.next = null;
            lastNode.prev = null;
            tail = prev;
            size --;
            return lastNode;
        }

        public void remove(Node node){
            if (size == 0) return;
            node.prev.next = node.next;
            //node为非尾结点
            if (node.next != null) node.next.prev = node.prev;
            else tail = node.prev;
            size --;
        }
    }
    class Node{
        public int key, val;
        public Node next, prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> map;
    private DoubleLinkedList cache;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        Node node = new Node(key, val);
        cache.addFirst(node);
        cache.remove(map.get(key));
        map.put(key, node);
        return val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)){
            cache.addFirst(node);
            cache.remove(map.get(key));
            map.put(key, node);
        } else {
            if (capacity == cache.getSize()){
                Node lastNode = cache.removeLast();
                map.remove(lastNode.key);
            }
            cache.addFirst(node);
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 1 /* capacity */ );
        cache.put(2, 1);
        //cache.put(2, 2);
        System.out.println(cache.get(2));     // returns 1
        cache.put(3, 2);
        System.out.println(cache.get(2));        // returns -1 (not found)
        //cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(3));       // returns 2
        //System.out.println(cache.get(3));        // returns 3
       // System.out.println(cache.get(4));      // returns 4
       // System.out.println(cache.get(2)); //-1
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */