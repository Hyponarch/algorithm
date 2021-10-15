package LeetCode;

/**
 * @author luchenl.chen
 * @date 2021/10/15 11:04
 */
public class Problem_38 {
    public static void main(String[] args) {
        System.out.println(new Problem_38().new Solution().countAndSay(4));
    }

    class Solution {
        public String countAndSay(int n) {

            StringBuilder lastStr = new StringBuilder("1");

            //从1开始，向着n遍历
            for(int i = 1; i < n; i++){
                //考察ans[i-1]的结构
                int left = 0;
                int right = 1;

                StringBuilder tmp = new StringBuilder();
                while (right < lastStr.length()){
                    if(lastStr.charAt(left) != lastStr.charAt(right)){
                        tmp.append(right - left).append(lastStr.charAt(left));
                        left = right;
                    }
                    right++;
                }
                tmp.append(right - left).append(lastStr.charAt(left));
                lastStr = tmp;
            }
            return lastStr.toString();
        }
    }
}
