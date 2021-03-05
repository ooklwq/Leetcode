import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class ListNode{
        int key, value;
        ListNode pre, next;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private ListNode head, tail;
    private Map<Integer, ListNode> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        cache = new HashMap<>();
    }

    private void remove(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void add(ListNode node) {
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        head.next = node;
    }

    private void removeToHead(ListNode node) {
        this.remove(node);
        this.add(node);
    }

    private ListNode removeTail() {
        ListNode deletedNode = tail.pre;
        this.remove(deletedNode);
        return deletedNode;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        ListNode node = cache.get(key);
        this.removeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            node.value = value;
            this.removeToHead(node);
        } else {
            if (cache.size() == capacity) {
                ListNode deletedNode = this.removeTail();
                cache.remove(deletedNode.key);
            }
            ListNode newNode = new ListNode(key, value);
            cache.put(key, newNode);
            this.add(newNode);
        }
    }
}
