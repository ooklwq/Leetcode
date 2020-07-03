import java.util.HashSet;

class Solution1 {

    public class UnionFind2  {
        int[] parent;

        public UnionFind2(int size){
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
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
            parent[pRoot] = qRoot;
        }
    }


    public int findCircleNum(int[][] M) {
        int size = M.length;
        UnionFind2 unionFind2 = new UnionFind2(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1)
                    unionFind2.unionElements(i, j);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(unionFind2.find(i));
        }
        return set.size();
    }
}