package LeetCode;

/**
 * @author luchenl.chen
 * email: luchenl.chen@qunar.com
 * create date: 2022/4/28 11:52
 * @version : 1.0
 * description:
 */
public class Problem_905 {

    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int len = nums.length;
            int l = 0;
            int r = len - 1;
            while(l < r) {
                if(nums[l] % 2 == 0){
                    l++;
                } else if(nums[r] % 2 == 1){
                    r--;
                } else {
                    int tmp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = tmp;
                    l++;
                    r--;
                }
            }
            return nums;
        }
    }
}
