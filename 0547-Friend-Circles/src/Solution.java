import java.util.HashSet;

class Solution {

    private class UnionFind1{
        private int[] id;

        public UnionFind1(int size){
            id = new int[size];
            for (int i = 0; i < size; i++) {
                id[i] = i;
            }
        }

        public int find(int p){
            if (p < 0 || p >= id.length) throw new IllegalArgumentException("p is out of bound.");
            return id[p];
        }

        public boolean isConnected(int p, int q){
            return find(p) == find(q);
        }

        public void unionElements(int p, int q){
            int pId = find(p);
            int qId = find(q);
            if (pId == qId) return;
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pId)
                    id[i] = qId;
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int size = M.length;
        UnionFind1 unionFind1 = new UnionFind1(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1)
                    unionFind1.unionElements(i, j);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(unionFind1.find(i));
        }
        return set.size();
    }
}