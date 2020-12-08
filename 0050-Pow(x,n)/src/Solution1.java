class Solution1 {

    //Time Complexity: O(logn)
    //Space Complexity: O(1)
    public double myPow(double x, int n) {
        if (n == 0 || x == 1.0) return 1.0;
        if ( n == 1) return x;
        int res = 1;
        for (int i = n; i != 0; i = i/2) {
            if (i % 2 ==1){
                res *= x;
            }
            x *= x;
        }
        return n > 0 ? res : 1/res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2,10));
        System.out.println(1 == 1.0);
    }
}