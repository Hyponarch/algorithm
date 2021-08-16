package interview;

import java.util.*;

public class Beike_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        int[] prefixSum = new int[n + 1];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt() > k ? 1 : -1;
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        //双指针？
        //大于k的记为1，小于等于k的记为-1，求区间和为正数的最大子区间，通过前缀和来优化
        //区间长度
        boolean findAnswer = false;
        for(int l = n; l > 0; l--){
            for(int i = 0; i + l - 1 < n; i++){
                if(prefixSum[i+l] - prefixSum[i] > 0){
                    System.out.println(l);
                    findAnswer = true;
                    break;
                }
            }
            if(findAnswer){
                break;
            }
        }
    }
}
/*
7 8
9 9 6 0 6 6 9

*/