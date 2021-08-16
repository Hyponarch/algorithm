package LeetCode;

import java.util.*;

public class Problem_5740 {

    public static void main(String[] args) {
        Solution s = new Problem_5740().new Solution();
        System.out.println(s.longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
    }

    class Solution {
        public int longestBeautifulSubstring(String word) {
            //必须以a开头，且必须包含全部5种字母，必须升序
//            char[] beat = new char[]{'a', 'e', 'i', 'o', 'u'};
            Map<Character, Integer> beat = new HashMap<>();
            beat.put('a', 0);
            beat.put('e', 1);
            beat.put('i', 2);
            beat.put('o', 3);
            beat.put('u', 4);
            int left = 0;
            int right = 0;
            int len = word.length();
            int maxLen = 0;
            Map<Character, Integer> map = new HashMap<>();
//            Set<Character> set = new HashSet<>();
            while (right < len && left < len){

                if(word.charAt(left) != 'a'){
                    left++;
                    continue;
                }
                right = left;
//                set = new HashSet<>();
                while(right < len && (word.charAt(right) == 'a'
                        || (beat.get(word.charAt(right)) - beat.get(word.charAt(right - 1)) == 0)
                        || (beat.get(word.charAt(right)) - beat.get(word.charAt(right - 1)) == 1))){
//                    set.add(word.charAt(right));
                    if(word.charAt(right) - word.charAt(left) == 4){
                        maxLen = Math.max(maxLen, right - left + 1);
                    }
                    right++;
                }

                left++;
//                char leftChar = word.charAt(left);
                //找到a后
                //降序
//                char rightChar = word.charAt(right);
//                while(word.charAt(left) != 'a' ){
//                    char leftChar = word.charAt(left);
//                    int freq = map.getOrDefault(leftChar, 0);
//                    //指针左移，则维护区间内的字符频数
//                    if(freq <= 1){
//                        map.remove(leftChar);
//                    }else {
//                        map.put(leftChar, freq - 1);
//                    }
//                    left++;
//                    right = Math.max(right, left);
//                }
//
//                if(right > 0 && rightChar < word.charAt(right - 1)){
//                    if(map.size() == 5){
//                        maxLen = Math.max(maxLen, right - left + 1);
//                    }
//                    left = right;
//                    continue;
//                }
//                int freq = map.getOrDefault(rightChar, 0);
//                map.put(rightChar, freq + 1);
//                right++;
            }
            return maxLen;
        }
    }
}
