package interview;

import java.util.*;

public class Mhy_1 {
    public static void main(String[] args) {
        //0-1背包问题，打到目标，且尽可能小
        //
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //商品种类
        int m = sc.nextInt();   //目标金额
        int[] price = new int[n];
        for(int i = 0; i < n; i++){
            price[i] = sc.nextInt();
        }
        //dp[i][j]表示
    }
}
