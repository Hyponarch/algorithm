package LeetCode;

import java.util.*;

public class Problem_5692 {
    public static void main(String[] args) {
        Solution s = new Problem_5692().new Solution();
        s.getCollisionTimes(new int[][]{{3,4},{5,4},{6,3},{9,1}});
    }

    /**
     * 考虑一个问题，如果前车一定时间内不与他的前车相遇，
     * 当前的车i与前车i+1相遇所需的时间为:当s[i] > s[i+1]时t[i] = (p[i+1] - p[i]) / (s[i] - s[i+1])
     * 否则为无穷
     * 而如果i+1在与i相遇前，与i+2相遇了，则此时由于i尚未追上i+1，而此后i+1与i+2相同（且由于追上了，必有s[i+2] < s[i]）
     * 也就相当于要追上i+2
     * 此时t[i] = (p[i+2] - p[i]) / (s[i] - s[i+2])
     * 此时比较t[i]与t[i+2] = (p[i+3] - p[i+2]) / (s[i+2] - s[i+3])
     * 如果前者更小，就此结束
     * 否则继续向后比较t[i] = (p[i+3] - p[i]) / (s[i] - s[i+3])与t[i+3] = (p[i+4] - p[i+3]) / (s[i+3] - s[i+4])
     * 故而使用单调栈
     */
    class Solution {
        public double[] getCollisionTimes(int[][] cars) {
            Deque<Integer> stack = new LinkedList<>();
            int len = cars.length;
            for(int i = 0; i < len - 1; i++){
                stack.push(i);
                if(cars[i][1] <= cars[i+1][1]){

                }
                for(int j = i; j < len; j++){

                }
            }
            return new double[0];
        }
    }
    /*
    class Solution {
        public double[] getCollisionTimes(int[][] cars) {
            //相遇的车一定是相邻的车，找到最早相遇的车，对每组相邻的车，求前者与后者距离之差/后者与前者速度之差，
            //速度差<=0时，在前者与速度更慢的车相遇前，都不可能与后者相遇，所以时间记为无穷
            //找到最小的时间，合并这2个车，并且更新所有车的位置
            int len = cars.length;

            double[] position = new double[len];
            for(int i = 0; i < len; i++){
                position[i] = cars[i][0];
            }
            //只考虑与前车相遇
            double[] ans = new double[len];
            for(int i = 0; i < len; i++){
                ans[i] = -1;
            }
            //已经和前车相遇的车
            Set<Integer> pass = new HashSet<>();

            double currTime = 0d;

            while(pass.size() < len){
                double minMT = Double.MAX_VALUE;
                int idx = -1;

                //这一轮，最早相遇
                for(int i = 0; i < len - 1; i++){
                    //去除已相遇的车
                    if(!pass.contains(i)){
                        double t;
                        int speed = cars[i][1] - cars[i+1][1];
                        if(speed <= 0){
                            continue;
                        }
                        double dis = position[i+1] - position[i];
                        double meetTime = dis / speed;
                        //最早相遇的车
                        if(meetTime < minMT){
                            minMT = meetTime;
                            idx = i;
                        }
                    }
                }
                //没有任何车能相遇的
                if(idx == -1){
                    break;
                }
                //相遇
                currTime += minMT;
                ans[idx] = currTime;
                pass.add(idx);

                //更新位置
                for(int j = 0; j < len; j++){
                    position[j] += cars[j][1] * minMT;
                }
                //修改速度为较慢的，要修改该块的所有的车

                while(idx >= 0){
                    if(pass.contains((idx))){
                        int s = Math.min(cars[idx][1], cars[idx + 1][1]);
                        cars[idx][1] = s;
                        cars[idx + 1][1] = s;
                    }
                    idx--;
                }
            }
            return ans;


        }
    }
    */
}
