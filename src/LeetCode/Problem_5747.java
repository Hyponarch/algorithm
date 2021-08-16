package LeetCode;

public class Problem_5747 {

    public static void main(String[] args) {
        Solution s = new Problem_5747().new Solution();
        System.out.println(s.splitString("10"));
    }
    class Solution {
        boolean ans = false;
        boolean hasSplit = false;
        public boolean splitString(String s) {
            int idx = 0;
            while(idx < s.length() && s.charAt(idx) == '0'){
                idx++;
            }
            if(idx == s.length()){
                return false;
            }
            long lastNum;
            for(int i = idx; i - idx < (s.length() - idx + 1) / 2; i++){
                lastNum = Long.parseLong(s.substring(idx, i + 1));
                dfs(s, i + 1, lastNum);
            }
            return ans;
        }
        void dfs(String s, int idx, long lastNum){
//            while(idx < s.length() && s.charAt(idx) == '0'){
//                idx++;
//            }
            if(idx == s.length()){
                ans = hasSplit;
                return;
            }
            for(int i = idx; i < s.length(); i++){
                long num = Long.parseLong(s.substring(idx, i + 1));
                if(num > lastNum){
                    break;
                }
                if(num == lastNum - 1) {
                    hasSplit = true;
                    dfs(s, i + 1, num);
                }
            }
        }
    }
}
