package LeetCode;


import java.util.*;
public class Problem_139 {
    public static void main(String[] args) {
        Solution s = new Problem_139().new Solution();
        s.wordBreak("leetcode", Arrays.asList("leet","code"));

    }
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            //dp[i]表示以i结尾的子字符串可以拆分为字典内的单词
            //0<=j<i, 如果有dp[j] == 0, 则dp[i] = dp[j] && check(s.subString(j+1, i+1)) ? 1 : 0;
            int len = s.length();
            //可以直接由list创建set
            //Set<String> dictSet = new HashSet<>(wordDict);
            Set<String> dictSet = new HashSet<>();
            int maxLen = 0;
            for(String str : wordDict){
                maxLen = Math.max(maxLen, str.length());
                dictSet.add(str);
            }
            //增加一位，表示j为空字符串
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;
            int last = -1; //上一个匹配位置
            for(int i = 0; i < len; i++){
                //已有超过最大单词长度的字符未匹配
                if(i - last > maxLen){
                    return false;
                }
                //j多一位，j=i时，表示只有当前i一位
                for(int j = Math.max(i + 1 - maxLen, 0); j < i + 1; j++){
                    if(dp[j] && dictSet.contains(s.substring(j, i+1))){
                        //找到一个满足条件的即可
                        dp[i + 1] = true;
                        last = i;
                        break;
                    }
                }
            }
            //System.out.println(Arrays.toString(dp));
            return dp[len];
        }
    }
}
