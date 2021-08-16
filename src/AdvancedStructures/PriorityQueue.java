package AdvancedStructures;

/**
 * 优先队列是基于最小（大）堆实现的，常用于部分排序（如top K）
 * 这里实现最小优先队列
 */
public class PriorityQueue {
    int heapSize;
    //恢复最小堆性质
    void minHeapify(int[] nums, int p){
        int left = 2*p+1;
        int right = left + 1;
        int least = p;
        if(left < heapSize){
            if(nums[left] < nums[least]){
                least = left;
            }
        }
        if(right < heapSize){
            if(nums[right] < nums[least]){
                least = right;
            }
        }
        if(least != p){
            int tmp = nums[least];
            nums[least] = nums[p];
            nums[p] = tmp;
            //递归向下处理
            minHeapify(nums, least);
        }
    }
    //建堆
    void buildMinHeap(int[] nums){
        //处理[0, n/2-1]的元素即可，自底向上
        for(int i = nums.length/2 - 1; i >= 0; i--){
            minHeapify(nums, i);
        }
    }
    //返回最小值，堆顶元素，即peek
    int heapMin(int[] nums){
        return nums[0];
    }
    //返回并出队，pop()
    int heapExactMin(int[] nums){
        //没有元素
        if(heapSize < 1){
            return Integer.MIN_VALUE;
        }
        int min = nums[0];
        nums[0] = nums[heapSize - 1];
        heapSize--;
        minHeapify(nums, 0);
        return min;
    }
    //减小某个元素的值
    void heapDecreaseKey(int[] nums, int i, int d){
        nums[i] = d;
        //如果父节点更大，则自底向上调整
        while (i > 0 && nums[i / 2] > nums[i]){
            int tmp = nums[i];
            nums[i] = nums[i/2];
            nums[i/2] = tmp;
            i /= 2;
        }
    }
    //插入元素，扩容问题，或者构造方法里指定大小
    void minHeapInsert(int[] nums, int key){
        heapSize++;
        nums[heapSize] = Integer.MAX_VALUE;
        heapDecreaseKey(nums, heapSize, key);
    }

}
