package LeetCode;

import java.util.*;

/**
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 *
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i 如果上述条件全不满足。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author luchenl.chen
 * @date 2021/10/13 19:48
 */
public class Problem_412 {
    public static void main(String[] args) {
        Solution s = new Problem_412().new Solution();
//        s.fizzBuzz()
    }
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> ansList = new ArrayList<>();
            StringBuilder sb;
            for(int i = 0; i < n; i++){
                sb = new StringBuilder();
                if((i + 1) % 3 == 0){
                    sb.append("Fizz");
                    if((i + 1) % 5 == 0) {
                        sb.append("Buzz");
                    }
                }else if((i + 1) % 5 == 0){
                    sb.append("Buzz");
                }else {
                    sb.append(i + 1);
                }
                ansList.add(sb.toString());
            }
            return ansList;
        }
    }
}
