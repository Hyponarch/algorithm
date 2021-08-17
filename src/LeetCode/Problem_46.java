package LeetCode;

import java.util.*;

public class Problem_46 {

    public static void main(String[] args) {
        Solution s = new Problem_46().new Solution();
        s.permute(new int[]{1, 2, 3});
    }
    //本题是最经典的回溯法（或者说是深度优先遍历DFS）题之一
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            //用于保存DFS时递归的路径
            List<Integer> path = new ArrayList<>();
            //记录已访问的节点
            boolean[] vis = new boolean[nums.length];
            dfs(nums, ans, path, vis);
            return ans;
        }

        /**
         *
         * @param nums  题设数组
         * @param ans   保存答案的List，java可以改变引用变量的内容，但不能改变引用本身，因此可以通过引用变量来保存结果，另一种方式则是通过全局变量来保存
         * @param path  递归的路径
         * @param vis   记录节点被访问了
         */
        void dfs(int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] vis){
            //递归终止条件
            if(path.size() == nums.length){
                ans.add(new ArrayList<>(path));
                return;
            }
            //遍历所有的数
            for (int i = 0; i < nums.length; i++) {
                //如果访问过则跳过
                if (vis[i]) {
                    continue;
                }
                //如果未访问过，当前访问了nums[i]，则在vis[i]中记录
                path.add(nums[i]);
                vis[i] = true;
                dfs(nums, ans, path, vis);
                //回溯到这一步时，删除i的访问记录
                path.remove(path.size() - 1);
                vis[i] = false;
            }
        }
    }
}
