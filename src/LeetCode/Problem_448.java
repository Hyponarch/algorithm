package LeetCode;
import java.util.*;
public class Problem_448 {
    public static void main(String[] args) {
        Solution s= new Problem_448().new Solution();
        s.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            //将i放到nums的第i-1个位置，检查一遍nums，数值与下标不对应的数就是缺少的数
            // int[] position = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                while(nums[i]!=i+1){
                    if(nums[i] == nums[nums[i] - 1]){
                        break;
                    }
                    int tmp = nums[i];
                    nums[i] = nums[tmp - 1];
                    //此时num[i]已经改变，不能用nums[nums[i]-1]来表示
                    nums[tmp-1] = tmp;
                }
                //position[nums[i]-1]=nums[i];
            }
            // System.out.println(Arrays.toString(position));
            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != i+1){
                    ans.add(i+1);
                }
            }
            return ans;
        }
    }
}
