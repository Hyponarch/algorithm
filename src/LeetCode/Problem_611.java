package LeetCode;

import java.util.Comparator;
import java.util.*;

public class Problem_611 {
    public static void main(String[] args) {
        Solution s = new Problem_611().new Solution();
        s.triangleNumber(new int[]{2, 2, 3, 4});
    }
    class Solution {
        public int triangleNumber(int[] nums) {
            //map存<边长, 数量>，在边长集合里找到符合条件的三元组，数量为各自数量之积
            //排序，找下一个
            //能组成三角形，要求两边之和大于第三边（即较小的2边之和大于第3边）
            //需要考虑同时用到多条相同边的情况
            //a/b/c三条边按递增排序，则c的取值范围为b <= c < a + b
            //二分查找[b, a + b)范围的大小
            //从b右侧开始算，到 < a + b
            int ans = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            for(int i : nums){
                int freq = map.getOrDefault(i, 0);
                map.put(i, freq + 1);
            }
            List<Integer> list = new ArrayList<>(map.keySet());
//            for(int i : map.keySet()){
//                for(int j : map.keySet())
//            }

            int size = map.size();
            for(int i = 0; i < size; i++){
                for(int j = i + 1; j < size; j++){
                    for(int k = j + 1; k < size; k++){
                        int numI = list.get(i);
                        int numJ = list.get(j);
                        int numK = list.get(k);
                        if(numI + numJ > numK){
                            ans += map.get(numI) * map.get(numJ) * map.get(numK);
                        }else {
                            break;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
