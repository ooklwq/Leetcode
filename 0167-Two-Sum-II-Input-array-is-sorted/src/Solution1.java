class Solution1 {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(1)
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return null;
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int other = target - numbers[i];
            int otherIndex = binarySearch(numbers, other, i + 1, n - 1);
            if (otherIndex != -1) {
                return new int[]{i + 1, otherIndex + 1};
            }
        }
        return null;
    }

    private int binarySearch(int[] numbers, int targert, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == targert) {
                return mid;
            } else if (numbers[mid] > targert) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}