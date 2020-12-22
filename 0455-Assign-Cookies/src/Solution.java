import java.util.Arrays;

class Solution {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(1)
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length - 1;
        int j = s.length - 1;
        int res = 0;
        while ( i >= 0 && j >= 0 ){
            if ( s[j] >= g[i] ){
                res ++;
                j --;
                i --;
            } else {
                i --;
            }
        }
        return res;
    }
}