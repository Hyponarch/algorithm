package LeetCode;

public class Problem_718 {
    public static void main(String[] args) {
        Solution s = new Problem_718().new Solution();

    }
    //dp
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            //dp[i][j]表示以nums1[i]和nums2[j]开头的公共子数组的长度
            int[][] dp = new int[m][n];
            //倒序处理，状态转移方程dp[i][j] = nums1[i] == nums2[j] ? dp[i+1][j+1] : 0;
            //处理边界，nums2取nums2[n-1]时
            int ans = 0;
            for(int i = 0; i < m; i++){
                if(nums1[i] == nums2[n-1]){
                    dp[i][n-1] = 1;
                    ans = Math.max(ans, dp[i][n-1]);
                }
            }
            //处理边界，nums1取nums1[m-1]时
            for(int j = 0; j < n; j++){
                if(nums1[m-1] == nums2[j]){
                    dp[m-1][j] = 1;
                    ans = Math.max(ans, dp[m-1][j]);
                }
            }
            //一般情况
            for(int i = m - 2; i > -1; i--){
                for(int j = n - 2; j > -1; j--){
                    if(nums1[i] == nums2[j]){
                        dp[i][j] = dp[i+1][j+1] + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
            return ans;
        }
    }
    //dp，增加一位避免边界讨论
    class Solution1 {
        public int findLength(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            //dp[i][j]表示以nums1[i]和nums2[j]开头的公共子数组的长度
            int[][] dp = new int[m+1][n+1];
//            dp[m][n] = 0;
            //倒序处理，状态转移方程dp[i][j] = nums1Extend[i] == nums2Extend[j] ? dp[i+1][j+1] : 0;
            //处理边界，nums2取nums2[n-1]时
            int ans = 0;
            //一般情况
            for(int i = m - 1; i > -1; i--){
                for(int j = n - 1; j > -1; j--){
                    if(nums1[i] == nums2[j]){
                        dp[i][j] = dp[i+1][j+1] + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
            return ans;
        }
    }
}
