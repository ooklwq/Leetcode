class Solution2 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a'] --;
            if (alphabet[t.charAt(i) - 'a'] < 0) return false;
        }
//        for (int alpha : alphabet) {
//            if (alpha != 0) return false;
//        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new Solution2().isAnagram(s, t));
    }
}