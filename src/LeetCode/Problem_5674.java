package LeetCode;

public class Problem_5674 {
    public static void main(String[] args) {

        Solution s = new Problem_5674().new Solution();
        String s1 = "abcabc";

        String s2 =   "abdcaba";

        System.out.println(s.largestMerge(s1, s2));

    }
    class Solution {
        public String largestMerge(String word1, String word2) {
            StringBuilder ans = new StringBuilder();
            int p=0;
            int q=0;
            int len1 = word1.length();
            int len2 = word2.length();
            while(p < len1 || q < len2){
                //简单思路，比较当前字符：谁大取谁，相同则比较后续字符串，后续字符串谁大取谁，可以用字符串比较方法str1.compareTo(str2)
                if(p >= len1){
                    ans.append(word2.charAt(q));
                    q++;
                }else if(q >= len2){
                    ans.append(word1.charAt(p));
                    p++;
                }else {
                    char pC = word1.charAt(p);
                    char qC = word2.charAt(q);
                    if(pC > qC){
                        ans.append(pC);
                        p++;
                    }else if(pC < qC){
                        ans.append((qC));
                        q++;
                    }else {
                        if( word1.substring(p, len1).compareTo( word2.substring(q, len2) ) >= 0){
                            ans.append(pC);
                            p++;
                        }else {
                            ans.append(qC);
                            q++;
                        }
                    }
                }
            }
            return ans.toString();
        }
    }
}
