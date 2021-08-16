package sort;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * （二叉）堆的本质是完全二叉树，可以用数组来表示
 *   [0, 1, 2, 3, 4, 5, 6]表示树
 *             0
 *           /   \
 *          1     2
 *         / \   / \
 *        3  4  5   6
 *
 * 节点i的左孩子为2i+1, 右孩子为2i+2
 * 父节点为(i-1)/2
 */
public class HeapSort {
    static int heapSize;

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4,5,6,7};
//        buildMaxHeap(nums);
//        System.out.println(Arrays.toString(nums));
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 调整堆的结构，确保最大堆的性质不变
     * 先找到比当前节点更大的孩子，如果存在，则交换较大的孩子与当前节点
     * 然后递归调整交换的那棵子树
     * 时间复杂度：最多调整的次数为树的高度（从根顺着某一路径交换到叶节点），即O(h)，完全二叉树的高为log n，所以为O(log n)
     * @param nums  待调整的数组
     * @param p 当前调整的节点
     */
    static void maxHeapify(int[] nums, int p){
        //向下调整
        //如果孩子存在，与孩子节点比较
        //如果小于孩子节点，则与孩子节点中的较大值交换
        int l = left(p);
        int r = right(p);
        //没有孩子，应当用heapSize而非nums.length, 因为调整过程中堆的元素数量可能减少，不等同于数组
        if(l >= heapSize){
            return;
        }
        int largest = p;
        if(r == heapSize){
            if(nums[l] > nums[p]){
                largest = l;
            }
        }else if(nums[l] >= nums[r]){
            if(nums[l] > nums[p]){
                largest = l;
            }
        }else {
            if(nums[r] > nums[p]){
                largest = r;
            }
        }
        //交换当前节点与更大的孩子节点
        if(largest != p){
            int tmp = nums[largest];
            nums[largest] = nums[p];
            nums[p] = tmp;
            //largest是较大的孩子节点原本的位置，当前将p交换下去，p仍有可能比其孩子更大，需要递归向下调整
            maxHeapify(nums, largest);
        }
    }

    /**
     * 由数组构建最大堆
     * 最大堆的性质：任意的节点均大于等于其孩子节点
     * 应当自底向上调整
     * 时间复杂度: O(n)，sigma(h=0 to lgn, n/2^(h+1) )O(h) = O(n)
     * @param nums  原始数组
     */
    static void buildMaxHeap(int[] nums){
        //[len/2, len - 1]均为叶节点，而要维护最大堆的性质，只需要调整拥有孩子的节点即可，故不需要直接操作叶节点
        //只需要由叶节点的父节点来调整即可
        heapSize = nums.length;
        for(int i = nums.length / 2 - 1; i >= 0 ; i--){
            maxHeapify(nums, i);
        }
    }

    /**
     * 堆排序，每次都将最大元素移动到数组的后部，然后减小堆的大小，恢复堆的性质
     * 时间复杂度由O((n-1)*h)=O(n log n)
     * @param nums 待排序数组
     */
    static void heapSort(int[] nums){
        //O(n)
        buildMaxHeap(nums);
        //调用n-1次
        for(int i = nums.length - 1; i > 0; i--){
            //每次将最大值移动到最后
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            heapSize--;
            //恢复最大堆性质，O(h)
            maxHeapify(nums, 0);
        }
    }

    static int left(int i){
        return 2*i+1;
    }

    static int right(int i){
        return 2*i+2;
    }

    /**
     * 整数除法向0取整
     * 负整数除法如同正整数，符号依据负负得正取，
     * 如(-5)/(-2) = 2, 5/(-2) = -2
     * 负整数求余如同正整数，余数符号由被除数决定
     * -5 = （-2） * 2 + （-1），所以(-5) % (-2) = -1, 等同于5 % 2 = 1, 符号依被除数-5，所以是-1
     * 5 = （-2） * (-2) + 1, 5 % (-2) = 1
     * 此处i=0时，-1/2 = 0
     * @param i 当前节点
     * @return  父节点
     */
    static int parent(int i){
        return (i-1)/2;
    }
}
