package LeetCode;

import java.util.*;

public class Problem_1 {
    class Solution {
        //已知一个数a，找到等于targer-a的另一个数
        //直接遍历数组的话是O(n)，查找哈希表可以优化为O(1)，总的时间复杂度从O(n^2)变为O(n)
        //空间复杂度从O(1)变为O(n)

        public int[] twoSum(int[] nums, int target) {
            //我们要找到2个数之和等于target
            //即我们需要找到nums[i] + nums[j] == target，并且返回他们的下标，即i和j，其中i != j
            int[] ans = new int[2]; //声明一个大小为2的数组用来保存结果
            //我们通过循环来遍历所有的数字
            int n = nums.length;  //用一个变量len保存nums的长度
            //i为第一个数的下标，nums一共有n个数，所以i的取值范围是[0, n-1]
            for(int i = 0; i < n; i++){
                //j为第二个数的下标。
                for(int j = i + 1; j < n; j++){
                    //对于每个数nums[i]，我们验证一遍其他数（nums[j]）跟它的和是否等于target
                    //如果满足条件
                    if(nums[i] + nums[j] == target){
                        //将下标写入返回值数组里
                        ans[0] = i;
                        ans[1] = j;
                        //返回
                        return ans;
                    }
                }
            }
            //默认返回值
            return new int[0];
        }
    }

    class Solution1 {
        //已知一个数a，找到等于target-a的另一个数
        //直接遍历数组的话是O(n)，查找哈希表可以优化为O(1)，总的时间复杂度从O(n^2)变为O(n)
        //空间复杂度从O(1)变为O(n)
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            //声明一个HashMap，key和value的类型都是int，变量名叫map。key和value分别记录数值和下标
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                //如果存在nums[j] + nums[i] == target，那么nums[j] = target - nums[i]
                int diff = target - nums[i];
                //如果存在diff，则返回diff和nums[i]的下标
                //HashMap的containsKey方法判断该HashMap中是否存在这个key
                if(map.containsKey(diff)){
                    //返回的时候直接创建一个数组，创建数组时可以直接初始化，就不需要填大小了，比如说new int[]{1, 2, 3};
                    //此时创建一个大小为2的数组，第一个元素为map.get(diff)也就是map中对应diff的value，第二个元素就是i，也就是2个数的下标
                    return new int[]{map.get(diff), i};
                }else   //否则，将nums[i]存入map中
                    map.put(nums[i], i);
            }
            return new int[0];
        }
    }
}
