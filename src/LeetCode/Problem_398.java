package LeetCode;

import java.util.*;

/**
 * @author luchenl.chen
 * email: luchenl.chen@qunar.com
 * create date: 2022/4/25 10:07
 * @version : 1.0
 * description:
 */
public class Problem_398 {

    public static void main(String[] args) {
        Solution s = new Problem_398().new Solution(new int[]{1,2,3,3,3});
        s.pick(3);
        s.pick(1);
        s.pick(3);
    }

    class Solution {
        Map<Integer, List<Integer>> index = new HashMap<>();
        public Solution(int[] nums) {
            for(int i = 0; i < nums.length; i++){
                List<Integer> indexes = index.getOrDefault(nums[i], new ArrayList<>());
                indexes.add(i);
                index.put(nums[i], indexes);
            }
        }

        public int pick(int target) {
            return index.get(target).get(new Random().nextInt(index.get(target).size()));
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
}
