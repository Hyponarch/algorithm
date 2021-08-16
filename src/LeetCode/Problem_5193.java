package LeetCode;

public class Problem_5193 {
    public static void main(String[] args) {

    }

    class Solution {
        public String makeFancyString(String s) {
            StringBuilder sb = new StringBuilder();
            int left = 0;
            int right = 1;
            sb.append(s.charAt(0));
            //右指针遍历直到结束
            while (right < s.length()){
                //如果2指针差值小于2，则最多2个重复，将right加入答案
                if(right - left < 2){
                    sb.append(s.charAt(right));
                }else if(s.charAt(right) != s.charAt(left)){
                    sb.append(s.charAt(right));
                }
                //如果右指针与左指针不等，则将左指针指向右指针处
                if(s.charAt(right) != s.charAt(left)){
                    left = right;

                }
                right++;
            }
            return sb.toString();
        }
    }
}
