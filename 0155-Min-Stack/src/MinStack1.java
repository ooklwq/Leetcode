//Time Complexity:
//            push: O(1)
//             pop: O(1)
//             top: O(1)
//          getMin: O(n)
//Space Complexity: O(n)
class MinStack1 {
    private int[] array;
    private int size;
    /** initialize your data structure here. */
    public MinStack1() {
        array = new int[10];
        size = 0;
    }

    private void resize(int capacity){
        int[] newArray = new int[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void push(int x) {
        if(size == array.length) resize(array.length * 2);
        array[size] = x;
        size++;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return array[size-1];
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack1 obj = new MinStack1();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin()); //-3
        obj.pop();
        System.out.println(obj.top());//0
        System.out.println(obj.getMin());//2
    }
}
