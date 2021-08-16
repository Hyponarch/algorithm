package interview;

public class JZ_10_1 {
    public static void main(String[] args) {
        JZ_10_1 j = new JZ_10_1();
        Solution s = j.new Solution();
//        Runtime.Version version = Runtime.version();
        //version.version()
        System.out.println( s.fib(95));
    }
    class Solution {
        public int fib(int n) {
            if(n==0){
                return 0;
            }
            long[] dp = new long[n+1];
            dp[0]=0;
            dp[1]=1;
            for(int i=2;i<n+1;i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            long ans = dp[n] % 1000000007L;
            return (int)ans;
        }
    }
}
