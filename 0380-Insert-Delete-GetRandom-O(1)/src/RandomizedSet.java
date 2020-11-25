import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

    private ArrayList<Integer> nums;
    private HashMap<Integer, Integer> pos;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        pos = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (pos.containsKey(val)) return false;
        nums.add(val);
        pos.put(val, nums.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!pos.containsKey(val)) return false;
        int loc = pos.get(val);
        if (loc != nums.size() - 1){
            int last = nums.get(nums.size() - 1);
            nums.set(loc, last);
            pos.put(last, loc);
        }
        nums.remove(nums.size() - 1);
        pos.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(new Random().nextInt(nums.size()) );
    }
}

