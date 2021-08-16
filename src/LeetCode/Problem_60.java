package LeetCode;

public class Problem_60 {
    public static void main(String[] args) {

    }

    /**
     * 给定 n 和 k，返回第 k 个由1~n构成的n位的全排列。
     *
     * 1开头的全排列有(n-1)!个
     * 2开头的全排列有(n-1)!个
     * ...
     * n开头的全排列有(n-1)!个
     * 那么第k个全排列的第一位，由k / (n-1)!确定
     * 确定第一位之后，第二位为1的全排列有(n-2)!个，同理
     *
     */
//    class Solution {
//        public String getPermutation(int n, int k) {
//            int[] factorial = new int[n + 1];
//            factorial[0] = 1;
//            for(int i = 1; i < n + 1; i++){
//                factorial[i] = factorial[i-1] * i;
//            }
//            int num = k;
//            StringBuilder sb = new StringBuilder();
//            while(num > 0){
//                //找到比num小的，最大的factorial
//                for(int i = n; i > 0; i--){
//                    if(factorial[i] < num){
//                        int curr = num / factorial[i];
//                        sb.append(curr);
//                        num = num % factorial[i];
//                        break;
//                    }
//                }
////                int curr = num /
//            }
//        }
//    }
}
