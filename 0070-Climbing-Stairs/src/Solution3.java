class Solution3 {

    //Time Complexity: O(1)
    //Space Complexity: O(1)
    //给出通项公式直接给出解
    public int climbStairs(int n) {
        double root5 = Math.sqrt(5);
        double res =  (1 / root5) * (Math.pow((1 + root5) / 2, n + 1) - Math.pow((1 - root5) / 2, n + 1));
        return (int)res;
    }

}