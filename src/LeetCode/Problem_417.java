package LeetCode;

import java.util.*;

/**
 * @author luchenl.chen
 * email: luchenl.chen@qunar.com
 * create date: 2022/4/27 10:50
 * @version : 1.0
 * description:
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。“太平洋”处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 *
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵heights，heights[r][c]表示坐标 (r, c) 上单元格 高于海平面的高度 。
 *
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 *
 * 返回 网格坐标 result的 2D列表 ，其中result[i] = [ri, ci]表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋 。
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/pacific-atlantic-water-flow">https://leetcode-cn.com/problems/pacific-atlantic-water-flow</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem_417 {
    public static void main(String[] args) {
        Solution s = new Problem_417().new Solution();
        System.out.println(s.pacificAtlantic(new int[][]{new int[]{2, 1}, new int[]{1, 2}}));
    }
    class Solution {
        //对于Set<int[]>无法用contains判断是否存在相同元素，因为int[]是对象，比较的是地址。虽然Arrays.equals可以判断数组元素是否相同
        Set<String> leftUpper = new HashSet<>();
        Set<String> rightDown = new HashSet<>();
        int[][] directs = new int[][]{new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}};
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            //本质是找一个能同时到达左上和右下边界的非严格递减序列的起点
            //反过来思考，从左上和右下边缘出发，按非严格递增序列，找到能经过的点，得到2个集合，求交集
            //左上角和右下角可以单独考虑
            //回溯法
            int m = heights.length;
            int n = heights[0].length;
            //左边界
            for (int i = 0; i < m; i++){
                backTrack(new int[]{i, 0}, heights, leftUpper);
            }
            //上边界
            for (int i = 1; i < n; i++) {
                backTrack(new int[]{0, i}, heights, leftUpper);
            }
            //右边界
            for (int i = 0; i < m; i++){
                backTrack(new int[]{i, n - 1}, heights, rightDown);
            }
            //下边界
            for (int i = 0; i < n; i++){
                backTrack(new int[]{m - 1, i}, heights, rightDown);
            }
            List<List<Integer>> ans = new ArrayList<>();
            for(String s: leftUpper){
                if(rightDown.contains(s)){
                    String[] sArray = s.split(",");
                    ans.add(Arrays.asList(Integer.parseInt(sArray[0]), Integer.parseInt(sArray[1])));
                }
            }
            return ans;
        }
        void backTrack(int[] curr, int[][] heights, Set<String> visited){
            //满足能到达边界的点，加入集合
            visited.add(curr[0] + "," + curr[1]);
            for(int[] direct: directs){
                int[] next = new int[]{curr[0] + direct[0], curr[1] + direct[1]};
                //已访问过
                if(visited.contains(next[0] + "," + next[1])
                        //越界
                        || (next[0] < 0 || next[0] >= heights.length || next[1] < 0 || next[1] >= heights[0].length)
                        //比当前位置更矮
                        || heights[next[0]][next[1]] < heights[curr[0]][curr[1]]){
                    continue;
                }
                backTrack(next, heights, visited);
            }
        }
    }
}
