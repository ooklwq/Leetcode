class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        boolean[] used = new boolean[128];//ASCII 表共能表示 256 个字符，但是由于键盘只能表示 128 个字符，所以用 128 也行
        int left = 0, right = 0; //维持[i, j) 滑动窗口
        while (right < s.length()) {
            if (!used[s.charAt(right)]) {
                used[s.charAt(right ++)] = true;
            } else {
                res = Math.max(res, right - left);
                while ( left < right && s.charAt(left) != s.charAt(right)) {
                    used[s.charAt(left ++)] = false;
                }
                left ++;
                right ++;
            }
        }
        res = Math.max(res, right - left);
        return res;
    }
}