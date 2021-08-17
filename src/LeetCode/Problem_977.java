package LeetCode;

import java.util.Arrays;

public class Problem_977 {
    public static void main(String[] args) {
        Solution s = new Problem_977().new Solution();
        System.out.println(Arrays.toString(s.sortedSquares1(new int[]{-4, -1, 0, 3, 10})));
    }
    //题解地址：
    class Solution {
        //解法1，找平方后最大的数，从两头向中间遍历
        public int[] sortedSquares(int[] nums) {
            //无论数字的正负，平方之后最大的数，一定是最左（最小负数）或者最右（最大整数）之一
            int len = nums.length;
            int[] ans = new int[len];
            //左指针
            int left = 0;
            //右指针
            int right = len - 1;
            //ans数组的指针，每次将最大的数写入数组的后部
            int curr = len - 1;
            while(left < right){
                //分别计算最左和最右的平方
                int leftNum = nums[left] * nums[left];
                int rightNum = nums[right] * nums[right];
                //取较大值
                //左侧较大时
                if(leftNum >= rightNum){
                    ans[curr] = leftNum;
                    //左指针右移
                    left++;
                }else { //右侧较大时
                    ans[curr] = rightNum;
                    //右指针左移
                    right--;
                }
                //ans指针左移
                curr--;
            }
            return ans;
        }

        // 解法2，找到正负分解点，从中间开始向两边遍历，可以从小到大获得答案
        // 解法2涉及二分搜索
        //判断是否有正有负，若是，则二分查找正负分界点，双指针朝2边遍历，每次比较指针所指数的平方，比较大小
        public int[] sortedSquares1(int[] nums) {
            int len = nums.length;
            int[] ans = new int[len];

            if(nums[0] < 0){
                //有正有负
                if(nums[len - 1] > 0){
                    //二分查找大于等于0的第一个数的下标
                    int index = binarySearch(nums, 0);
                    int left = index - 1;
                    int right = index;
                    int curr = 0;
                    //只要左右指针有一个还没到达边界
                    while (left > -1 || right < len){
                        //如果右侧到达边界，或者左侧更小
                        if(left > -1 && (right == len || nums[left] * nums[left] <= nums[right] * nums[right])){
                            //则选择左侧数的平方
                            ans[curr] = nums[left] * nums[left];
                            left--;
                        }else {
                            ans[curr] = nums[right] * nums[right];
                            right++;
                        }
                        curr++;
                    }
                }else { //全负
                    for(int i = 0; i < len; i++){
                        ans[i] = nums[len - 1 - i] * nums[len - 1 - i];
                    }
                }
            }else { //全正
                for(int i = 0; i < len; i++){
                    ans[i] = nums[i] * nums[i];
                }
            }
            return ans;
        }
        /**
         * 二分查找大于等于target的最左位置
         * @param nums  有序待查询数组
         * @param target    目标数
         * @return  最左插入位置
         */
        int binarySearch(int[] nums, int target){
            //左闭右开区间
            int left = 0;
            int right = nums.length;
            while(left < right){
                //这种写法相比mid = (left + right) / 2的优势是可以避免溢出，如果right > left > Integer.MAX_VALUE / 2，则
                //right + left > Integer.MAX_VALUE，发生溢出，但是left + (right - left) / 2则不会
                int mid = left + (right - left) / 2;
                //target > 中位数时，继续搜索右半区间
                if(target > nums[mid]){
                    left = mid + 1;
                }else { //否则搜索左半区间
                    right = mid;
                }
                //注意上面left = mid + 1和right = mid的写法，配合左闭右开区间，可以做到：
                // 1、无论是否有等于target的值
                // 2、无论是否有重复值
                // 都找到大于等于target的下界（也就是插入排序中target的最左插入位置），如果要判断是否存在等于target的数
                //只需要判断nums[returnValue] == target即可
            }
            //最后left == right，无论是返回left或是right都可以
            return left;
        }
    }
}
