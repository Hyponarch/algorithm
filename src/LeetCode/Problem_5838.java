package LeetCode;

public class Problem_5838 {

    class Solution {
        public boolean isPrefixString(String s, String[] words) {
            int start = 0;
            for(String word : words){
                if(start == s.length()){
                    break;
                }
                int len = word.length();
                if(s.length() - start >= word.length() && s.substring(start, start + len).equals(word)){
                    start += len;
                }else {
                    return false;
                }
            }
            if(start == s.length()){
                return true;
            }else {
                return false;
            }

        }
    }
}
