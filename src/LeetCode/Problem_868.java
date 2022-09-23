package LeetCode;

/**
 * @author luchenl.chen
 * email: luchenl.chen@qunar.com
 * create date: 2022/4/24 14:33
 * @version : 1.0
 * description:
 */
public class Problem_868 {

    class Solution {
        public int binaryGap(int n) {
            int gap = 0;
            int start = -1;
            int curr = 0;
            while (n > 0){
                if(n % 2 == 1){
                    if(start != -1){
                        gap = Math.max(gap, curr - start);
                    }
                    start = curr;
                }
                curr ++;
                n /= 2;
            }
            return gap;
        }
    }
}
