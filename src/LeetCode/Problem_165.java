package LeetCode;

public class Problem_165 {

    class Solution {
        public int compareVersion(String version1, String version2) {
            //各一个指针，忽略前导0，直到遇到.
            //然后转数字，比较大小
            int p1 = 0;
            int p2 = 0;
            //越界的视作0
            while (p1 < version1.length() || p2 < version2.length()){
                int curr1 = 0;
                int curr2 = 0;
                //注意越界的处理
                while (p1 < version1.length() && version1.charAt(p1) != '.'){
                    curr1 = curr1 * 10 + version1.charAt(p1) - '0';
                    p1++;
                }
                //取完了该段需要再多走一位, 以跨越.
                p1++;
                while (p2 < version2.length() && version2.charAt(p2) != '.'){
                    curr2 = curr2 * 10 + version2.charAt(p2) - '0';
                    p2++;
                }
                p2++;
                if(curr1 > curr2){
                    return 1;
                }else if(curr1 < curr2){
                    return -1;
                }
            }
            //未分出结果，比如说完全相同，或者是前缀且后半为0: 1.2.0和1.2
            return 0;
        }
    }
}
