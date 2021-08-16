package LeetCode;

public class Problem_1011 {

    public static void main(String[] args) {
        Solution s = new Problem_1011().new Solution();
        System.out.println(s.shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
    }

    class Solution {
        int ans = 0;
        public int shipWithinDays(int[] weights, int D) {
            //划分为尽可能相近的D个子区间，求最大值
            //二分查找容量，找到能满足条件的最小容量
            //最小容量应当等于sumWeight / d, 最大为sumWeight
            int max = 0;
            int sum = 0;
            for(int i : weights){
                sum += i;
                max = Math.max(max, i);
            }
            binarySearch(weights, D, Math.max(sum / weights.length, max), sum);
            return ans;
        }
        void binarySearch(int[] weights, int D, int left, int right){
            if(left == right){
                ans = left;
                return;
            }
            int mid = left + (right - left) / 2;
            if(canTransfer(weights, D, mid)){
                binarySearch(weights, D, left, mid);
            }else{
                binarySearch(weights, D, mid + 1, right);
            }
        }
        boolean canTransfer(int[] weights, int D, int capacity){
            int p = 0;
            while(D > 0 && p < weights.length){
                int sum = 0;
                while(p < weights.length && sum + weights[p] <= capacity){
                    sum += weights[p++];
                }
                D--;
            }
            return p == weights.length;
        }
    }
}
