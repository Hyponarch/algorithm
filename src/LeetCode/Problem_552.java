package LeetCode;

/**
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 *
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可获得出勤奖励的可能的记录情况的数量 。答案可能很大，所以返回对 10^9 + 7 取余 的结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem_552 {
    public static void main(String[] args) {
        Solution s = new Problem_552().new Solution();
        System.out.println(s.checkRecord(2));
    }
    class Solution {
        int ans = 0;
        int divisor = (int)1e9 + 7;
        public int checkRecord(int n) {
            //分0个A和1个A两种情况讨论
            //然后从头到尾开始找位置放P，要求2个P之间的距离小于3，当前这种情况，使用n个P，可以把0或者1个P变成A，则0个A有count种，1个A有n种
            //合计n + 1
            //把所有的结果全部合在一起即可

            //可以认为-1下标时，为出勤
            dfs(n, 0, 0, -1);
            return ans;
        }

        /**
         *
         * @param n 总天数
         * @param curr  当前的日期
         * @param pNum  已出勤的天数，即P的数量
         * @param last 上一个出勤日，初始值为-1
         */
        void dfs(int n, int curr, int pNum, int last){
            if(curr >= n){
//                if(curr - last < 3){
                    //divisor < Integer.MAX_VALUE / 2, 所以2个小于divisor的数相加一定不会溢出
                    ans = (ans + pNum % divisor  + 1) % divisor;
//                }
                return;
            }
            //最多跟上个P差距3
            for(int i = curr; i <= Math.min(last + 3, n); i++){
                //如果到达边界，则不应该计算这个P，继续递归只是为了统一计算结果
                if(i == n){
                    dfs(n, i + 1, pNum, i);
                }else {
                    dfs(n, i + 1, pNum + 1, i);
                }
            }
        }
    }
}
