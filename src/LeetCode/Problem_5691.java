package LeetCode;
import java.util.*;
public class Problem_5691 {
    public static void main(String[] args) {
        Solution s= new Problem_5691().new Solution();
        s.minOperations(new int[]{5,6,4,3,1,2},
            new int[]{6,3,3,1,4,5,3,4,1,3,4});
    }
    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            //求和，相减得到差，计算较大方的下限（全1，m）与较小方的上限6n，若m > 6n，则无解，其中m > n
            //贪心将较大方最大的数减小到1，count++, 直到减小值大于等于target的剩余
            int m = nums1.length;
            int n = nums2.length;
            if(m > 6 * n || n > 6 * m){
                return -1;
            }
            int sum1 = 0;
            int sum2 = 0;
            for(int i :nums1){
                sum1 += i;
            }
            for(int i : nums2){
                sum2 += i;
            }
            int diff = sum1 - sum2;
            //排序，确认nums1较大数与1的差 和 6与nums2较小数的差 谁大
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int[] big = nums1;
            int[] small = nums2;
            if(diff < 0){
                big = nums2;
                small = nums1;
                int tmp = m;
                m = n;
                n = tmp;
            }
            int count = 0;
            int p1 = big.length - 1;
            int p2 = 0;
            int target = Math.abs(diff);
            while(target > 0){

                if(p1 < 0){
                    target -= 6 - small[p2];
                    p2++;
                    count++;
                    continue;
                }
                if(p2 >= n){
                    target -= big[p1] - 1;
                    p1--;
                    count++;
                    continue;
                }
                int diff1 = big[p1] - 1;
                int diff2 = 6 - small[p2];
                if(diff1 - diff2 >= 0){
                    target -= diff1;
                    count ++;
                    p1--;
                }else{
                    target -= diff2;
                    p2++;
                    count++;
                }
            }
            // if(target > 0)
            return count;

        }
    }
}
