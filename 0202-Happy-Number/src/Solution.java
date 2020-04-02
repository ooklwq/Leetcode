import java.util.HashSet;

class Solution {
    //Time Complexity: O(?)
    //Space Complexity: O(?)
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        int next = 0;
        while ( n!= 1){
            next = squareSum(n);
            if (set.contains(next)) break;
            else{
                set.add(next);
                n = next;
            }
        }
        return n == 1;
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
        System.out.println(new Solution().isHappy(num));//true
    }
}