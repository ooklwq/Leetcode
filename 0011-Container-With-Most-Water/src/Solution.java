class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            res = Math.max(res, h * (right - left));
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return res;
    }
}