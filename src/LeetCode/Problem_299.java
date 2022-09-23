package LeetCode;

/**
 * @author luchenl.chen
 * @date 2021/11/8 10:41
 */
public class Problem_299 {
    public static void main(String[] args) {
        Solution s = new Problem_299().new Solution();

        System.out.println(s.getHint("1807", "7810"));
    }
    class Solution {
        public String getHint(String secret, String guess) {
            int bull = 0;
            int[] secretNums = new int[10];
            int[] guessNums = new int[10];
            for(int i = 0; i < secret.length(); i++){
                char s = secret.charAt(i);
                char g = guess.charAt(i);
                if(s == g){
                    bull++;
                }else {
                    secretNums[s-'0']++;
                    guessNums[g-'0']++;
                }
            }
            int cow = 0;
            for(int i = 0; i < secretNums.length; i++){
                cow += Math.min(secretNums[i], guessNums[i]);
            }
            return new StringBuilder().append(bull).append("A").append(cow).append("B").toString();
        }
    }
}
