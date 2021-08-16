package LeetCode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class Problem_5 {

    public static void main(String[] args) {
        Solution s= new Problem_5().new Solution();
        s.longestPalindrome("babad");
    }

    class Solution{
        public String longestPalindrome(String s) {
            //定义dp[i][j]为s.substring(i, j+1)是否为回文串
            //如果s.charAt(i) == s.charAt(j)，则dp[i][j] = dp[i+1][j-1]
            //否则为false
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            int ans = 1;
            int start = 0;
            int end = 0;
            for(int i = 0; i < len - 1; i++){
               dp[i][i] = true;
               dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
               if(dp[i][i+1]){
                   ans = 2;
                   start = i;
                   end = i+1;
               }
            }
            dp[len-1][len-1] = true;

            for(int l = 2; l < len; l++){
                for(int i = 0; i + l < len; i++){
                    dp[i][i+l] = s.charAt(i) == s.charAt(i+l) && dp[i+1][i+l-1];
                    if(dp[i][i+l] && l > ans){
                        ans = l;
                        start = i;
                        end = i+l;
                    }
                }
            }
            return s.substring(start, end+1);
        }
    }
}
