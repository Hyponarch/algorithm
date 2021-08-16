package LeetCode;

import tools.ParseString;

import java.util.Arrays;
import java.util.TreeMap;

public class Problem_5748 {
    public static void main(String[] args) {
        Solution s = new Problem_5748().new Solution();
        int[][] intervals = ParseString.stringToArrArr("[[1,4],[2,4],[3,6],[4,4]]");
        int[] queries = new int[]{2,3,4,5};
        System.out.println(Arrays.toString(s.minInterval(intervals, queries)));
    }
    class Solution {
        public int[] minInterval(int[][] intervals, int[] queries) {
            //idx和端点值
//            TreeMap<Integer, Integer> left = new TreeMap<>();
//            TreeMap<Integer, Integer> right = new TreeMap<>();
//            for(int i = 0; i < intervals.length; i++){
//                left.put(i, intervals[i][0]);
//                right.put(i, intervals[i][1]);
//            }

            //minLen[i]表示i对应的idx和最短区间长度
//            int[][] minLen = new int[(int)1e7 + 1][2];
////            Arrays.fill(minLen, Integer.MAX_VALUE);
//            //第j个区间
//            for(int j = 0; j < intervals.length; j++){
//                int[] interval = intervals[j];
//                int len = interval[1] - interval[0] + 1;
//                //区间的范围
//                for(int i = interval[0]; i <= interval[1]; i++){
//                    if(minLen[i][1] == 0 || len < minLen[i][1]){
//                        minLen[i][0] = j;
//                        minLen[i][1] = len;
//                    }
//                }
//            }
//            int[] ans = new int[queries.length];
//            //每个查询
//            for(int i = 0; i < queries.length; i++){
//                ans[i] = minLen[queries[i]][0];
//            }
//            return ans;
            int[] minLen = new int[(int)1e7 + 1];
//            Arrays.fill(minLen, Integer.MAX_VALUE);
            //第j个区间
            for(int j = 0; j < intervals.length; j++){
                int[] interval = intervals[j];
                int len = interval[1] - interval[0] + 1;
                //区间的范围
                for(int i = interval[0]; i <= interval[1]; i++){
                    if(minLen[i] == 0 || len < minLen[i]){
                        minLen[i] = len;
                    }
                }
            }
            int[] ans = new int[queries.length];
            //每个查询
            for(int i = 0; i < queries.length; i++){
                int len = minLen[queries[i]];
                ans[i] = len == 0 ? -1 : len;
            }
            return ans;
        }
    }
}
