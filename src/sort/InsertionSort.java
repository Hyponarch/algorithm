package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1,33,4,8,3,7,2,7,9};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(binarySearchInsertIdx(nums, 2, 0, nums.length - 1));
        System.out.println(binarySearchInsertIdx(nums, 5, 0, nums.length - 1));
        System.out.println(binarySearchInsertIdx(nums, 10, 0, nums.length - 1));
    }
    /**
     * 将新的数字加入已排序的子数组中
     * 目标是找到新数字在已排序部分中的位置
     * 可以通过二分查找进行优化
     * @param nums  待排序数组
     */
    static void insertionSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int key = nums[i];
            //将key插入nums[0...i-1]中，因为nums[0...i-1]是有序的
//            int j = i - 1;
            //如果j还没走到数组头部，并且当前位置的值还比key大，线性查找
//            while(j > 0 && key < nums[j]){
//                //将当前位置的数往后移动
//                nums[j + 1] = nums[j];
//                j--;
//            }
//            nums[j + 1] = key;

            //二分查找，减少比较次数，但是移动的操作少不了
            int idx = binarySearchInsertIdx(nums, key, 0, i - 1);
            //后移
            for(int j = i - 1; j >= idx; j--){
                nums[j + 1] = nums[j];
            }
            //将key赋值给找到的位置
            nums[idx] = key;
        }
    }
    static int binarySearchInsertIdx(int[] nums, int target, int l, int r){
        if(l > r){
            return l;
        }
        int m = l + ( r - l ) / 2;
        if(nums[m] < target){
            return binarySearchInsertIdx(nums, target, m + 1, r);
        }else{
            //在查找插入位置时
            return binarySearchInsertIdx(nums, target, l, m - 1);
        }
    }
}
