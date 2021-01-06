class Solution {

    //Time Complexity: O(nlogM) M为maxPile
    //Space Complexity: O(1)
    public int minEatingSpeed(int[] piles, int H) {
        if (piles == null || piles.length == 0) {
            return 0;
        }
        int maxPile = getMaxPile(piles);
        int left = 1, right = maxPile;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, mid, H)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canEatAll(int[] piles, int k, int H){
        int countHours = 0;
        for (int pile : piles) {
            countHours += pile / k;
            if (pile % k != 0) {
                countHours ++;
            }
        }
        return countHours <= H;
    }

    private int getMaxPile(int[] piles) {
        int max = piles[0];
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}