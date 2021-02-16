import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Solution {

    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            for (int j : rooms.get(i)) {
                if (!seen.contains(j)) {
                    stack.push(j);
                    seen.add(j);
                    if (seen.size() == rooms.size()) {
                        return true;
                    }
                }

            }
        }
        return seen.size() == rooms.size();
    }
}