class Solution {

    //Time Complexity: O(?)
    //Space Complexity: O(1)
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;//右移的位数
        while ( m != n ){
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m <<= count;
    }

    public static void main(String[] args) {
        int m1 = 5, n1 = 7;
        System.out.println(new Solution().rangeBitwiseAnd(m1,n1));// 4
        int m2 = 0, n2 = 1;
        System.out.println(new Solution().rangeBitwiseAnd(m2,n2));// 0
    }
}