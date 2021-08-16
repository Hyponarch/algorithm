package LeetCode;

import java.util.*;

public class Problem_377 {
    public static void main(String[] args) {
        Solution s = new Problem_377().new Solution();
        System.out.println(s.combinationSum4(new int[]{1,2,3}, 4));
    }
    class Solution {
        int ans = 0;
        List<Integer> factorial;
        public int combinationSum4(int[] nums, int target) {
            factorial = factorial();
            //排序
            Arrays.sort(nums);
            dfs(nums, target, new HashMap<Integer, Integer>(), 0, 0);
            return ans;
        }
        //先求组合，然后由组合得到排列数
        void dfs(int[] nums, int target, Map<Integer, Integer> path, int sum, int idx){
            if(sum == target){
                int total = 0;  //元素个数
                long repeatFac = 1; //多次出现的元素的排列数之积
                for(Integer val : path.values()){
                    total += val;
                    repeatFac *= factorial.get(val);
                }
                System.out.println(factorial.get(total) / repeatFac);
                ans += factorial.get(total) / repeatFac;
                return;
            }
            //求组合时，最多可以使用当前的元素，不能使用之前的元素，因为会导致重复
            for(int i = idx; i < nums.length; i++){
                //保证升序的情况下，某个元素加上sum大于target，那之后的数也会大于
                if(sum + nums[i] > target){
                    break;
                }
                int freq = path.getOrDefault(nums[i], 0);
                path.put(nums[i], freq + 1);
                dfs(nums, target, path, sum + nums[i], i);
                path.put(nums[i], freq);
            }
        }
        List<Integer> factorial(){
            int count = 1;
            long res = 1;
            List<Integer> ans = new ArrayList<>();
            while(res < Integer.MAX_VALUE){
                ans.add((int)res);
                res *= count++;
            }
            return ans;
        }
    }
}
