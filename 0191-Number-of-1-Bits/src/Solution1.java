public class Solution1 {
    // you need to treat n as an unsigned value

    //Time Complexity: O(m)
    //Space Complexity: O(1)
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }

}