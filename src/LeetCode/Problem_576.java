package LeetCode;

public class Problem_576 {
    public static void main(String[] args) {
        Solution s = new Problem_576().new Solution();
        System.out.println(s.findPaths(2, 2, 2, 0, 0));
    }

    class Solution {
        int ans = 0;
        int divisor = (int)1e9+7;
        int[][] directs;
        int[] pow;
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            //典型的dfs，回溯法
            //定义4个方向
            directs = new int[][]{new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}};
            pow = new int[maxMove + 1];
            //可以回头，每走一步都有4种可能，剩余n步，就会有4^n种结果
            //求幂可以用Math.pow，也可以用快速幂法
            //Math.pow取幂转整数时依旧可能出现溢出情况，double本身的精度和范围也可能不满足要求
            dfs(startRow, startColumn, maxMove, m, n);
            return ans;
        }

        /**
         *
         * @param r 当前行
         * @param c 当前列
         * @param remain    剩余步数
         * @param m 总行数
         * @param n 总列数
         */
        void dfs(int r, int c, int remain, int m, int n){
            //出界则停止并计算结果
            if(r < 0 || r >= m || c < 0 || c >= n){
                //计算加法时，仍应该使用long保存结果，这由quickPowerIteration的返回值为long保证，完成计算后，再转成int
                //因为涉及多次重复计算，可以用备忘录数组来保存结果
                if(pow[remain] != 0){
                    ans += pow[remain];
                }else {
                    ans = (int)((ans + quickPowerIteration(4, remain)) % divisor);
                }
                return;
            }
            //步数走完
            if(remain == 0){
                return;
            }
            for(int[] direct : directs){
                dfs(r + direct[0], c + direct[1], remain - 1, m, n);
            }
        }

        /**
         * 简单求幂的方法，求x^n，时间复杂度为O(n)
         * @param base  底数
         * @param exponent  指数
         * @return  幂对divisor求模后的结果
         */
        int power(int base, int exponent){
            int ans = 1;
            while(exponent > 0){
                //ans * exponent 可能会溢出
                ans = (int)(((long)ans * base) % divisor);
                exponent--;
            }
            return ans;
        }

        /**
         * 快速幂法，求x^n，将n分解为二进制位，例如n = 14 = 2 + 4 + 8，也就是说x^14 = x^8 * x^4 * x^2, 而x^4 = (x^2)^2, x^8 = (x^4)^2
         * 按简单求幂法，需要计算7次幂，而此时仅需要计算3次
         * 本方法为递归实现，以n = 14为例，实际计算的是x^14 = (x^7)^2, x^7 = (x^3)^2 * x, x^3 = (x)^2 * x
         * 参见：https://oi-wiki.org/math/quick-pow/
         * @param base  底数
         * @param exponent  指数
         * @return  幂对divisor求模的结果，用long保存结果，避免强制转换，但实际可以保证数字范围在int内
         */
        long quickPower(int base, int exponent){
            //递归终止条件
            if(exponent == 0){
                return 1;
            }
            long result = quickPower(base, exponent / 2);
            //取模的运算不会干涉乘法运算
            //根据费马小定理，如果m是一个质数，我们可以计算x^(n % (m-1))来加速算法过程。
            //我们只要保证每一步的结果都小于Integer.MAX_VALUE，那么平方就会小于Long.MAX_VALUE
            if(exponent % 2 == 0){
                return (result * result) % divisor;
            }else {
                //平方*base仍可能超出int的范围
                return ((result * result) % divisor * base) % divisor;
            }
        }

        /**
         * 迭代法计算快速幂
         * @param base  底数
         * @param exponent  指数
         * @return  幂对divisor求模的结果，用long保存结果，避免强制转换，但实际可以保证数字范围在int内
         */
        long quickPowerIteration(int base, int exponent){
            int remainExponent = exponent;
            long ans = 1;
            while (remainExponent > 0){
                if((remainExponent & 1) == 1){
                    ans *= base;
                }
                //因子平方
                base *= base;
                //指数右移一位，即/2
                remainExponent >>= 1;
            }
            pow[exponent] = (int)ans;
            return ans;
        }
    }
}
