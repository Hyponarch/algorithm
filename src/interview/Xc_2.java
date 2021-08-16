package interview;

import java.util.*;

public class Xc_2 {
    //编辑距离，单位是单词
    //只对b进行操作，
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("<trip>");
        String[] a = input[0].split("[ ]+");// sc.nextLine().split("[ ]+");
        String[] b = input[1].split("[ ]+"); // sc.nextLine().split("[ ]+");
        int m = a.length;
        int n = b.length;

        //dp[i][j]表示a的前i个单词，与b的前j个单词的编辑距离
        //对b删除字符与对a添加一个相同字符的操作是等价的
        //那么就只有2种操作，插入和修改
        //如果a[i] == b[j], 则dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
        //如果a[i] != b[j]，则dp[i][j] = Math.min(dp[i-1][j-1] + 1, Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1));

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(a[i].equals(b[j])){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1));
                }
            }
        }
        System.out.printf("%.2f", 1 - dp[m-1][n-1] / ((double)m));

    }
}
