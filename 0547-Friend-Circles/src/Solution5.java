import java.util.HashSet;

class Solution5 {

    public class UnionFind6  {
        int[] parent;
        int[] rank;//以i节点为根的集合的高度

        public UnionFind6(int size){
            this.parent = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public int getSize() {
            return parent.length;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public int find(int p) {
            if (p <0 || p >= parent.length)
                throw new IllegalArgumentException("p is out of bound.");
            if (p != parent[p]){
                parent[p] = find(parent[p]);
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
        }
    }


    public int findCircleNum(int[][] M) {
        int size = M.length;
        UnionFind6 unionFind6 = new UnionFind6(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1)
                    unionFind6.unionElements(i, j);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(unionFind6.find(i));
        }
        return set.size();
    }
}