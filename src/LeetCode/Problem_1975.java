package LeetCode;

public class Problem_1975 {
    class Solution {
        public long maxMatrixSum(int[][] matrix) {
            //每次变化，要么将2个正数变负，要么将2个负数变正，要么将正负变成负正
            //那么正负数总量的奇偶性是不会变的
            //如果负数是奇数个，那么一定会剩一个，那么就是最大的那个X
            //让绝对值最小的那个数变负
            //正数和 - 负数和 - 2 * 最小绝对值
            //偶数则全正
            //正数和
            long positive = 0;
            //负数和
            long negative = 0;
            //负数个数
            int negativeCount = 0;

            int minAbs = Integer.MAX_VALUE;


            //最大负数
//            int maxNegative = Integer.MIN_VALUE;
            //最小正数
//            int minPositive = Integer.MAX_VALUE;

            for (int[] ints : matrix) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int curr = ints[j];
                    //0可以翻转，算做负数更合适
                    if (curr >= 0) {
                        positive += curr;
//                        minPositive = Math.min(minPositive ,curr);
                    } else {
                        negative += curr;
                        negativeCount++;
//                        maxNegative = Math.max(maxNegative, curr);
                    }
                    minAbs = Math.min(minAbs, Math.abs(curr));

                }
            }
            long ans = positive - negative;
            if(negativeCount % 2 != 0){
                ans = ans - 2 * minAbs;

//                if(-1 * maxNegative > minPositive){
//                    ans = ans - 2 * minPositive;
//                }else {
//                    ans = ans + 2 * maxNegative;
//                }
            }
            return ans;
        }
    }
}
