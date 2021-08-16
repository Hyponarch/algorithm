package LeetCode;

public class Problem_153 {
    public static void main(String[] args) {
        Solution s = new Problem_153().new Solution();
        s.findMin(new int[]{3,4,5,1,2});
    }

    class Solution {
        public int findMin(int[] nums) {
            int len = nums.length;
            int mid = len / 2; // left + (right - left) / 2;
            //每个元素互不相同，如果相等，则代表元素小于3个
            //有序状态，旋转了k * len次
            if(nums[0] <= nums[mid] && nums[mid] <= nums[len - 1]){
                return nums[0];
            }
            return search(nums, 0, len - 1);
        }
        //一定在无序侧
        int search(int[] nums, int left, int right){
            if(left + 1 >= right){
                return Math.min(nums[left], nums[right]);
            }
            int mid = left + (right - left) / 2;
            //左侧有序
            if(nums[left] < nums[mid]){
                return search(nums, mid, right);
            }else{
                return search(nums, left, mid);
            }
//            return -1;
        }
    }
}
