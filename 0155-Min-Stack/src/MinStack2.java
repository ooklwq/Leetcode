//Time Complexity:
//            push: O(1)
//             pop: O(1)
//             top: O(1)
//          getMin: O(1)
//Space Complexity: O(n)
class MinStack2 {
    private Node head;
    class Node{
        int val;
        int min;
        Node next;
        Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public void push(int x) {
        if(head == null){
            head = new Node(x, x, null);
        }else {
            head = new Node(x, Math.min(x, head.min),head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }


    public static void main(String[] args) {
        MinStack2 obj = new MinStack2();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin()); //-3
        obj.pop();
        System.out.println(obj.top());//0
        System.out.println(obj.getMin());//2
    }
}
