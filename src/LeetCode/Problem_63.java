package LeetCode;

public class Problem_63 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            //合计要走m+n-2步，其中m-1步向右，n-1步向下
            //不考虑障碍物会有C(m+n-2)(m-1)种路径
            //而有障碍物，会损失障碍物到终点的距离，替换m和n即可
            //避免重复计算可以用数组记录结果，
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            long total = combine(m - 1, n - 1);
            for(int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if(obstacleGrid[i][j] == 1){
                        total -= combine(m + n - 2 - i - j, m - 1 - i);
                    }
                }
            }
            return (int)total;
        }
        long combine(int m, int n){
            long ans = 1;
            for(int i = 1; i <= n; i++){
                ans = ans * (m - n + i) / i;
            }
            return ans;
        }
    }

}
