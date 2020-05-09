import java.util.ArrayList;
import java.util.List;

class Solution3 {

    //Time Complexity: O(n)
    //在第二层循环中总共会交换n次，均摊到每一次循环为O(1)
    //Space Complexity: O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
//            if (nums[i] != nums[nums[i] - 1]){
//                //Swap(nums[i], nums[nums[i] - 1])
//                int temp = nums[nums[i] - 1];
//                nums[nums[i] - 1] = nums[i];
//                nums[i] = temp;
//                i --;
//            }
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1){
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = new Solution3().findDisappearedNumbers(nums);
        for (int num : res) {
            System.out.println(num);
        }
    }
}