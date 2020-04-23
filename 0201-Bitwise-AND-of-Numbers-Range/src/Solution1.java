class Solution1 {

    //Time Complexity: O(?)
    //Space Complexity: O(1)
    public int rangeBitwiseAnd(int m, int n) {
        while ( m < n ){
            n &= (n-1);
        }
        return n;
    }

    public static void main(String[] args) {
        int m1 = 5, n1 = 7;
        System.out.println(new Solution1().rangeBitwiseAnd(m1,n1));// 4
        int m2 = 0, n2 = 1;
        System.out.println(new Solution1().rangeBitwiseAnd(m2,n2));// 0
    }
}