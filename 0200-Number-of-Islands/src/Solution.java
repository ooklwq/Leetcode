public class Solution {
    //UF
    private class UnionFind{
        int count;
        int[] parent;
        int[] rank;
        int m, n;

        public UnionFind(char[][] grid){
            count = 0;
            m = grid.length;
            n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        parent[id] = id;
                        count ++;
                    }
                }
            }
        }

        public int getCount(){
            return count;
        }

        public int find(int p){
            if (p <0 || p >= parent.length)
                throw new IllegalArgumentException("p is out of bound.");
            while (p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
//            if (parent[p] == p){
//                return p;
//            }
//            parent[p] = find(parent[p]);
//            return parent[p];

        }

        public boolean isConnected(int p, int q){
            return find(p) == find(q);
        }

        public void unionElements(int p, int q){
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;
            if (rank[pRoot] < rank[qRoot]){
                parent[pRoot] = qRoot;
            }else {
                parent[qRoot] = pRoot;
                if (rank[pRoot] == rank[qRoot]){
                    rank[pRoot] += 1;
                }
            }
            count--;
        }


    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length ==0) return 0;
        //左右上下
//        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        //只需要判断两个方向，右下或者左上
        //上、左
        int[][] directions = {{-1,0},{0,-1}};
        UnionFind unionFind = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1'){
                    for (int[] direction: directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x >= 0 && x <rows && y >=0 && y < cols && grid[x][y] == '1'){
                            int id1 = i * cols + j;
                            int id2 = x * cols + y;
                            unionFind.unionElements(id1, id2);
                        }
                    }
                }
            }
        }
        return unionFind.getCount();
    }


}