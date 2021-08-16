package interview;

import java.util.*;

public class JD_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        int count = (n-2)*(m-2);
        int ans = 0;
        while(count > 0){
            int min = Integer.MIN_VALUE;
            for(int i = 1; i < n - 1; i++){
                for(int j = 1; j < m - 1; j++){
                    min = Math.min(min, nums[i][j]);
                }
            }
            for(int i = 1; i < n - 1; i++){
                for(int j = 1; j < m - 1; j++){
                    if(nums[i][j] == min){

                    }
                }
            }
        }
    }
}
