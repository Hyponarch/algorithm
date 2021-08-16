package LeetCode;

/**
 * 33. 搜索旋转排序数组
 */
public class Problem_33 {
    public static void main(String[] args) {
        Solution s = new Problem_33().new Solution();
        System.out.println(s.search(new int[]{3, 1}, 1));

    }

    class Solution {
        public int search(int[] nums, int target) {
            return searchNum(nums, 0, nums.length - 1, target);
        }

        int binarySearch(int[] nums, int left, int right, int target){
            if(left == right){
                if(nums[left] == target){
                    return left;
                }else {
                    return -1;
                }
            }
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                return binarySearch(nums, left, mid - 1, target);
            }else {
                return binarySearch(nums, mid + 1, right, target);
            }
        }

        int searchNum(int[] nums, int left, int right, int target){
            if(left >= right){
                if(nums[left] == target){
                    return left;
                }else if(nums[right] == target){
                    return right;
                } else{
                    return -1;
                }
            }
            int mid = left + (right - left) / 2;
            //左侧有序
            if(nums[mid] > nums[left]){
                //且在左侧
                if(target >= nums[left] && target <= nums[mid]){
                    return binarySearch(nums, left, mid, target);
                }else{  //不在左侧
                    return searchNum(nums, mid + 1, right, target);
                }
            }else { //右侧有序
                //在右侧
                if(target >= nums[mid] && target <= nums[right]){
                    return binarySearch(nums, mid, right, target);
                }else { //不在右侧
                    return searchNum(nums, left, mid - 1, target);
                }
            }
        }
    }

}
