class Solution {

    //Time Complexity: O(logn)
    //Space Complexity: O(1)
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0) {
            return ' ';
        }
        int n = letters.length;
        if (target >= letters[n - 1]) {
            return letters[0];
        }
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return letters[left];
    }
}