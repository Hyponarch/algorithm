package interview;

import java.util.*;

public class Mhy_3 {
    public static void main(String[] args) {
        //当每个节点最多仅有一个孩子时，是唯一的，因为有2个孩子时，这2个孩子的顺序必然可以交换
        Scanner sc = new Scanner(System.in);
        //要求每个节点后的所有数，均大于他或者均小于他
        //从右往左找最大值与最小值
        int t = sc.nextInt();    //数据组数
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();   //序列中的元素个数
            int[] nums = new int[n];
            for(int j = 0; j < n; j++){
                nums[j] = sc.nextInt();
            }
            int[] max = new int[n];
            int[] min = new int[n];
            max[n-1] = Integer.MIN_VALUE;
            min[n-1] = Integer.MAX_VALUE;
            for(int j = n - 2; j >= 0; j--){
                max[j] = Math.max(nums[j+1], max[j+1]);
                min[j] = Math.min(nums[j+1], min[j+1]);
            }
            boolean isTrue = true;
            for(int j = 0; j < n; j++){
                //如果他比右侧所有数都要大nums[i] > max[i]，或者比右侧所有数都要小nums[i] < min[i]，则合理
                if(nums[i] > max[i] || nums[i] < min[i]){
                    continue;
                }
                isTrue = false;
                break;

            }
            if(isTrue){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }
}
