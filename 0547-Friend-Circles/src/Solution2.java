import java.util.HashSet;

class Solution2 {

    public class UnionFind3 {
        int[] parent;
        int[] size;//以i节点为根的集合的节点数

        public UnionFind3(int size){
            this.parent = new int[size];
            this.size = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                this.size[i] = 1;
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
            while (p != parent[p])
                p = parent[p];
            return parent[p];
        }


        public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;

            if (size[pRoot] < size[qRoot]){
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }else {
                parent[qRoot] = parent[pRoot];
                size[pRoot] += size[qRoot];
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int size = M.length;
        UnionFind3 unionFind3 = new UnionFind3(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1)
                    unionFind3.unionElements(i, j);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(unionFind3.find(i));
        }
        return set.size();
    }
}