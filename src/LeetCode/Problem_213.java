package LeetCode;

public class Problem_213 {
    public static void main(String[] args) {
        Solution s = new Problem_213().new Solution();
        s.rob(new int[]{1, 2, 3, 1});
    }
    class Solution {
        public int rob(int[] nums) {
            //特殊处理，取了第一不能取最后
            //dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            int len = nums.length;
            if(len == 1){
                return nums[0];
            }
            if(len == 2){
                return Math.max(nums[0], nums[1]);
            }
            int[] dp = new int[len];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            boolean contain1st = false;
            if(nums[0] > nums[1] || nums[2] + nums[0] > nums[1]){
                contain1st = true;
            }
            int[] dp1 = new int[len];
            dp1[1] = nums[1];
            for(int i = 2; i < len; i++){
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
                if(i == len - 1 && contain1st){
                    continue;
                }
                dp[i] =  Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
            return Math.max(dp[len - 1], Math.max(dp1[len - 1], dp[len - 2]));
        }
    }
}
