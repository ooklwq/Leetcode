import java.util.Stack;

//Time Complexity:
//            push: O(1)
//             pop: O(1)
//             top: O(1)
//          getMin: O(1)
//Space Complexity: O(n)
class MinStack3 {
    private Stack<Integer> normalStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        normalStack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }else {
            minStack.push(Math.min(x,minStack.peek()));
        }
    }

    public void pop() {
        if (normalStack.isEmpty()) return;
        normalStack.pop();
        minStack.pop();
    }

    public int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack3 obj = new MinStack3();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin()); //-3
        obj.pop();
        System.out.println(obj.top());//0
        System.out.println(obj.getMin());//2
    }
}
