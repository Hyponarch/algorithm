package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem_345 {
    public static void main(String[] args) {
        Solution s = new Problem_345().new Solution();
        System.out.println(s.reverseVowels("hello"));
        System.out.println(s.reverseVowels("leetcode"));

    }

    class Solution {
        public String reverseVowels(String s) {
            Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
            //双指针，找两头的元音字母，交换
            StringBuilder sb = new StringBuilder(s);
            int left = 0;
            int right = s.length() - 1;
//            while (left < right) {
//                while (left < right && !vowels.contains(s.charAt(left))){
//                    left++;
//                }
//                while (left < right && !vowels.contains(s.charAt(right))){
//                    right--;
//                }
//                char tmp = s.charAt(left);
//                sb.replace(left, left + 1, s.charAt(right) + "");
//                sb.replace(right, right + 1, tmp + "");
//                left++;
//                right--;
//            }

            StringBuilder leftStr = new StringBuilder();
            StringBuilder rightStr = new StringBuilder();

            while (left < right) {
                if (!vowels.contains(s.charAt(left))){
                    leftStr.append(s.charAt(left));
                    left++;
                }else if (!vowels.contains(s.charAt(right))){
                    rightStr.insert(0, s.charAt(right));
                    right--;
                }else {
                    leftStr.append(s.charAt(right));
                    rightStr.insert(0, s.charAt(left));
                    left++;
                    right--;
                }
            }

            return leftStr.append(rightStr).toString();
        }
    }
}
