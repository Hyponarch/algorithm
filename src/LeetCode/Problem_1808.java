package LeetCode;

public class Problem_1808 {

    public static void main(String[] args) {
        Solution s = new Problem_1808().new Solution();
        System.out.println(s.maxNiceDivisors(88));
    }

    class Solution {
        int divide = (int)1e9 + 7;
        public int maxNiceDivisors(int primeFactors) {
            //最小的好因子等同于每种不同的质因子之积，其他的质因子由最小的质因子乘上重复的质因子得到
            //好因子的数目由重复的数量决定
            //假设primeFactors = 5，则重复质因子数分别为2和3时，取得最多的好因子数目
            //将primeFactors拆成若干个数之和，使得这些数的乘积最大
            //对任意一个大于等于4的数，拆分成2个数之后的乘积，都要大于等于它，比如4 = 2*2,5 < 2*3, 6 < 3*3
            //这意味着我们的拆分中，不会出现比3大的数，所有的质因子的数目全部为2或者3
            //而拆分为3能比拆分为2使得乘积更大，比如6拆分为2^3 = 8，而3^2 = 9，10拆分为2^5 = 32，而2^2 * 3^2 = 36,
            //12拆分为2^6 = 64, 拆分为3^4 = 81
            //由此，m = primeFactors % 3, n = primeFactors / 3
            //m == 0时，全部替换为n个3
            //m == 1时，替换为n - 1个3和2个2
            //m == 2时，替换为n个3和1个2
            //整数10为底的指数用1e9+7
            //取模运算，如果m % n = a, 那么m * b % n = a * b % n = (m % n) * b % n, 先乘还是先求模，不影响最后求模的值

            //如果只有一个质因数，则只有一个好因子（这个质因数本身）
            if(primeFactors == 1){
                return 1;
            }
            int m = primeFactors % 3;
            int n = primeFactors / 3;

            //溢出问题
            if(m == 0){
                return (int)pow(3, n);
            }else if(m == 1){
                //返回值如果是int，那么返回值*4可能会溢出
                long res = pow(3, n - 1) * 4 % divide;
                return (int)res;
            }else{
                long res = pow(3, n) * 2 % divide;
                return (int)res;
            }
        }

        //快速幂求解幂值
        //为什么返回值必须是long？
        long pow(int a, int b){
            if(b == 0){
                return 1;
            }
            long res = pow(a, b/2) % divide;
            //如果res是int，那么res * res的过程中就会溢出
            long tmp = res * res % divide;
            return b % 2 == 0 ? (int)tmp : (int)(tmp * a % divide);
        }
    }
}
