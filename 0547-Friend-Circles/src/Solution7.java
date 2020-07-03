class Solution7 {

    public int findCircleNum(int[][] M) {
        int size = M.length;
        int count = 0;
        boolean[] visited = new boolean[size]; // visited[i] means whether the ith person is visited.
        for (int i = 0; i < size; i++) {
            if (!visited[i]){
                dfs(M, visited, i);
                count ++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, boolean[] visited, int i){
        for (int other = 0; other < M.length; other++) {
            if (M[i][other] == 1 && !visited[other]){
                // A person unvisited in ith person's friend circle is found.
                visited[other] = true;
                // Start to found this person's friends.
                dfs(M, visited, other);
            }
        }
    }
}