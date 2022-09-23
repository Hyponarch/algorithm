package LeetCode;

/**
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 *
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2：
 *
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *  
 *
 * 提示：
 *
 * 1 <= num < 2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author luchenl.chen
 * @date 2021/10/18 15:09
 */
public class Problem_476 {
    public static void main(String[] args) {
        Solution s = new Problem_476().new Solution();
        System.out.println(s.findComplement(5));
    }
    //1、十进制转二进制
    //2、二进制取反
    //3、二进制转十进制
    class Solution {
        public int findComplement(int num) {
            int factor = 1;
            int ans = 0;
            for(int i = 0; i <= 30; i++){
                if(num < factor){
                    break;
                }
                //(num >> i) & 1 求当前位，1 - res，即该位取补，再左移还原
                ans += (1 - ((num >> i) & 1)) << i;
                factor <<= 1;
            }
            return ans;
        }
    }

}
