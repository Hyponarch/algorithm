package LeetCode;

import tools.ParseString;

import java.util.Arrays;

public class Problem_5739 {
    public static void main(String[] args) {
        int[] nums = new int[]{9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966};
        Solution s = new Problem_5739().new Solution();
//        System.out.println(nums.length);
        System.out.println(s.maxFrequency(nums, 3056));
        System.out.println(s.maxFrequency(new int[]{1,4,8,13}, 5));
    }
    class Solution {
        public int maxFrequency(int[] nums, int k) {
            //最多k次递增，使得nums中尽可能多的数相等
//            for(int i = 1; i < nums.length; i++){
//                for(int j = 0; j < i; j++){
//
//                }
//            }
            //有序方便计算
            Arrays.sort(nums);
            //计算2个数之间的差值，然后算差值的前缀和，找到使得区间和小于等于k的最大的区间
            int len = nums.length;
            int[] diff = new int[len];
            //diff >= 0
            for(int i = 0; i < len - 1; i++){
                diff[i] = nums[i+1] - nums[i];
            }
            //应该计算比后面的数小的量，而不是比前面数大的量
            long[] suffixSum = new long[len];

            //suffixSum >= 0
            for(int i = len - 2; i > -1; i--){
                suffixSum[i] = suffixSum[i+1] + diff[i];
            }
            long[] suffixSumSum = new long[len];
            //我们需要后缀和的后缀和
            for(int i = len - 2; i > -1; i--){
                suffixSumSum[i] = suffixSumSum[i + 1] + suffixSum[i];
            }
            //双指针遍历区间和
            int left = len - 1;
            int right = len - 1;  //取值范围0~len-1，区间宽度为right - left + 1
            int maxInterval = 1;
            while(left > -1){
                long tmp = suffixSumSum[left] - suffixSum[left] - suffixSumSum[right] - suffixSum[right];
                if(tmp <= k){
                    maxInterval = Math.max(maxInterval, right - left + 1);
                    left--;
                }else {
                    right--;
                }
            }



//            //prefixSum >= 0
//            for(int i = 1; i < len; i++){
//                prefixSum[i] = prefixSum[i-1] + diff[i];
//            }
//            long[] prefixSumSum = new long[len];
//            //我们需要前缀和的前缀和
//            for(int i = 1; i < len; i++){
//                prefixSumSum[i] = prefixSumSum[i-1] + prefixSum[i];
//            }
//            //双指针遍历区间和
//            int left = 0;
//            int right = 0;  //取值范围0~len-1，区间宽度为right - left + 1
//            int maxInterval = 1;
//            while(right < len){
//                long tmp = prefixSumSum[right] - prefixSumSum[left];
//                if(tmp <= k){
//                    maxInterval = Math.max(maxInterval, right - left + 1);
//                    right++;
//                }else {
//                    left++;
//                }
//            }
            return maxInterval;
        }
    }
}
