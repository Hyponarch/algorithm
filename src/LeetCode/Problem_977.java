package LeetCode;

public class Problem_977 {
    class Solution {
        //本题涉及2种算法思路：1、二分搜索，2、双指针
        public int[] sortedSquares(int[] nums) {
            //判断是否有正有负，若是，则二分查找正负分界点，双指针朝2边遍历，每次比较指针所指数的平方，比较大小
            int len = nums.length;
            int[] ans = new int[len];
            int left = 0;
            int right = len - 1;
            int curr = len - 1;
            while(left < right){
                int leftNum = nums[left];
                int rightNum = nums[right];
                if(leftNum * leftNum >= rightNum * rightNum){
                    ans[curr] = leftNum;
                    left++;
                }else {
                    ans[curr] = rightNum;
                    right++;
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
