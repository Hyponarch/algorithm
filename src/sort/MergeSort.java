package sort;

import java.util.Arrays;

/**
 * 归并排序
 * 基于分治（divide-and-conquer）思想
 * 先划分、再治理、最后合并
 * 自底向上的分治法与递归调用的顺序是相同的。先调用的方法后处理，这也是栈的结构，同时，也是DFS中的后续遍历的处理顺序
 * 先计算孩子节点，再利用孩子节点的结果计算父节点
 */
public class MergeSort {
    public static void main(String[] args){
        int[] nums = new int[]{5,Integer.MAX_VALUE,Integer.MAX_VALUE,2,52,32,65,2,765,8,Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] test = new int[]{1,2,3};
        //覆盖原数组中length长度的元素
        System.arraycopy(test, 0, nums, 2, 3);
        System.out.println(Arrays.toString(nums));
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 递归定义划分（divide）
     * @param nums  待排序数组
     * @param left 左端点
     * @param right 右端点
     */
    static void mergeSort(int[] nums, int left, int right){
        //一个元素时应当返回，因为并不需要划分了，也不需要做什么操作
        if(left == right){
            return;
        }
        int mid = left + (right - left) / 2;
        //递归划分，本质是DFS里的后序遍历
        //左子树
        mergeSort(nums, left, mid);
        //右子树
        mergeSort(nums, mid+1, right);
        //划分到2个子树各剩余一个元素时，开始排序与合并，此时2个子数组必然是有序的
        merge(nums, left, mid, right);
    }


    /**
     * 用于合并2个有序数组，即conquer
     * @param nums  原数组，left~mid与mid+1~right均有序
     * @param left 左端点
     * @param mid 中点
     * @param right 右端点
     */
    static void merge(int[] nums, int left, int mid, int right){
        //用Integer.MAX_VALUE作为哨兵，当数组里有这个元素时，会出现问题，若没有，则逻辑更简单
        //合并到原数组中
        //左子数组指针
        int l = left;
        //右子数组指针
        int r = mid + 1;
        int[] tmp = new int[right-left+1];
        int t = 0;
        //左子树的范围是left~mid，右子树是mid+1~right
        while(l <= mid && r <= right){
            if(nums[l] <= nums[r]){
                tmp[t] = nums[l];
                l++;
            }else {
                tmp[t] = nums[r];
                r++;
            }
            t++;
        }
        //左数组还有剩余时，拷贝进临时数组，如果访问过mid，则左指针应当为mid+1，所以等于时是没访问过的
        if(l <= mid){
            //l未访问过，所以需要复制，t还未写入，作为起点，长度为l~mid，为mid-l+1
            System.arraycopy(nums, l, tmp, t, mid - l + 1);
        }
        //右数组还有剩余时，拷贝进去
        if(r <= right){
            System.arraycopy(nums, r, tmp, t, right - r + 1);
        }
        //将tmp拷贝进原数组，此时原数组中left~right，合计left-right+1个元素都是有序的了
        System.arraycopy(tmp, 0, nums, left, right - left + 1);

    }
}
