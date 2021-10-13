package LeetCode;

public class Problem_1211 {
    class Solution {
        public int balancedStringSplit(String s) {
            //一个子字符串A是平衡的，是否存在一种划分使得AB的划分能得到更多的平衡子串
            //A平衡、AB平衡，故B平衡，划分为A|B可以得到2个子串
            //因此只要得到一个平衡子串，即可立即划分
            //换言之，贪心
            int left = 0;
            int right = 1;
//            int lCount = 0;
//            int rCount = 0;
            int balance = 0;    // l - r, 回到0则平衡
            while (right < s.length()){

            }
            return -1;
        }
    }
}
