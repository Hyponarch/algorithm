package LeetCode;

public class Problem_125 {
    public static void main(String[] args) {
        Problem_125 p = new Problem_125();
        Solution s = p.new Solution();
        s.isPalindrome("A man, a plan, a canal: Panama");
    }
    class Solution {
        public boolean isPalindrome(String s) {
            //  [ \ ] ^ _ ` 大小写字母不是相连的，相差32个字符，中间隔了6个字符
            // s=s.toLowerCase().replaceAll("[^a-z0-9]", "");
            int left = 0;
            int right = s.length()-1;

            while(left < right){

                //取等意味着只剩下一个字符，不用判断，此处会改变left，字母的取值会变
                while(left < right && valid(s.charAt(left))){
                    left++;
                }
                while(right > left && valid(s.charAt(right))){
                    right--;
                }
                //要放到这里
                char l = s.charAt(left);
                char r = s.charAt(right);

                if(l!=r && !( ( isAlphaBeta(l) && isAlphaBeta(r) ) && Math.abs(l-r)==32 ) ) {
                    //2个字符都是字母且相差32,只有这种情况不是false}
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
        boolean valid(char c){
            return (c < '0' || c > '9') && !isAlphaBeta(c);
        }
        boolean isAlphaBeta(char c){
            return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
        }
    }
}
