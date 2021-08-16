package interview;

import java.util.*;

public class Beike_4 {
    static int[] a;
    static long[] prefixSum;
    static Map<Integer, Boolean> sMap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int[] s = new int[q];
        sMap = new HashMap<>();
        for(int i = 0; i < q; i++){
            int num = sc.nextInt();
            sMap.put(num, false);
            s[i] = num;   //目标
        }
        Arrays.sort(a);
        //第一位为0，合计n+1位
        prefixSum = new long[n + 1];
        for(int i = 0; i < n; i++){
            prefixSum[i+1] = prefixSum[i] + a[i];
        }
//        System.out.println(Integer.MAX_VALUE > 1e9);

        //dfs，分别对每种情况写入结果
        dfs(0, n - 1);
        for(int i : s){
            if(sMap.get(i)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
    static void dfs(int left, int right){
        if(left == right){
            if(sMap.containsKey(a[left])){
                sMap.put(a[left], true);
            }
            return;
        }
        //假定a有序，均值可由前缀和得区间和快速计算，每次计算均值后划分，可用二分查找
        long intervalSum = prefixSum[right + 1] - prefixSum[left];
        if(intervalSum <= 1e9 && sMap.containsKey((int)intervalSum)){
            sMap.put((int)intervalSum, true);
        }
        long avg = intervalSum / (right - left + 1);
        //均值不可能大于1e9
        //如果不存在，返回的是负的插入位置
        int bs = Arrays.binarySearch(a, (int)avg);
        int idx = bs >= 0 ? bs : -1 * bs - 2;
        //分别对两侧进行递归
        //存在avg时，avg下标为bs，left ~ bs均小于等于avg
        if(idx >= left && idx <= right){
            dfs(left, idx);
            //此时，小于等于
            if(!(bs >= 0 && idx == right)){
                dfs(idx + 1, right);
            }

        }
    }
}
/*
5 3
7 2 1 6 5
3
21
30
 */