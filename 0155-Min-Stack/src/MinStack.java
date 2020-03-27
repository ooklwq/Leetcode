import java.util.ArrayList;

//Time Complexity:
//            push: O(1)
//             pop: O(1)
//             top: O(1)
//          getMin: O(n)
//Space Complexity: O(n)
class MinStack {
    private ArrayList<Integer> array;
    /** initialize your data structure here. */
    public MinStack() {
        array = new ArrayList<>();
    }

    public void push(int x) {
        array.add(array.size(),x);
    }

    public void pop() {
        array.remove(array.size()-1);
    }

    public int top() {
        return array.get(array.size()-1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < min) min = array.get(i);
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin()); //-3
        obj.pop();
        System.out.println(obj.top());//0
        System.out.println(obj.getMin());//2
    }
}
