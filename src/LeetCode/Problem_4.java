package LeetCode;

public class Problem_4 {
    public static void main(String[] args) {

    }

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int p1 = 0;
            int p2 = 0;
            int mid = n + (m - n) / 2;

            int midNum0 = -1;
            int midNum1 = -1;
            //到达边界或者到达中位数之前
            while (p1 < m && p2 < n && p1 + p2 < mid){
                if(nums1[p1] < nums2[p2]){
                    p1++;
                }else {
                    p2++;
                }
                if(p1 + p2 == mid){

                }
            }
            //到达边界，但未到达中位数
            if(p1 + p2 < mid){

                if (p1 < m){
                    while (p1 + p2 < mid){
                        p1++;
                    }

                }
            }



            //奇数
            if((m + n) % 2 != 0){

            }
            return 0.0;
        }
    }
}
