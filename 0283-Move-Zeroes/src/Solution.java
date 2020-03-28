import java.util.ArrayList;

class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public void moveZeroes(int[] nums) {
        //1.找到0元素个数,将非零元素按顺序存储;
        //2.将0元素放置于数组末尾。
        ArrayList<Integer> newNums = new ArrayList<>();
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }else {
                newNums.add(nums[i]);
            }
        }
        for (int i = 0; i < zeroCount; i++) {
            newNums.add(0);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums.get(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }//[1,3,12,0,0]
    }
}