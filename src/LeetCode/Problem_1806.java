package LeetCode;

import java.util.*;

public class Problem_1806 {
    public static void main(String[] args) {
        Solution s = new Problem_1806().new Solution();
        System.out.println(s.reinitializePermutation(8));
    }
    class Solution {
        public int reinitializePermutation(int n) {
            int[] perm = new int[n];
            for(int i = 0; i < n; i++){
                perm[i] = i;
            }
            int[] arr = Arrays.copyOf(perm, n);

            int[] tmp = new int[n];
            int count = 0;
            while(true){

                //tmp复制arr的数
                tmp = Arrays.copyOf(arr, n);
                count++;
                //修改arr的值
                for(int i = 0; i < n; i++){
                    if(i % 2 == 0){
                        arr[i] = tmp[i / 2];
                    }else{
                        arr[i] = tmp[n / 2 + (i - 1) / 2];
                    }
                }
                boolean same = true;
                //比较当前的arr和perm，如果有一个不同，则不同
                for(int j = 0; j < n; j++){
                    if(arr[j] != perm[j]){
                        same = false;
                        break;
                    }
                }
                //如果相同，则返回当前的操作次数
                if(same){
                    return count;
                }
            }
        }
    }
}
