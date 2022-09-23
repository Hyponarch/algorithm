package LeetCode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author luchenl.chen
 * email: luchenl.chen@qunar.com
 * create date: 2022/4/22 14:36
 * @version : 1.0
 * description:
 * $y=x^2+1$
 * $\log(X)$
 */
public class Problem_396 {
    public static void main(String[] args) {
        Solution s = new Problem_396().new Solution();
        s.maxRotateFunction(new int[]{4,3,2,6});
    }

    class Solution {
        public int maxRotateFunction(int[] nums) {
            int sum = 0;
            int last = 0;
            //求和
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
                last += nums[i] * i;
            }
            int ans = last;
            for(int i = 1; i < nums.length; i++){
                int curr = last + nums.length * nums[i - 1] - sum;
                last = curr;
                ans = Math.max(ans, curr);
            }
            return ans;
        }
    }
}
