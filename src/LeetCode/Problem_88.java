package LeetCode;

/**
 * @description:
 * @author: luchenl.chen
 * @email: luchenl.chen@qunar.com
 * @date: 2021/8/11 12:34
 * @version: 1.0
 */
public class Problem_88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //nums1后半部分是空闲的，所以可以直接从后半开始存较大的数
            //如果2个数组都没遍历完
            while (m > 0 && n > 0){
                //将较大的数放在nums1的末尾
                if(nums1[m-1] >= nums2[n-1]){
                    nums1[m+n-1] = nums1[m-1];
                    m--;
                }else {
                    nums1[m+n-1] = nums2[n-1];
                    n--;
                }
            }
            //如果nums2还有剩余，则全部复制到nums1中，如果nums1有剩余，则不需要处理
            if(n > 0){
                for(int i = n - 1; i > -1; i--){
                    nums1[i] = nums2[i];
                }
            }
        }
    }
}
