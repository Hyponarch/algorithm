package LeetCode; /**
 * @description:
 * @author: luchenl.chen
 * @email: luchenl.chen@qunar.com
 * @date: 2021/8/11 10:26
 * @version: 1.0
 */
import java.util.*;
public class Problem_446 {
    public static void main(String[] args) {
        Solution s = new Problem_446().new Solution();
//        System.out.println(s.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
        System.out.println(s.numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));

    }
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int len = nums.length;
            int ans = 0;
            //key为结尾的数，value的set是差值,nums[i]的取值范围是[Integer.MIN_VALUE, Integer.MAX_VALUE]，所以2数之差可能会溢出
            Map<Integer, Set<Long>> map = new HashMap<>();

            map.put(0, new HashSet<Long>(){{add(Long.MAX_VALUE);}});
            map.put(1, new HashSet<Long>(){{add((long)nums[1] - nums[0]);}});
            for(int i = 2; i < len; i++){
                //对所有左侧的数，用当前的数-左侧数，检查左侧数的差集合里是否包含该差，如果包含，则为该数的value集合添加该差
                //最后将当前数与左侧所有数组合，
                for(int j = 0; j < i; j++){
                    long diff = nums[i] - nums[j];
                    if(map.get(j).contains(diff)){
                        ans++;
                    }
                    Set<Long> s = map.getOrDefault(i, new HashSet<Long>());
                    s.add(diff);
                    map.put(i, s);
                }
            }
            return ans;

//            int count = 0;
//
//            for(int i = 0; i < len; i++){
//                for(int j = i + 1; j < len; j++){
//                    int diff = nums[j] - nums[i];
//                    int curr = nums[j];
//                    //举例，1、2、3、5、3
//                    //需要考虑初次匹配后仍会匹配到的情况
//                    for(int k = j + 1; k < len; k++){
////                        if(nums[i] == 2 && nums[j] == 6){
////                            int breakPoint = 0;
////                        }
////                        diff += nums[j] - nums[i];
//                        if(nums[k] == curr + diff){
//                            count++;
//                            curr = nums[k];
//                        }
//                    }
//                }
//            }
//            return count;
        }
    }
}
