class Solution1 {

    //Time Complexity：O(n)
    //Space Complexity: O(1)
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] alphabet = new int[26];
        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
           if (alphabet[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}