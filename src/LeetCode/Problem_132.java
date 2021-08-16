package LeetCode;

public class Problem_132 {
    public static void main(String[] args) {
        Solution s = new Problem_132().new Solution();
        s.minCut("cabababcbc");
    }
    class Solution {
        public int minCut(String s) {
            //判断任意的2点i,j之间的字符串是否为回文串，dp
            //长度l = 1都是true，2则判断相等
            //从长度为3开始，如果s[i] == s[i+l]，则dp[i][i+l] = dp[i+1][i+l-1]
            //l有n个取值，i有n个，判断是O(1)，所以O（n^2）
            //然后依据划分的段数来遍历，从2分开始，取一个分割点，看是否满足
            int len = s.length();
            boolean[][] dp = new boolean[len][len];

            for(int i = 0; i < len - 1; i++){
                dp[i][i] = true;
                dp[i][i+1] = s.charAt(i) == s.charAt(i + 1);
            }
            dp[len-1][len-1] = true;

            for(int l = 2; l < len; l++){
                for(int i = 0; i < len - l; i++){
                    dp[i][i+l] = s.charAt(i) == s.charAt(i + l) && dp[i + 1][i + l - 1];
                }
            }
            if(dp[0][len-1]){
                return 0;
            }
            //划分点的数量，最少为1，最多为len-1
            for(int i = 1; i < len; i++){
                //划分
                if(dfs(i, 0, dp)){
                    return i;
                }

            }
            return len-1;
        }

        boolean dfs(int count, int index, boolean[][] dp){
            int len = dp.length;
            if(count == 0){
                return dp[index][len-1];
            }
            //划分位置
            for(int i = index; i < len; i++){
                if(dp[index][i]){
                    //为真立即返回，否则继续搜索
                    if(dfs(count - 1, i + 1, dp)){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
