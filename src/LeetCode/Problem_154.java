package LeetCode;

public class Problem_154 {
    public static void main(String[] args) {
        Solution s = new Problem_154().new Solution();
        s.findMin(new int[]{1,3,5});
    }
    class Solution {
        public int findMin(int[] nums) {
            int len = nums.length;
//            if(nums[0] <= nums[len / 2] && nums[len / 2] <= nums[len - 1]){
//                return nums[0];
//            }
            return search(nums, 0, len - 1);
        }
        int search(int[] nums, int left, int right){
            if(left + 1 >= right){
                return Math.min(nums[left], nums[right]);
            }
            int mid = left + (right - left) / 2;
            //左侧有序
            if(nums[mid] >= nums[left]){
                return search(nums, mid, right);
            }else{
                return search(nums, left, mid);
            }

        }
    }
}
