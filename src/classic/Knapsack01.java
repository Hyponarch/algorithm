package classic;

/**
 * 01背包问题，每种物品各有一个，也就是放与不放两种状态
 * 有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。
 * 求解将哪些物品装入背包可使价值总和最大。
 * 状态定义dp[i][j]表示前i件物品放入容量为j的背包中能获得的最大价值
 * 状态转移方程dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - c[i]] + w[i])
 * 前者为不选当前（第i件）物品，后者为选当前物品，则会消耗c[i]容量，而得到w[i]的价值，剩余容量全部选前i-1件物品
 */
public class Knapsack01 {
    public static void main(String[] args) {
        //
        System.out.println(maxValue1(4, new int[]{2, 1, 3}, new int[]{4, 2, 3}));
    }

    /**
     * 时间与空间复杂度均为O(VN)
     * @param v
     * @param cost
     * @param value
     * @return
     */
    static int maxValue(int v, int[] cost, int[] value){
        int n = cost.length;
        int[][] dp = new int[n + 1][v + 1]; //0代表不选商品的情况，避免边界讨论,v的取值范围为0~v

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < v + 1; j++){
                //当前物品的重量大于容量，无法放入
                if(cost[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - cost[i-1]] + value[i-1]);
                }
            }
        }
        return dp[n][v];
    }

    /**
     * 空间优化，用一维数组来保存结果
     * @param v
     * @param cost
     * @param value
     * @return
     */
    static int maxValue1(int v, int[] cost, int[] value){
        int n = cost.length;
        int[] dp = new int[v + 1];
        for(int i = 1; i < n + 1; i++){
            //状态转移方程会用到一个更小的dp，而j从大往小遍历，可以保证使用的是i-1时候的状态
            //先更新j较大的dp，再更新j较小的dp，这样可以保证总是使用i-1（前一状态）的dp值
            //如果从小往大遍历，则会导致j较小的dp被更新，而较大j的dp更新时会使用dp[j - c[i]]，这是i的dp值
//            for(int j = v; j >= 0; j--){
//                if(cost[i - 1] > j){
//                    dp[j] = dp[j];
//                }else {
//                    dp[j] = Math.max(dp[j], dp[j - cost[i - 1]] + value[i - 1]);   //此处无论是dp[j]还是dp[j - c[i]]都是i-1的值
//                }
//
//            }
            //容量小于cost[i]则i不可能放进去，所以只需要遍历v~cost[i]即可，并且可以省去判断
            for(int j = v; j >= cost[i - 1]; j--){
                dp[j] = Math.max(dp[j], dp[j - cost[i - 1]] + value[i - 1]);
            }
        }
        return dp[v];
    }
}
