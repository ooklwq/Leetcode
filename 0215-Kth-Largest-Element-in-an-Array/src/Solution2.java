import java.util.Random;

class Solution2 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    //Quick Select
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int res = nums.length - k;
        int l = 0, r = n - 1;
        while (true){
            int pos = partition(nums, l, r);
            if (pos == res){
                return nums[pos];
            }else if (pos < res){
                l = pos + 1;
            }else {
                r = pos - 1;
            }
        }
    }

    private int partition(int[] nums, int l, int r){
        //随机选择枢纽元素
        int randomIndex = new Random().nextInt(r-l+1) + l;
        swap(nums, l, randomIndex);
        int pivot = nums[l];
        //nums[l+1, j] < nums[l]
        //nums[j+1, i-1] > nums[l]
        int j = l;
        for (int i = l + 1; i <=r ; i++) {
            if (nums[i] < pivot){
                swap(nums, ++j, i);
            }
        }
        swap(nums, l, j);
        return j;
    }

    //双路
    private int partition2(int[] nums, int l, int r){
        //随机选择枢纽元素
        int randomIndex = new Random().nextInt(r-l+1) + l;
        swap(nums, l, randomIndex);
        int pivot = nums[l];
        int i = l + 1, j = r;
        //[l+1, i) <= pivot
        //(j, r] >= pivot
        while (i <= j){
            while (i <= j && nums[i] < pivot) i++;
            while (i <= j && nums[j] > pivot) j--;
            if (i > j) break;
            swap(nums, i++, j--);
        }
//        while (i <= j){
//            if (nums[i] > pivot && nums[j] < pivot){
//                swap(nums, i++, j--);
//            }
//            if (nums[i] <= pivot) i++;
//            if (nums[j] >= pivot) j--;
//        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(new Solution2().findKthLargest(nums, 2));
    }
}