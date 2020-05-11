import java.util.PriorityQueue;

class Solution1 {

    //Time Complexity: O(nlogk)
    //Space Complexity: O(k)
    //minHeap
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || nums == null) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int num : nums){
            if (pq.size() < k) pq.add(num);
            else if (num > pq.peek()){
                pq.remove();
                pq.add(num);
            }

        }
        return pq.peek();
    }

}