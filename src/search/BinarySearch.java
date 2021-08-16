package search;

import sort.QuickSort;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1,33,4,8,3,7,2,7,9};
        QuickSort.quickSort(nums, 0, nums.length);
        binarySearchRecursion(nums, 7, 0, nums.length);
    }

    /**
     * 二分查找，递归实现，左闭右开区间，从闭区间侧靠近（l = mid + 1）
     * @param nums  已排序的数组
     * @param target    搜索的目标
     * @param l 左边界，含
     * @param r 右边界，不含
     * @return  target的下标，不存在则返回-1
     */
    static int binarySearchRecursion(int[] nums, int target, int l, int r){
        if(l == r){
            return -1;
        }
        int m = l + ( r - l ) / 2;
        //这样是返回第一个找到的target的下标
        if(nums[m] == target){
            return m;
        }else if(target < nums[m]){
            return binarySearchRecursion(nums, target, l, m);
        }else {
            return binarySearchRecursion(nums, target, m + 1, r);
        }
    }

    /**
     * 二分查找，迭代实现，左闭右开区间，从闭区间侧靠近（l = mid + 1）
     * @param nums  已排序的数组
     * @param target    搜索的目标
     * @return  大于等于target的最左下标（即执行插入排序时的位置），验证是否找到，只需要比较target和nums[returnValue]即可
     */
    static int binarySearchIteration(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
