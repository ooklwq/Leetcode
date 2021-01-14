import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    //Time Complexity: O()
    //Space Complexity: O()
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals,((o1, o2) -> Integer.compare(o1[0], o2[0])));
        List<int[]> result = new LinkedList<>();
        int[] lastInterval = intervals[0];
        result.add(lastInterval);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > lastInterval[1]) {
                result.add(intervals[i]);
                lastInterval = intervals[i];
            } else {
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}