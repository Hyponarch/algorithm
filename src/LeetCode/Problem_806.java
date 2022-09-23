package LeetCode;

/**
 * @author luchenl.chen
 * @date 2022/4/12 16:33
 */
public class Problem_806 {
    class Solution {
        //回溯
        public int[] numberOfLines(int[] widths, String s) {
            int currLen = 0;
            int row = 1;
            int lastLen = 0;
            for(int i = 0; i < s.length(); i++) {
                if(currLen + widths[s.charAt(i) - 'a'] > 100) {
                    row++;
                    currLen = widths[s.charAt(i) - 'a'];
                } else {
                    currLen += widths[s.charAt(i) - 'a'];
                }
                if(i == s.length() - 1) {
                    lastLen = currLen;
                }
            }
            return new int[]{row, lastLen};
        }
    }
}
