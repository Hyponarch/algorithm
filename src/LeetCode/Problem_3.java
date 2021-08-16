package LeetCode;

import java.util.*;

public class Problem_3 {

    public static void main(String[] args) {
        Solution1 s = new Problem_3().new Solution1();
        s.lengthOfLongestSubstring("abcabcbb");
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            //需要一个集合来记录当前子串的字符集合
            //双指针遍历
            //右指针遇到重复字符时，左指针右移，直到跨过该重复字符
            //特殊情况处理
            if(s == null || s.length() == 0){
                return 0;
            }
            //子字符串的左右边界
            int left = 0;
            int right = 1;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(0));
            int ans = 1;
            while(right < s.length()){
                //不是重复字符，则右指针继续右移
                if(!set.contains(s.charAt(right))){
                    //当前字符加入集合
                    set.add(s.charAt(right));
                    //右指针右移
                    right++;
                    ans = Math.max(ans, right - left);
                }else{  //重复字符，则左指针右移，直到跨过重复的那个字符
                    //移除左边界的字符
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            return ans;
        }
    }
    //时间效率优化，不会有哈希冲突的情况下，数组的效率总是比set/map高的，因为数组可以看做一个%1的哈希，而且没有复杂的操作
    class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            //利用数组代替集合来提高常数级时间效率
            if(s == null || s.length() == 0){
                return 0;
            }
            //子字符串的左右边界
            int left = 0;
            int right = 1;

            //[0, 127]就足够存下所有的字符了
            int[] index = new int[128];
            //用-1填充数组，即用-1表示该字符未出现
            Arrays.fill(index, -1);
            //数组的值表示对应的下标
            index[s.charAt(0)] = 0;

            int ans = 1;
            while(right < s.length()){
                //不是重复字符，则右指针继续右移
                if(index[s.charAt(right)] == -1){
                    //记录当前字符的下标
                    index[s.charAt(right)] = right;
                    //右指针右移
                    right++;
                    ans = Math.max(ans, right - left);
                }else{  //重复字符，则左指针右移，直到跨过重复的那个字符
                    //移除左边界的字符
                    index[s.charAt(left)] = -1;
                    left++;
                }
            }
            return ans;
        }
    }
}
