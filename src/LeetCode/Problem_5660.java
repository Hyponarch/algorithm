package LeetCode;
import java.util.*;
public class Problem_5660 {
    public static void main(String[] args) {
        Problem_5660 p = new Problem_5660();
        Solution s = p.new Solution();
        int[][] event = new int[][]{{1,1,1},{2,2,2},{3,3,3},{4,4,4}};
        s.maxValue(event , 3);
    }
    class Solution {
        public int maxValue(int[][] events, int k) {
            //dp[i]=i时间结束的最大价值
            //当前的会议j时间[s, e, v],如果s>=i，dp[j]=dp[i]+v
            //如果s<i && e>=i,
            //就是比较当前的dp[i]与e以前的最大dp+当前哪个比较大

            //按结束时间排序
            Arrays.sort(events, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    if(a[1]==b[1]){ //结束时间升序
                        if(a[0] == b[0]){   //开始时间升序
                            return b[2] - a[2]; //价值降序
                        }
                        return a[0]-b[0];
                    }
                    return a[1] - b[1];
                }
            });

            int len = events.length;
            int[] endTime = new int[len];
            for(int i=0;i<len;i++){
                endTime[i] = events[i][1];
            }

            // int[] dp = new int[endTime[len-1]];
            // dp[endTime[0]] = events[0][2];
            Map<Integer, Integer> dp = new HashMap<Integer, Integer>(); //endTime, value
            dp.put(events[0][1], events[0][2]);
            //events[i] = [startDayi, endDayi, valuei]
            for(int i=1;i<len;i++){
                int currStart = events[i][1];
                int currValue = events[i][2];
                if(currStart >= endTime[i-1]){  //如果时间错开
                    int value = dp.get(endTime[i-1]) + currValue;
                    dp.put(endTime[i], value);
                }else{  //如果时间有重叠，要找到endTime中，小于currStart的最大值
                    //线性查找
                    int last=0;
                    int j;
                    for(j=0;j<i;j++){
                        if(endTime[j]<=currStart && endTime[j+1]>currStart){
                            last = j;
                            break;
                        }
                    }
                    if(j!=i){ //找到了目标
                        int sum = dp.get(endTime[last]) + currValue;
                        dp.put(endTime[i], Math.max(sum, dp.get(endTime[i-1])));
                    }else{//未找到目标，则last为0,只能参加这一场
                        dp.put(endTime[i], Math.max(currValue, dp.get(endTime[i-1])));
                    }

                }
                //dp[i] =
            }
            int maxValue=0;
            for(Integer i : dp.values()){
                maxValue = Math.max(maxValue, i);
            }
            return maxValue;

        }

    }
}
