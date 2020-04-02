class Solution1 {
    //Time Complexity: O(?)
    //Space Complexity: O(1)
    public boolean isHappy(int n) {
        int fast = n, slow = n;
        int next = 0;
//        do {
//            slow = squareSum(slow);
//            fast = squareSum(fast);
//            fast = squareSum(fast);
//            if (fast == 1) return true;
//        }while (fast!=slow);
//        return false;
        while (true){
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
            if (slow == fast) break;
        }
        return fast == 1;
    }

    private int squareSum(int n){
        int sum = 0, tmp = 0;
        while (n>0){
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int num = 19;
        System.out.println(new Solution1().isHappy(num));//true
    }
}