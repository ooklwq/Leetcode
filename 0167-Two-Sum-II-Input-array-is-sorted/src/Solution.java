class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return null;
        int n = numbers.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if ( sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum > target) {
                right --;
            } else {
                left ++;
            }
        }
        return null;
    }
}