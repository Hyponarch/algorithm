package LeetCode;

import java.util.*;

public class Problem_503 {
    public static void main(String[] args) {
        Solution s = new Problem_503().new Solution();
        System.out.println(Arrays.toString(s.nextGreaterElements(new int[]{1,2,1})));
    }
    //单调栈，写入递减序列，遇到递增，则将栈顶小于该数的依次出栈
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int len = nums.length;
            int[] ans = new int[len];
            Arrays.fill(ans, -1);
//            for(int i = 0; i < len; i++){
//                ans[i] = -1;
//            }
            Deque<Integer> stack = new LinkedList<Integer>();

            for(int i = 0; i < 2*len - 1; i++){
                //如果栈为空或者当前元素小于等于栈顶元素，则保持栈的递减性，当前元素的下标入栈
                if(stack.isEmpty() || nums[i % len] <= nums[stack.peek()]){
                    stack.push(i % len);
                }else{
                    //如果当前元素比栈顶元素大，则栈顶元素的第一个更大元素就是当前元素，依次出栈并写入ans
                    while(!stack.isEmpty() && nums[i % len] > nums[stack.peek()]){
                        ans[stack.pop()] = nums[i % len];
                    }
                    //最后将当前元素入栈
                    stack.push(i % len);
                }
            }
            return ans;
        }
    }
}
