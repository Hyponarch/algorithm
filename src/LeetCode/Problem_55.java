package LeetCode;

import java.util.*;

public class Problem_55 {

    public static void main(String[] args) {
        Solution s = new Problem_55().new Solution();
        System.out.println(s.canJump(new int[]{1, 0, 1, 0}));
    }
    class Solution {
        //动态规划解法，O(n^2)
        public boolean canJump(int[] nums) {
            //从后往前遍历，记录每个位置是否可以到达终点
            //如果点A可以到达终点，而点B可以到达A点，那么B可以到达终点
            //传递性
            int len = nums.length;
            boolean[] reach = new boolean[len];
            reach[len - 1] = true;
            for(int i = len - 2; i >= 0; i--){
                if(nums[i] == 0){
                    reach[i] = false;
                }else if(i + nums[i] >= len - 1){
                    reach[i] = true;
                }else{
                    for(int j = i + 1; j <= Math.min(len - 1, i + nums[i]); j++){
                        if(reach[j]){
                            reach[i] = true;
                            break;
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(reach));
            return reach[0];
        }
    }


    //每个元素代表你在该位置可以跳跃的最大长度
    //这意味着只要能到达下标i，那么i以前的所有位置都是可达的
    //那么我们只需要关注可到达的最远位置
    //贪心算法，O(n)
    public boolean canJump1(int[] nums) {
        int max = 0;
        for(int i = 0; i <= max; i++){
            max = Math.max(max, nums[i] + i);
            if(max >= nums.length){
                break;
            }
        }
        return (max >= nums.length - 1);

    }
}
