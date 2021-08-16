package LeetCode;

public class Problem_1482 {
    public static void main(String[] args) {
        Solution s = new Problem_1482().new Solution();
        int[] nums = new int[]{1,10,3,10,2};
        System.out.println(s.minDays(nums, 3, 1));
    }
    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            //对天数二分查找，特定天数遍历一遍即可，而遍历天数是对数级的复杂度
            int left = 0;
            int right = (int)1e9;
            while(left < right){
                int mid = left + (right - left) / 2;
                int count = m;
                int curr = 0;
                for(int i = 0; i < bloomDay.length; i++){
                    if(bloomDay[i] <= mid){
                        curr++;
                    }else{
                        curr = 0;
                    }
                    if(curr == k){
                        curr -= k;
                        count--;
                        if(count == 0){
                            break;
                        }
                    }
                }
                //可以采到
                if(count == 0){
                    right = mid;
                }else{  //采不到
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
