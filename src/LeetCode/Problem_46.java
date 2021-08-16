package LeetCode;

import java.util.*;

public class Problem_46 {

    public static void main(String[] args) {
        Solution s = new Problem_46().new Solution();
        s.permute(new int[]{1, 2, 3});
    }

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            Set<Integer> path = new HashSet<Integer>();
            dfs(nums, ans, path);
            return ans;
        }

        void dfs(int[] nums, List<List<Integer>> ans, Set<Integer> path){
            if(path.size() == nums.length){
                ans.add(new ArrayList(path));
                return;
            }
            for(int i=0;i<nums.length;i++){
                if(path.contains(nums[i])){
                    continue;
                }
                path.add(nums[i]);
                // System.out.println(path.toString());
                dfs(nums, ans, path);
                path.remove(nums[i]);
            }
        }
    }
}
