package interview;

import java.util.*;

/**
 4
 3 50
 3 1
 6 2
 9 3
 2 50
 6 5
 10 5
 2 50
 2 1
 10 5
 3 70
 100 1
 200 1
 300 1


 1
 3 70
 100 1
 200 1
 300 1
 */
public class Mhy_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();   //数据组数

        for(int g = 0; g < group; g++){
            int n = sc.nextInt();   //士兵数量
            int p = sc.nextInt();   //百分比数
            int[] a = new int[n];   //睡好了
            int[] b = new int[n];   //没睡好
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }
//            int k = n * p / 100;
//            PriorityQueue<Integer>
            //要让最高战力值尽可能小，才能保证大于等于x * p / 100战力的士兵数量多
            //找到没睡好的战斗力的最大值，该值为最大值的最小取值，最大值的最大取值为睡好了的最大值
            //要让落在[候选值*p/100, 候选值]范围内的数尽可能多
            int minMax = 0;
            for(int i : b){
                minMax = Math.max(minMax, i);
            }
            List<Integer> candidate = new ArrayList<>();
            candidate.add(minMax);
            for(int i : a){
                if(i > minMax){
                    candidate.add(i);
                }
            }
            //对每个候选值
            int ans = 0;
            for(int c : candidate){
                int count = 0;
                double pivot = p * (double)c / 100;
                for(int i = 0; i < n; i++){

                    if((a[i] >= pivot && a[i] <= c) || (b[i] >= pivot && b[i] <= c)){
                        count++;
                    }
                }
                ans = Math.max(ans, count);
            }
            System.out.println("Case #" + (g+1)+ ": " + ans);
        }




    }
}
