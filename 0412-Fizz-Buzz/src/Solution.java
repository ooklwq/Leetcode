import java.util.LinkedList;
import java.util.List;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public List<String> fizzBuzz(int n) {
        if (n <=0) return null;
        List<String> res = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0){
                res.add("FizzBuzz");
            }else if (i % 3 == 0){
                res.add("Fizz");
            }else if (i % 5 == 0){
                res.add("Buzz");
            }else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}