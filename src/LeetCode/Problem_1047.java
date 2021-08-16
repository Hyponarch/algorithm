package LeetCode;

import java.util.*;

public class Problem_1047 {
    public static void main(String[] args) {
        Solution s = new Problem_1047().new Solution();
        System.out.println(s.removeDuplicates("caabbc"));
    }

    class Solution {
        public String removeDuplicates(String S) {
            //删除偶数回文子串
            //找到第一个偶数回文子串后，要从其后的位置继续搜索
            Set<Integer> set = new HashSet<>();
            int len = S.length();
            String s = S;
            for(int i = 0; i < len; i++){
                set.add(i);
            }

            for(int i = 0; i < len - 1; i++){
                int left = i;
                int right = i + 1;
                //bound为上一个偶数回文串的结束位置后一个位置
                while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                    //先删除
                    set.remove(left);
                    set.remove(right);
                    //再修改
                    while(left >= 0 && !set.contains(--left));
                    while(right < len && !set.contains(++right));
                }
                //只有发生了删除时，才需要界定边界
                if(right > i + 1){
                    //right一定是在与left不相等的位置或者结尾，也就是下一个要检查的位置，而i会自增，所以需要-1
                    i = right - 1;
                }
            }
            StringBuilder ans = new StringBuilder();
            for(int i = 0; i < len; i++){
                if(set.contains(i)){
                    ans.append(s.charAt(i));
                }
            }
            return ans.toString();
        }
    }
}
