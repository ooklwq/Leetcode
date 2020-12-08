class Solution {

    //Time Complexity: O(logn)
    //Space Complexity: O(logn)
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        //n为负，n+1是为了解决Integr.MIN_VALUE取反后数值溢出的问题
        if (n < 0) return 1/(x*myPow(x,-(n+1)));
//        double half = myPow(x, n/2);
//        if (n % 2 == 1){
//            return x*half*half;
//        }
//        return half*half;
        return n % 2 == 0 ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2,10));
    }
}