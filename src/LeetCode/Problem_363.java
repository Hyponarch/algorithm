package LeetCode;

import tools.ParseString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem_363 {
    public static void main(String[] args) {
        //[[5,-4,-3,4],[-3,-4,4,5],[5,1,5,-4]]
        //8

        int[][] matrix = ParseString.stringToArrArr("[[27,5,-20,-9,1,26,1,12,7,-4,8,7,-1,5,8]," +
                "[16,28,8,3,16,28,-10,-7,-5,-13,7,9,20,-9,26],[24,-14,20,23,25,-16,-15,8,8,-6,-14,-6,12,-19,-13]," +
                "[28,13,-17,20,-3,-18,12,5,1,25,25,-14,22,17,12],[7,29,-12,5,-5,26,-5,10,-5,24,-9,-19,20,0,18]," +
                "[-7,-11,-8,12,19,18,-15,17,7,-1,-11,-10,-1,25,17],[-3,-20,-20,-7,14,-12,22,1,-9,11,14,-16,-5,-12,14]," +
                "[-20,-4,-17,3,3,-18,22,-13,-1,16,-11,29,17,-2,22],[23,-15,24,26,28,-13,10,18,-6,29,27,-19,-19,-8,0]," +
                "[5,9,23,11,-4,-20,18,29,-6,-4,-11,21,-6,24,12],[13,16,0,-20,22,21,26,-3,15,14,26,17,19,20,-5]," +
                "[15,1,22,-6,1,-9,0,21,12,27,5,8,8,18,-1],[15,29,13,6,-11,7,-6,27,22,18,22,-3,-9,20,14]," +
                "[26,-6,12,-10,0,26,10,1,11,-10,-16,-18,29,8,-8],[-19,14,15,18,-10,24,-9,-7,-19,-14,23,23,17,-5,6]]");
        Map<Integer, Integer> m = new HashMap<>();
        m.values();
        int k = -100;
        Solution s = new Problem_363().new Solution();
        System.out.println(s.maxSumSubmatrix(matrix, k));
    }
    class Solution {
        /**
         * 加一位可以避免边界讨论
         * @param matrix
         * @param k
         * @return
         */
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int min = Integer.MAX_VALUE;
            //dp[i][j]代表[0][0]~[i][j]矩形内的数值和
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = matrix[0][0];
            //前缀和可能是负数，所以ans初始值需要取Integer.MIN_VALUE
            int ans = dp[0][0] <= k ? dp[0][0] : Integer.MIN_VALUE;
            for(int i = 1; i < m; i++){
                dp[i][0] = dp[i-1][0] + matrix[i][0];
                if(dp[i][0] == k){
                    return k;
                }
                if(dp[i][0] < k){
                    ans = Math.max(ans, dp[i][0]);
                }
            }
            for(int i = 1; i < n; i++){
                dp[0][i] = dp[0][i-1] + matrix[0][i];
                if(dp[0][i] == k){
                    return k;
                }
                if(dp[0][i] < k){
                    ans = Math.max(ans, dp[0][i]);
                }
            }
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    dp[i][j] = matrix[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
                    if(dp[i][j] == k){
                        return k;
                    }
                    if(dp[i][j] < k){
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
            //求的是任意两点确定的矩形区域，也就是有n^2个起点，n^2个终点
            //需要考虑起点在边缘（非原点）的情况
            //col = 0时
            for(int i = 1; i < m; i++){
                for(int h = i; h <m; h++){
                    for(int l = 0; l < n; l++){
                        int currSum = dp[h][l] - dp[i-1][l];
                        min = Math.min(min, currSum);
                        if(currSum == k){
                            return k;
                        }
                        if(currSum < k){
                            ans = Math.max(ans, currSum);
                        }
                    }
                }
            }
            //row = 0
            for(int j = 1; j < n; j++){
                for(int h = 0; h < m; h++){
                    for(int l = j; l < n; l++){
                        int currSum = dp[h][l] - dp[h][j-1];
                        min = Math.min(min, currSum);
                        if(currSum == k){
                            return k;
                        }
                        if(currSum < k){
                            ans = Math.max(ans, currSum);
                        }
                    }
                }
            }
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    for(int h = i; h < m; h++){
                        for(int l = j; l < n; l++){
                            int currSum = dp[h][l] - dp[i-1][l] - dp[h][j-1] + dp[i-1][j-1];
                            min = Math.min(min, currSum);
                            if(currSum == k){
                                return k;
                            }
                            if(currSum < k){
                                ans = Math.max(ans, currSum);
                            }
                        }
                    }
                }
            }
            System.out.println(min);
            return ans == Integer.MIN_VALUE ? -1 : ans;
        }
    }
}
