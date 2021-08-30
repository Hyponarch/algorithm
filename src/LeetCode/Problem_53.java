package LeetCode;

public class Problem_53 {
    class Solution {
        //引子：前缀和
        //给定数列nums，0 < n < len，对所有的n求数列的前n项和

        //暴力解法
        public int[] prefixSum1(int[] nums){
            int len = nums.length;
            int[] prefixSum = new int[len];
            //对每一个ans[i]
            for(int i = 0; i < len; i++){
                //从nums[0]~nums[i]，累加，得前i项和
                for(int j = 0; j <= i; j++){
                    prefixSum[i] += nums[j];
                }
            }
            return prefixSum;
        }
        //时间复杂度O(n^2)
        //暴力法中，我们计算前n项和时
        //prefixSum[i] = nums[i] + nums[i-1] + ... + nums[1] + nums[0]
        //而prefixSum[i-1] = nums[i-1] + nums[i-1] + ... + nums[1] + nums[0]
        //我们在计算prefixSum[i-1]的时候，就计算了一遍nums[0]~nums[i-1]的和，而计算prefixSum[i]的时候又计算了一遍nums[0]~nums[i-1]的和
        //这意味着nums[0]~nums[i-1]的和是重复计算，我们只需要保存这个结果，在计算prefixSum[i]的时候，就只需要计算这个结果与nums[i]的和即可
        //这就是动态规划中保存重复子问题的解，来避免重复计算的思想

        //动态规划，O(n)时间复杂度实现前缀和
        public int[] prefixSum(int[] nums){
            int len = nums.length;
            //dp[i]表示前i项的和
            int[] dp = new int[len];
            //边界条件
            dp[0] = nums[0];
            for(int i = 1; i < len; i++){
                //状态转移方程
                dp[i] = dp[i-1] + nums[i];
            }
            return dp;
        }

        //前缀和的应用：求任意区间和，思考一下如何由前缀和快速计算区间和intervalSum[i][j]

        //dp的三个步骤：
        //(1)状态定义：我们需要用dp数组来保存什么信息，才能让我们求解下一个问题时，避免重复步骤，即dp[i]表示什么
        //(2)状态转移方程，当前状态，如何由之前已求解的状态得到，dp[i]如何由dp[i-1]、dp[i-2]...、dp[0]得到
        //(3)边界处理，比如说斐波那契数列可以表示为dp[i] = dp[i-1] + dp[i-2]，一个数由前2个数之和得到，而0或1的前面是没有2个数的，所以
        //dp[0]和dp[1]需要单独处理


        //动态规划，前缀和思路
        public int maxSubArray(int[] nums) {
            int len = nums.length;

            //状态定义：dp[i]表示以nums[i]结尾的连续子数组的最大和
            int[] dp = new int[len];
            int maxSum = nums[0];
            //边界处理
            dp[0] = nums[0];
            for(int i = 1; i < len; i++){
                //状态转移方程：(1)如果前一个位置的最大和dp[i-1]大于0，那么当前位置结束的子数组最大和dp[i]就应该由当前元素nums[i]加上dp[i-1]
                //(2)否则，dp[i] = nums[i]，因为dp[i-1] <= 0 的话，nums[i]加上它也不会变大
                if(dp[i-1] > 0){
                    dp[i] = dp[i-1] + nums[i];
                }else {
                    dp[i] = nums[i];
                }
                maxSum = Math.max(maxSum, dp[i]);
            }
            return maxSum;
        }
    }
}

