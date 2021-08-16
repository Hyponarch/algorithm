package interview;
import java.util.*;
public class QAX_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int currMoney = sc.nextInt();
        int m = sc.nextInt();
        int[] stock = new int[m];   //物品类别
        int[] currPrice = new int[m];
        int[] finalPrice = new int[m];
        for(int i = 0; i < m; i++){
            stock[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            currPrice[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            finalPrice[i] = sc.nextInt();
        }

        int[] profit = new int[m];
        for(int i = 0; i < m; i++){
            profit[i] = finalPrice[i] - currPrice[i];
        }
        //多重背包问题
        int[][] dp = new int[m+1][currMoney+1];
        for(int i = 1; i < m + 1; i++){
            for(int j =1; j < currMoney + 1; j++){
                //价格超过当前的钱数
                if(currPrice[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
//                    int maxNums = Math.min(stock[i-1], j / currPrice[i-1]);
                    for(int k = 0; k * currPrice[i-1] <= j && k <= stock[i-1]; k++){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j - k * currPrice[i-1]] + k * profit[i-1]);
                    }
                }
            }
        }
        System.out.println(dp[m][currMoney]);
    }
}
