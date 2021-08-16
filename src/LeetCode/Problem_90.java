package LeetCode;

import java.util.*;

public class Problem_90 {

    public static void main(String[] args) {
        Solution s = new Problem_90().new Solution();
        List<List<Integer>> ans = s.subsetsWithDup(new int[]{1, 2, 2, 2});
        for(List<Integer> l : ans){
            System.out.println(l.toString());
        }
    }

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            //与求排列应该是相同的
            ans.add(new ArrayList<>());
            Arrays.sort(nums);
            dfs(nums, new ArrayList<Integer>(), 0, new boolean[nums.length]);
            return ans;
        }

        void dfs(int[] nums, List<Integer> path, int idx, boolean[] vis){
            if(idx == nums.length){
                return;
            }
            for(int i = idx; i < nums.length; i++){
                //如果跟上一个数相同，且上一个数未被使用，则说明这个数在之前的同层循环中用过
                if(i != 0 && nums[i - 1] == nums[i] && !vis[i - 1]){
                    continue;
                }
                path.add(nums[i]);
                vis[i] = true;
                ans.add(new ArrayList<>(path));
                //此处的idx为i + 1，从当前位置的下一个位置开始
                dfs(nums, path, i + 1, vis);
                path.remove(path.size() - 1);
                vis[i] = false;
            }
        }
    }
}
