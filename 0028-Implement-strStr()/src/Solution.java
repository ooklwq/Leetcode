class Solution {

    //Time Complexity: O(m * n)
    //Space Complexity: O(1)
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i <= m - n; i ++) {
            int j = 0;
            for (j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }
}