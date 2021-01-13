import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    //Time Complexity: O(n^3)
    //Space Complexity: O(n)
    //BFS 图的最短路径
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1;; j++) {
                    int temp = j * j + cur;
                    if (temp > n) {
                        break;
                    }
                    if (temp == n) {
                        return level + 1;
                    }
                    if (!visited.contains(temp)) {
                        queue.offer(temp);
                        visited.add(temp);
                    }
                }
            }
            level ++;
        }
        return 0;
    }
}