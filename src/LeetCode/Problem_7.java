package LeetCode;

public class Problem_7 {
    //这题偏trick，想不到对应的trick会比较难写
    class Solution {
        public int reverse(int x) {
            int reverse = 0;
            while (x != 0) {
                //我们有int tmp = reverse * 10 + x % 10
                //而x % 10是个位数，reverse * 10最后一位是0，reverse * 10 + x % 10是不会产生进位的
                //因而在不溢出的情况下tmp / 10 == reverse
                //反之tmp / 10 != reverse，就是发生了溢出
                int tmp = reverse * 10 + x % 10;
                if (tmp / 10 != reverse) { // 溢出!!!
                    return 0;
                }
                reverse = tmp;
                x /= 10;
            }
            return reverse;
        }
    }
}
