package test;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.exchange(new int[]{1,2,3,4,5})));
    }
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            while(left < right && nums[left] % 2 != 0){
                left++;
            }
            while(left < right && nums[right] % 2 == 0){
                right--;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}
