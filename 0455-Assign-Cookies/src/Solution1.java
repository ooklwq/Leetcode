import java.util.Arrays;

class Solution1 {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(1)
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; j < s.length && i < g.length; j++) {
            if (g[i] <= s[j]) i ++;
        }
        return i;
    }
}