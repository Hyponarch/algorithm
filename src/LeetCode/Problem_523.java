package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Problem_523 {
    public static void main(String[] args) {
        Solution s = new Problem_523().new Solution();
        System.out.println(s.checkSubarraySum(new int[]{23,2,4,6,6}, 7));
    }
    class Solution {
        //如果a - b = n * k
        //那么(a - b) % k == 0
        //即a % k == b % k
        //反过来同样成立
        //即前缀和对k求模，模相同的2个端点，构成的区间和，为k的倍数
        public boolean checkSubarraySum(int[] nums, int k) {
            int[] prefix = new int[nums.length + 1];
            prefix[0] = 0;
            Map<Integer, Integer> remainder = new HashMap<>();  //余数, 下标
            //初始位置
            remainder.put(0, -1);
            for(int i = 1; i < nums.length + 1; i++){
                prefix[i] = prefix[i-1] + nums[i-1];
                if(!remainder.containsKey(prefix[i] % k)){
                    remainder.put(prefix[i] % k, i - 1);    //只记录同一个余数最左下标
                }else {
                    //当前下标为i - 1，最左下标为remainder.get(prefix[i])，i - 1 - remainder.get(prefix[i]) >= 1
                    if(i - remainder.get(prefix[i] % k) >= 2){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
