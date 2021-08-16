package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_5839 {
    public static void main(String[] args) {
        Solution s = new Problem_5839().new Solution();
        s.minStoneSum(new int[]{5, 4, 9}, 2);
    }
    class Solution {
        public int minStoneSum(int[] piles, int k) {
            //每次都找最大的数x，使x-x/2
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            for(int i : piles){
                maxHeap.offer(i);
            }
            for(int i = 0; i < k; i++){
                int max = maxHeap.poll();
                max -= max / 2;
                maxHeap.offer(max);
            }
            int sum = 0;
            for(int i : maxHeap){
                sum += i;
            }
            return sum;
        }
    }
}
