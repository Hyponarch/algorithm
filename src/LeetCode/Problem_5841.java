package LeetCode;

import java.util.Arrays;

public class Problem_5841 {
    public static void main(String[] args) {
        Solution s = new Problem_5841().new Solution();
//        System.out.println(Arrays.toString(s.longestObstacleCourseAtEachPosition(new int[]{1, 2, 3, 2})));
//        System.out.println(Arrays.toString(s.longestObstacleCourseAtEachPosition(new int[]{2,2,1})));
        System.out.println(Arrays.toString(s.longestObstacleCourseAtEachPosition(new int[]{3, 1, 5, 6, 4, 2})));

    }
    class Solution {
        //最大递增子序列
        public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
            //dp[i]表示长度为i + 1的子序列的最小后缀
            int[] ans = new int[obstacles.length];
            ans[0] = 1;
            int[] dp = new int[obstacles.length + 1];
            dp[1] = obstacles[0];
            //obstacles[i]找到左侧小于等于它的最长队列
            //单调栈？
            int maxLen = 1;
            for(int i = 1; i < obstacles.length; i++){
                //如果能延长最长递增子序列
                if(obstacles[i] >= dp[maxLen]){
                    maxLen++;
                    dp[maxLen] = obstacles[i];
                    ans[i] = maxLen;
                }else { //如果不能，则二分查找 小于等于obstacles[i]的最大元素右侧的位置
//                    int l = 1;
//                    int r = maxLen;
//                    int pos = 0;
//                    while (l < r){
//                        int mid = (l + r) >> 1;
//                        if(dp[mid] <= obstacles[i]){
//                            pos = mid;
//                            l = mid + 1;
//                        }else {
//                            r = mid - 1;
//                        }
//                    }
//                    dp[pos + 1] = obstacles[i];
//                    ans[i] = pos + 1;
                    int index = binarySearch(dp, 0, maxLen, obstacles[i]);
                    //为什么不用判断？
                    dp[index + 1] = obstacles[i];
                    ans[i] = index;
                }
            }
//            int[] ans = new int[maxLen];
//            for(int i = 0; i < ans.length; i++){
//                ans[i] =
//            }
            return ans;

        }
        int binarySearch(int[] dp, int left, int right, int target){
            if(left > right){
                return left;
            }
            int mid = left + (right - left) / 2;
            if(dp[mid] <= target){
                //即使相等也不保留mid
                return binarySearch(dp, mid + 1, right, target);
            }else {
                return binarySearch(dp, left, mid - 1, target);
            }

        }
    }
}
