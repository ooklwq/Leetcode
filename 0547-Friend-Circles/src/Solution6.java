class Solution6 {

    private class UnionFind  {
        private int count;
        private int[] parent;
        private int[] rank;//以i节点为根的集合的高度

        public UnionFind(int size){
            this.parent = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                this.rank[i] = 1;
                this.count = size;
            }
        }

        public int getCount() {
            return count;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public int find(int p) {
            if (p <0 || p >= parent.length)
                throw new IllegalArgumentException("p is out of bound.");
            while (p != parent[p]){
                parent[p] = find(parent[p]);
                p = parent[p];
            }
            return parent[p];
        }

        public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;

            if (rank[pRoot] < rank[qRoot]){
                parent[pRoot] = qRoot;
            }else if (rank[qRoot] < rank[pRoot]){
                parent[qRoot] = parent[pRoot];
            }else {
                parent[pRoot] = qRoot;
                rank[qRoot] +=1;
            }
            count --;
        }
    }


    public int findCircleNum(int[][] M) {
        int size = M.length;
        UnionFind unionFind = new UnionFind(size);
        //下三角
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1)
                    unionFind.unionElements(i, j);
            }
        }
        //上三角
//        for (int i = 0; i < size; i++) {
//            for (int j = i+1; j < size; j++) {
//                if (M[i][j] == 1)
//                    unionFind.unionElements(i, j);
//            }
//        }
        return unionFind.getCount();
    }
}