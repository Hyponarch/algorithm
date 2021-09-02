package LeetCode;

public class Problem_62 {
    public static void main(String[] args) {

    }

    class Solution {
        public int uniquePaths(int m, int n) {
            //我们定义dp[i][j]为走到(i, j)的路径数
            //又由题设只能向下或者向右走，所以只能由(i-1, j)或者(i, j-1)走到(i, j)
            //所以dp[i][j] = dp[i-1][j] + dp[i][j-1]
            //边界处理，对所有的i = 0, 即dp[0][j]，只能沿着左边缘往下走，所以dp[0][j] = 1
            //同理，对dp[i][0]，只能沿着上边界走，所以dp[i][0] = 1

            int[][] dp = new int[m][n];
            //处理边界
            for(int i = 0; i < m; i++){
                dp[i][0] = 1;
            }
            //处理边界
            for (int i = 1; i < n; i++){
                dp[0][i] = 1;
            }
            //遍历处理
            for(int i = 1; i < m; i++){
                for (int j = 1; j < n; j++){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            //返回右下角目的结果
            return dp[m-1][n-1];
        }


    }
}
