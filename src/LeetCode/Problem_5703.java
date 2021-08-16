package LeetCode;
import java.util.*;
public class Problem_5703 {

    class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            //每插入一个人，计算一次及格率提升量
            int len = classes.length;

            //用最大堆来维护
            PriorityQueue<double[]> maxImprove = new PriorityQueue<>(new Comparator<double[]>(){
                public int compare(double[] a, double[] b){
                    return a[1] - b[1] >= 0 ? -1 : 1;
                }
            });
            for(int i = 0; i < len; i++){
                double improve = (classes[i][0] + 1) / ((double)classes[i][1] + 1) - classes[i][0] / (double)classes[i][1];
                maxImprove.offer(new double[]{i, improve});
            }
            for(int i = 0; i < extraStudents; i++){
                double[] max = maxImprove.poll();
                int idx = (int)max[0];
//                double max = max[1];

                classes[idx][0]++;
                classes[idx][1]++;
                double improve =  (classes[idx][0] + 1) / ((double)classes[idx][1] + 1) - classes[idx][0] / (double)classes[idx][1];
                maxImprove.offer(new double[]{idx, improve});
            }
            double sum = 0;
            for(int[] d : classes){
                sum += d[0] / (double)d[1];
            }
            return sum / len;

        }
    }
}
