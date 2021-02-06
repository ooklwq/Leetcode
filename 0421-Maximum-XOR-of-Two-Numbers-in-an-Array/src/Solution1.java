import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if (cur.child[curBit] == null) {
                    cur.child[curBit] = new TrieNode();
                }
                cur = cur.child[curBit];
            }
        }
        int res = 0;
        for (int num : nums) {
            int curSum = 0;
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if (cur.child[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    cur = cur.child[curBit ^ 1];
                } else {
                    cur = cur.child[curBit];
                }
            }
            res = Math.max(res, curSum);
        }
        return res;
    }

    class TrieNode{
        TrieNode[] child;

        public TrieNode(){
            child = new TrieNode[2];
        }
    }}