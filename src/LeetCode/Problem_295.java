package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem_295 {
    //找数据流的中位数，需要能实时维护中位数
    //考虑2个堆，维护较大数的最小堆、维护较小数的最大堆
    class MedianFinder {
        //较大数，优先队列默认是最小堆
        Queue<Integer> high = new PriorityQueue<>();
        //较小数，最大堆
        Queue<Integer> low = new PriorityQueue<>((o1, o2) -> o2 - o1);

        /** initialize your data structure here. */
        public MedianFinder() {
//            high.offer(Integer.MAX_VALUE);
//            low.offer(Integer.MIN_VALUE);
        }

        //low的数不能比high大
        public void addNum(int num) {
            if(low.isEmpty()){
                if(!high.isEmpty() && num > high.peek()){
                    high.offer(num);
                }
                low.offer(num);
            }else {
                if(num < low.peek()){
                    low.offer(num);
                }else {
                    high.offer(num);
                }
            }
            //平衡数据量
            balance();
        }
        //调整2个优先队列大小
        //使得low.size() >= high.size()
        private void balance(){
            while (high.size() - low.size() > 0){
                low.offer(high.poll());
            }
            while (low.size() - high.size() > 1){
                high.offer(low.poll());
            }
        }

        public double findMedian() {
            if(low.size() > high.size()){
                return low.peek();
            }else {
                return ((double)low.peek() + high.peek()) / 2;
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
