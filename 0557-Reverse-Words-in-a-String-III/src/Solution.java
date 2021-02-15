class Solution {

    //Time Complexity: O(mn)
    //Space Complexity: O(1)
    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
        }
        return String.join(" ", words);
    }

    private String reverse(String word) {
        int left = 0, right = word.length() - 1;
        char[] arr = word.toCharArray();
        while (left < right) {
            char temp = arr[left];
            arr[left ++] = arr[right];
            arr[right --] = temp;
        }
        return String.valueOf(arr);
    }

}