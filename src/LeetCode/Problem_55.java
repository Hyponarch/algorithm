package LeetCode;

import java.util.*;

public class Problem_55 {

    public static void main(String[] args) {
        Solution s = new Problem_55().new Solution();
        s.canJump(new int[]{3,2,1,0,4});
    }
    class Solution {
        public boolean canJump(int[] nums) {
            //从后往前遍历，记录每个位置是否可以到达终点
            //如果点A可以到达终点，而点B可以到达A点，那么B可以到达终点
            //传递性
            int len = nums.length;
            boolean[] reach = new boolean[len];
            reach[len - 1] = true;
            for(int i = len - 2; i >= 0; i--){
                if(i + nums[i] >= len - 1){
                    reach[i] = true;
                }else{
                    for(int j = i + 1; j < len - 1; j++){
                        if(reach[j] == true){
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
}
