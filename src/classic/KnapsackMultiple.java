package classic;

/**
 * 多重背包问题，每种物品限定数量
 */
public class KnapsackMultiple {
    public static void main(String[] args) {
        System.out.println(knapsackMultipleBase(10, new int[]{2, 1, 3}, new int[]{3, 4, 3}, new int[]{4, 2, 3}));
    }

    /**
     *
     * @param v
     * @param cost
     * @param nums
     * @param value
     * @return
     */
    static int knapsackMultipleBase(int v, int[] cost, int[] nums, int[] value){
        int n = cost.length;
        int[][] dp = new int[n + 1][v + 1];
        for(int i = 1; i < n + 1; i++){
            for(int j = cost[i - 1]; j < v + 1; j++){
                for(int k = 0; k <= Math.min(nums[i - 1], j / cost[i - 1]); k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * cost[i - 1]] + k * value[i - 1]);
                }
            }
        }
        return dp[n][v];
    }

    /**
     *
     * @param v
     * @param cost
     * @param nums
     * @param value
     * @return
     */
    static int knapsackMultiple1D(int v, int[] cost, int[] nums, int[] value) {
        int n = cost.length;

        return -1;
    }
}
