package LeetCode;

/**
 * @author luchenl.chen
 * email: luchenl.chen@qunar.com
 * create date: 2022/6/8 11:07
 * @version 1.0
 * description:
 */
public class Problem_1037 {


    class Solution {
        public boolean isBoomerang(int[][] points) {
            //重合
            if((points[0][0] == points[1][0] && points[0][1] == points[1][1])
                    || (points[0][0] == points[2][0] && points[0][1] == points[2][1])
                    ||(points[1][0] == points[2][0] && points[1][1] == points[2][1])){
                return false;
            }

            //有2个点连线垂直
            if(points[1][0] - points[0][0] == 0 || points[2][0] - points[1][0] == 0) {
                //另一个不为0，排除了垂直共线
                if(points[1][0] - points[0][0] != 0 || points[2][0] - points[1][0] != 0) {
                    return true;
                } else {    //另一个也是0
                    return false;
                }
            } else {    //AB和BC都不垂直x轴
                double k10 = (points[1][1] - points[0][1]) * 1d / (points[1][0] - points[0][0]);
                double k21 = (points[2][1] - points[1][1]) * 1d / (points[2][0] - points[1][0]);
                return !(k10 == k21);
            }



//            if(points[1][0] - points[0][0] == 0 && points[2][0] - points[1][0] == 0) {
//                return false;
//            } else {
//                double k10 = (points[1][1] - points[0][1]) * 1d / (points[1][0] - points[0][0]);
//                double k21 = (points[2][1] - points[1][1]) * 1d / (points[2][0] - points[1][0]);
//                return !(k10 == k21);
//            }
        }
    }
}
