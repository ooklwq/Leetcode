import java.util.LinkedList;
import java.util.List;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public List<String> fizzBuzz(int n) {
        if (n <=0) return null;
        List<String> res = new LinkedList<>();
        int fizz = 0, buzz = 0;
        for (int i = 1; i <= n; i++) {
            buzz ++;
            fizz ++;
            if (fizz == 3 && buzz == 5){
                res.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            }else if (fizz == 3){
                res.add("Fizz");
                fizz = 0;
            }else if (buzz == 5){
                res.add("Buzz");
                buzz = 0;
            }else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}