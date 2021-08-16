package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{6,2,6,5,1,2};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快速排序，基于分治法思想，每次把数组分为小于等于pivot和大于pivot的2部分
     * 递归调用，每次递归确定了一个元素（pivot）的最终位置
     * 平均时间复杂度O(nlogn)，最差为O(n^2)，为原数组有序或者逆序时，每次都把数组划分为1和len-1的两部分，每次只处理一个数
     * 递归栈的长度由logn变为n
     * @param nums  待排序数组
     * @param l 左边界，含
     * @param r 右边界，含
     */
    public static void quickSort(int[] nums, int l, int r){
        if(l < r){
            //划分当前
            int p = partition(nums, l, r);
            //递归处理左侧
            quickSort(nums, l, p - 1);
            //递归处理右侧
            quickSort(nums, p + 1, r);
        }
    }
    //将数组划分为小于等于pivot的左侧和大于pivot的右侧，并返回pivot的坐标
    static int partition(int[] nums, int l, int r){
        //以最后一个元素作为划分
        int pivot = nums[r];
        //较小元素的指针
        int p = l;
        //对所有的元素
        for(int i = l; i <= r; i++){
            //较小的被换到左侧
            if(nums[i] <= pivot){
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
                p++;
            }
        }
        return p - 1;
    }
}
