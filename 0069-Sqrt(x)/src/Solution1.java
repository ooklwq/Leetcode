class Solution1 {

    //Time Complexity: O(logx)
    //Space Complexity: O(1)
    public int mySqrt(int x) {
        if (x <= 1 ) return x;
        long res = x;
        while (res*res > x){
            res = (res + x / res) / 2;
        }
        return (int)res;
    }


}