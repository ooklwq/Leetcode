class Solution {

    //Time Complexity: O(logk)
    //Space Complexity: O(logk)
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        if (K % 2 == 0) return kthGrammar(N-1, K/2) == 0 ? 1 : 0;
        else return kthGrammar(N-1, (K+1)/2) == 0 ? 0 : 1;
    }

    public static void main(String[] args) {
        int k = 3;
        k = ~k;
        System.out.println(k);
    }
}