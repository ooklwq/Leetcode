import java.util.HashMap;
import java.util.Map;

class MapSum {

    private class Node{
        //public boolean isWord;
        public int val;
        public Map<Character, Node> next;

        public Node(int val){
            //this.isWord = isWord;
            this.val = val;
            next = new HashMap<>();
        }

        public Node(){
            this(0);
        }

    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            Character c = key.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        //cur.isWord = true;
        cur.val = val;
    }


    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (cur.next.get(c) == null) return 0;
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node){
        int res = node.val;
        for (Character c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }
}

