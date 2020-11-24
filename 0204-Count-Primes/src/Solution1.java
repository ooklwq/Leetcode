class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]){
                count++;
                for (int j = 2; j * i < n ; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution1().countPrimes(n));
    }
}