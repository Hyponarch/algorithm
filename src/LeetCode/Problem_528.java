package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

//找到每个数对应的初始下标
//随机一个下标，然后判断对应的数是什么
public class Problem_528 {
    public static void main(String[] args) {
        Solution s = new Problem_528().new Solution(new int[]{1, 3});
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
    }
    class Solution {
//        List<Integer> pool = new ArrayList<>();
        int[] startIndex;
        public Solution(int[] w) {
            startIndex = new int[w.length + 1];
            for (int i = 1; i < w.length + 1; i++){
                startIndex[i] = startIndex[i-1] + w[i-1];
            }
        }

        public int pickIndex() {
            Random random = new Random();
            //生成随机下标
            int rand = random.nextInt(startIndex[startIndex.length - 1]);
//            int rand = (int)(Math.random() * startIndex[startIndex.length - 1]);
            //确认随机下标对应的数
            int res = binarySearch(startIndex, rand);
            return startIndex[res] == rand ? res : res - 1;
        }

        //二分查找
        private int binarySearch(List<Integer> list, int target){
            //左闭右开区间
            int left = 0;
            int right = list.size();
            while(left < right){
                int mid = left + (right - left) / 2;
                if(target > list.get(mid)){
                    left = mid + 1;
                }else{  //不要处理相等的情况，确保找到最左
                    right = mid;
                }
            }
            return left;
        }

        private int binarySearch(int[] arr, int target){
            //左闭右开区间
            int left = 0;
            int right = arr.length;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(target > arr[mid]){
                    left = mid + 1;
                }else{  //不要处理相等的情况，确保找到最左
                    right = mid;
                }
            }
            return left;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
