package interview;

import java.util.*;

public class Sll_2 {
    public static void main(String[] args) {
        //动态规划
        //dp[i][j]表示下标i~j的子字符串变成回文串的最低代价
        //当str.charAt(i) == str.charAt(j)时，dp[i][j] = dp[i+1][j-1]
        //不等时，则为dp[i+1][j], dp[i][j-1]中的最小值，同时考虑添加与删除2种代价
        int[] add = new int[]{100, 200, 360, 220};
        int[] delete = new int[]{120, 350, 200, 320};
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        long[][] dp = new long[len][len];
        //长度为1的字符串为回文串
        //长度为2的字符串取决于是否相等，若不等，则为4种代价中的最小值
        for(int i = 0; i < len - 1; i++){
            char c = str.charAt(i);
            char n = str.charAt(i+1);
            if(c != n){
                dp[i][i+1] = Math.min(add[c-'1'],
                        Math.min(add[n -'1'],
                                Math.min(delete[c -'1'],
                                        delete[n -'1'])));
            }
        }
        //按长度遍历，l代表l+1的长度
        for(int l = 2; l < len; l++){
            for(int i = 0; i < len - l; i++){
                char c = str.charAt(i);
                char n = str.charAt(i + l);
                if(c == n){
                    dp[i][i + l] = dp[i+1][i+l-1];
                }else {
                    dp[i][i+l] = Math.min(dp[i + 1][i + l] + add[c - '1'],    //在后面插入一个c，使得相等
                            Math.min(dp[i][i + l - 1] + add[n -'1'],    //前面插入一个n
                                    Math.min(dp[i + 1][i + l] + delete[c -'1'], //删除前面的c
                                            dp[i][i + l - 1] + delete[n -'1'])));   //删除后面的n
                }
            }
        }
        System.out.println(dp[0][len-1]);
    }
}
