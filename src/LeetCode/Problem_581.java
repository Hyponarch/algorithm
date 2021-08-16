package LeetCode;

public class Problem_581 {
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int len = nums.length;
            //左右端点均初始化为非法值（-1），来区分端点未更新的情况
            int left = -1;
            int right = -1;
            int minR = Integer.MAX_VALUE;
            int maxL = Integer.MIN_VALUE;
            //找到左端点
            for(int i = len - 1; i > -1; i--){
                //右侧有更小的数时
                if(nums[i] > minR){
                    //更新左端点
                    left = i;
                }
                //更新右侧最小值
                minR = Math.min(minR, nums[i]);
            }

            for(int i = 0; i < len; i++){
                //左侧有更大的数时
                if(nums[i] < maxL){
                    //更新右端点
                    right = i;
                }
                //更新左侧最大值
                maxL = Math.max(maxL, nums[i]);
            }
            //端点未更新时，长度为0
            return right == -1 ? 0 : right - left + 1;
        }
    }
}
