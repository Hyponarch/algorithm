package LeetCode;

import java.util.*;

/**
 * @author luchenl.chen
 * email: luchenl.chen@qunar.com
 * date: 2021/8/12 19:15
 * description:
 * @version : 1.0
 */
public class Problem_15 {
    public static void main(String[] args) {
        Solution s = new Problem_15().new Solution();
        System.out.println(s.threeSum(new int[]{-1,0,1,2,-1,-4}));

    }
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            //1、计数后去重排序X 直接排序，因为会有比如2，-1，-1的情况，去重就做不了了
            //2、固定第一个数nums[i]
            //双指针
            //指针p2指向nums[i+1], 指针p3指向nums[nums.length-1]
            //如果和大于>0则p3左移，小于则p2右移，等于保存答案并检查有没有重复的数，跳过
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            int len = nums.length;
            for(int i = 0; i < len; i++){
                //第一个数重复时，跳过
                if(i > 0 && nums[i] == nums[i-1]){
                    continue;
                }
                int p2 = i + 1;
                int p3 = len - 1;
                while (p2 < p3){
                    //和大于>0则p3左移
                    if(nums[i] + nums[p2] + nums[p3] > 0){
                        p3--;
                    }else if(nums[i] + nums[p2] + nums[p3] < 0){    //小于则p2右移
                        p2++;
                    }else {
                        ans.add(Arrays.asList(nums[i], nums[p2], nums[p3]));
                        //p2先右移，再判断是否重复，并且跳过重复的部分
                        do{
                            p2++;
                        }while (p3 > p2 && nums[p2] == nums[p2-1]);
                        //p3先左移，再判断是否重复，并且跳过重复的部分
                        do{
                            p3--;
                        }while (p3 > p2 && nums[p3] == nums[p3+1]);
                    }
                }

            }
            return ans;
        }
    }
}
