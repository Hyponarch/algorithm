package interview;

import java.util.*;

/**
 * 7
 * 0 1 0 1 2 1 0
 */
/*
public class PDD_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = sc.nextInt();
        }
        //先递增，后递减
        int start = 0;
        int left = 0;
        int right = 1;
        int ans = 0;
        while(right < len){
            //如果开始是递减的，则过滤
            while(right < len && nums[left] >= nums[right]){
                right++;
                left++;
            }
            //如果走到了终点，输出结果
            if(right == len){
                System.out.println(ans);
                break;
            }
            //没到终点，则left到right是递增的，right最终会跨过顶峰
            while(right < len && nums[right] > nums[left]){
                right++;
            }
            //如果走到了终点，输出结果
            if(right == len){
                System.out.println(ans);
                break;
            }
            start = left;
            left = right - 1;
            while(right < len && nums[right] < nums[left]){
                right++;
            }
            ans = Math.max(ans, right - start);
        }
        System.out.println(ans);
    }
}
*/
public class PDD_01 {
    public static void main(String[] args) {
        //向两边扩展
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = sc.nextInt();
        }
        int[] left = new int[len];
        int[] right = new int[len];
        for(int i = 1; i < len; i++){
            //左侧的递增序列长度
            if(nums[i] > nums[i-1]){
                left[i] = left[i-1] + 1;
            }
        }
        for(int i = len - 2; i > -1; i--){
            if(nums[i] > nums[i+1]){
                right[i] = right[i+1] + 1;
            }
        }
        int ans = 0;
        for(int i = 1; i< len - 1; i++){
            if(left[i] > 0 && right[i] > 0){
                ans = Math.max(ans, left[i] + right[i] + 1);
            }

        }
        System.out.println(ans);
    }
}