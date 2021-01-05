//fake class, ignore implementation
class GuessGame{
    int guess(int num){
        return num;
    }
}

public class Solution extends GuessGame {

    /**
     * Forward declaration of guess API.
     * @param  n   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */
    public int guessNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int left = 0, right = n;
        while (true) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
}