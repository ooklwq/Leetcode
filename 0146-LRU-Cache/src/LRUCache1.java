import java.util.HashMap;
import java.util.Map;

class LRUCache1 {

    class Node{
        int key, val;
        Node prev, next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }

    }
    class DoubleLinkedList {
        private Node dummyHead;
        private Node tail;

        public DoubleLinkedList(){
            dummyHead = new Node(0, 0);
            tail = dummyHead;
        }

        //添加到尾部
        public void add(Node node){
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        //获取头结点，以备删除
        public Node getHead(){
            return dummyHead.next;
        }

        //删除当前节点
        public void remove(Node node){
            node.prev.next = node.next;
            //判断当前节点是否是尾结点
            if (node.next != null) node.next.prev = node.prev;
            else tail = node.prev;
            //一定要将节点的前驱和后继置空
            node.next = null;
            node.prev = null;
        }

        //将节点删除并移动到尾部
        public void moveToTail(Node node){
            remove(node);
            add(node);
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private DoubleLinkedList cache;

    public LRUCache1(int capacity) {
        map = new HashMap<>();
        cache = new DoubleLinkedList();
        this.capacity = capacity;
    }


    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        //更新节点到尾部
        cache.moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            //更新值并移动到尾部
            node.val = value;
            cache.moveToTail(node);
        } else {
            if (capacity == map.size()){
                //缓存空间满，删除头结点
                Node head = cache.getHead();
                cache.remove(head);
                map.remove(head.key);//删除链表中的元素的同时不要忘记删除map中的元素
            }
            Node node = new Node(key, value);
            map.put(key, node);
            cache.add(node);
        }
    }

    public static void main(String[] args) {
        LRUCache1 cache = new LRUCache1( 1 /* capacity */ );
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