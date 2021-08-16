package interview;

import java.util.*;

public class DiDi_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(prado(str));
    }

    static int prado(String str){
        int ans = 1;
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i ++){
            dp[i][i] = true;
        }
        for(int i = 0 ; i < len - 1; i++){
            if(str.charAt(i) == '*' || str.charAt(i+1) == '*' ||str.charAt(i) == str.charAt(i+1)){
                dp[i][i+1] = true;
                ans = 2;
            }
        }
        for(int l = 2; l < len; l++){
            for(int i = 0; i < len - l; i++){
                if(str.charAt(i) == '*' || str.charAt(i+l) == '*' ||str.charAt(i) == str.charAt(i+l)){
                    dp[i][i+l] = dp[i+1][i+l-1];
                    if(dp[i][i+l])
                        ans = Math.max(ans, l + 1);
                }
            }
        }
        return ans;
    }

}
