package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author luchenl.chen
 * email: luchenl.chen@qunar.com
 * date: 2021/8/12 20:34
 * description:
 * @version : 1.0
 */
public class Problem_56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            int len = intervals.length;
            //如果intervals是空数组，则返回一个空数组
            if(len == 0){
                return intervals;
            }
            //先进行排序，排序之后[a, b], [c, d]
            //传入自定义比较器的3种写法
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
//                    return Integer.compare(o1[0], o2[0]);
                }
            });

//            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
//            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            //排序之后，将各区间合并，合并时，记录右边界，如果下一个区间的左边界大于等于当前的右边界
            //则可以合并
            //否则将合并好的区间加入答案，以当前区间作为新的开始继续合并
            List<int[]> ans = new ArrayList<>();
            //左右边界初始化为第一个区间的边界
            int left = intervals[0][0];
            int right = intervals[0][1];

            for(int i = 1; i < len; i++){
                //如果当前区间的左边界小于等于合并区间的右边界
                if(intervals[i][0] <= right){
                    //进行合并，新区间的右边界由原右边界和当前区间右边界的较大值决定
                    right = Math.max(intervals[i][1], right);
                }else {
                    //无法合并则将已合并区间加入答案，当前区间作为新区间的开始
                    //此时不会处理最后一个区间
                    ans.add(new int[]{left, right});
                    left = intervals[i][0];
                    right = intervals[i][1];
                }
            }
            ans.add(new int[]{left, right});
            int[][] res = new int[ans.size()][];
            for (int i = 0; i < ans.size(); i++){
                res[i] = ans.get(i);
            }
            return res;

        }
    }
}
