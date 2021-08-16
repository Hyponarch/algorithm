package LeetCode;

public class Problem_5738 {

    class Solution {
        public int sumBase(int n, int k) {
            int ans = 0;
            //求余
            while(n > 0){
                ans += n % k;
                n /= k;
            }
            return ans;
        }
    }
}
