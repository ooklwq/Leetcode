class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int i = 0, j = s.length - 1;
        while (i < j){
            char temp = s[j];
            s[j--] = s[i];
            s[i++] = temp;
        }
//        int n = s.length;
//        for (int i = 0; i < n/2; i++){
//            char temp = s[i];
//            s[i] = s[n - 1 - i];
//            s[n - 1 - i] = temp;
//        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l' ,'o'};
        new Solution().reverseString(s);
        for (char c : s) {
            System.out.println(c);
        }
    }
}