package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        System.out.println(1 - 9.0 / 10);

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

    /**
     * 快排的核心处理步骤，选取划分值pivot，并将当前子数组划分为小于等于pivot的部分和大于pivot的部分，由此我们确定了pivot的最终下标
     * @param nums  待排序数组
     * @param l 当前子数组左边界，含
     * @param r 当前子数组有边界，含
     * @return  pivot在经过划分后的下标，取决于小于等于pivot的数字的个数，也是pivot在有序数组的实际下标
     */
    static int partition(int[] nums, int l, int r){
        //以最后一个元素作为pivot
//        int pivot = nums[r];
        //随机选取pivot
        int pivotIndex = (int)(Math.random() * (r - l + 1)) + l;
        int pivot = nums[pivotIndex];
        //并交换到最后一个位置，避免遍历过程中pivot被移动到其他位置
        nums[pivotIndex] = nums[r];
        nums[r] = pivot;
        //较小元素的指针
        int p = l;
        //对所有的元素
        for(int i = l; i <= r; i++){
            //将较小的元素换到左侧的p下标
            if(nums[i] <= pivot){
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
                //p指针右移
                p++;
            }
        }
        return p - 1;
    }


}
