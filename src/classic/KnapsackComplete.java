package classic;

/**
 * 完全背包问题
 * 每件物品的数量都是无限的
 */
public class KnapsackComplete {
    public static void main(String[] args) {
        System.out.println(knapsackCompleteBase(8, new int[]{3, 2, 4}, new int[]{6, 3, 7}));
        System.out.println(knapsackComplete1D(8, new int[]{3, 2, 4}, new int[]{6, 3, 7}));
    }

    /**
     * 基本思路
     * 时间复杂度O(V*N*v/cost)
     * @param v
     * @param cost
     * @param value
     * @return
     */
    static int knapsackCompleteBase(int v, int[] cost, int[] value){
        int n = cost.length;
        int[][] dp = new int[n + 1][v + 1];
        for(int i = 1; i < n + 1; i++){
            //不选第i件物品已经被考虑过了（i = i -1时，是只考虑前i-1件物品的结果）
            for(int j = cost[i - 1]; j < v + 1; j++){
                //每件物品最多选择j/cost[i - 1]件，k表示当前物品取用的件数
                //为什么一定要从0开始？从1开始会错
                for(int k = 0; k <= j / cost[i - 1]; k++){
                    //p[i - 1][j - k * cost[i - 1]] + k * value[i - 1]代表选k件i能达到最大的dp[i][j]
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * cost[i - 1]] + k * value[i - 1]);
                }
            }
        }
        return dp[n][v];
    }

    /**
     * 使用1维数组的优化
     * 时间复杂度O(VN)
     * @param v
     * @param cost
     * @param value
     * @return
     */
    static int knapsackComplete1D(int v, int[] cost, int[] value){
        int n = cost.length;
        int[] dp = new int[v + 1];
        for(int i = 1; i < n + 1; i++) {
            //j必须从小到大遍历，因为在随着j增大的过程，包含了选取若干次i的可能性
            //而保证j增大的过程中，能覆盖取i的所有可能性，是因为j的增长率（1）是小于等于i的增长率（cost[i]）的
            //从cost[i]开始遍历，小于cost[i]的j，是不取i的情况，已经考虑过了
            for (int j = cost[i - 1]; j < v + 1; j++) {
                dp[j] = Math.max(dp[j], dp[j - cost[i - 1]] + value[i - 1]);
            }
        }
        return dp[v];
    }
}
