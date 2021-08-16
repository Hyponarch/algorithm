package LeetCode;

public class Problem_526 {
    public static void main(String[] args) {
        Solution s = new Problem_526().new Solution();
        s.countArrangement(3);
    }
    //回溯法
    class Solution {
        int ans = 0;
        public int countArrangement(int n) {
            //nums[i]是i的因子或倍数
            //质数的因子只能是1或者自己，又或者是倍数
            dfs(n, new boolean[n + 1], 0);
            return ans;
        }

        void dfs(int n, boolean[] vis, int curr){
            if(curr == n){
                ans++;
                return;
            }
            for(int i = 1; i <= n; i++){
                if(!vis[i] && (i % curr == 0 || curr % i == 0)){
                    vis[i] = true;
                    dfs(n, vis, curr + 1);
                    vis[i] = false;
                }
            }
        }
    }
}
