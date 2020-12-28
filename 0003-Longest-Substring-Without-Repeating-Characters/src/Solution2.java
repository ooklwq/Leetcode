class Solution2 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        boolean[] used = new boolean[128];//ASCII 表共能表示 256 个字符，但是由于键盘只能表示 128 个字符，所以用 128 也行
        int left = 0, right = -1; //维持[i, j] 滑动窗口
        while (left < s.length()) {
            if (right + 1 < s.length() && !used[s.charAt(right + 1)]) {
                used[s.charAt(++ right)] = true;
                res = Math.max(res, right - left + 1);
            } else {
                used[s.charAt(left ++)] = false;
            }
        }
        return res;
    }
}