package LeetCode;

/**
 * @author luchenl.chen
 * email: luchenl.chen@qunar.com
 * date: 2021/8/12 14:33
 * description:
 * @version : 1.0
 */
public class Problem_516 {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            //状态定义：dp[i][j]表示子串s.substring(i, j + 1)，最大的回文子序列长度
            //状态转移：dp[i][j] = dp[i+1][j-1] + 2 , 当s.charAt(i) == s.charAt(j)时
            //否则dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
            //将大问题归纳成更小的问题
            int len = s.length();
            int[][] dp = new int[len][len];
            //初始化
            for(int i = 0; i < len; i++){
                dp[i][i] = 1;
            }
            //按长度遍历
            for(int l = 2; l <= len; l++){
                //i为起点，i+l-1为终点
                for(int i = 0; i + l - 1 < len; i++){
                    if(s.charAt(i) == s.charAt(i + l - 1)){
                        dp[i][i+l-1] = dp[i+1][i+l-2] + 2;
                    }else {
                        dp[i][i+l-1] = Math.max(dp[i+1][i+l-1], dp[i][i+l-2]);
                    }
                }
            }
            return dp[0][len - 1];
        }
    }
}
