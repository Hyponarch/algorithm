package LeetCode;

public class Problem_1103 {
    public static void main(String[] args) {
        Problem_1103 p = new Problem_1103();
        Solution s = p.new Solution();
        for( int i : s.distributeCandies(1000000000, 1000)){
            System.out.print(i+",");
        }
    }
    class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            //第一次t[1]=(1+n)*n/2，第二次t[2]=t[1]+n^2，前k项和为sum[k]=k*t[1]+(0+k-1)*k/2 * n^2
            //求解小于candies的最大k，再分配最后一趟
            int n = num_people;
            //n^2*k^2 + n*k - 2s = 0, 二次方程解=(-b+- sqrt((b^2 - 4ac)/2a))
            //对称轴在-1/2n，所以必有一个负根，舍去
            int k = (int) ( (-n + Math.sqrt(n*n + (long)8L*n*n*candies ) ) / (2*n*n) );
            int used = (n*n*k*k + n*k)/2;
            int curr = candies - used;
            int first = k + n;
            int[] ans = new int[n];
            //第一个人依次分到1，n+1, 2n+1
            //第m个人依次分到m, m+n, m+2n... ,合计km+n*(1+k-1)*(k-1)/2=km+k(k-1)个
            for(int i = 1; i<n+1; i++){
                ans[i-1] = i*k + n*k*(k - 1)/2;
                int c =  i + k*n;
                if(curr >= c){
                    ans[i-1] += c;
                    curr -= c;
                }else if (curr > 0){
                    ans[i-1] += curr;
                    curr = 0;
                }
            }
            return ans;
        }
    }
}
