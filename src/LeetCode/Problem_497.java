package LeetCode;

/**
 * @author luchenl.chen
 * email: luchenl.chen@qunar.com
 * create date: 2022/6/9 10:22
 * @version 1.0
 * description:
 */
public class Problem_497 {
    class Solution {
        //累计计数
        long[] pointCount;
        int yRange;
        public Solution(int[][] rects) {
            //多个矩形，先算每个矩形范围内的点的个数，然后按这些个数取随机，最后在得到的矩形内随机
            pointCount = new long[rects.length];
            for(int i = 0; i < rects.length; i++) {
                pointCount[i + 1] = (long) (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1) + pointCount[i];
            }

        }

//        public int[] pick() {
//
//        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
}
