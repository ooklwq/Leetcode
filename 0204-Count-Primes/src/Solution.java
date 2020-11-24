class Solution {

    //Time Complexity: O(n^(3/2))
    //Space Complexity: O(1)
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    private boolean isPrime(int num){
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if ( num % i ==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution().countPrimes(n));
    }
}