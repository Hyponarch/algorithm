package interview;

import java.util.*;

public class Mhy_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();   //组数
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();   //数组长度
            int[] nums = new int[n];
            for(int j = 0; j < n; j++){
                nums[j] = sc.nextInt();
            }
            boolean exist = false;

            Deque<Integer> candidate = new LinkedList<>();
            candidate.add(nums[0]);
            int min = Integer.MAX_VALUE;
            for(int j = n - 2; j >= 0; j--){
                if(nums[j] > min){
                    exist =true;
                    break;
                }
                while(!candidate.isEmpty() && nums[j] > candidate.peek()){
                    min = candidate.pop();
                }
                if(nums[j] < min){
                    candidate.push(nums[j]);
                }
            }



            //大小关系为312
            //维护左侧最大值
//            int leftMax = nums[0];
//            //用TreeMap维护右侧元素
//            TreeMap<Integer, Integer> right = new TreeMap<>();
//            for(int j = 2; j < n; j++){
//                int count = right.getOrDefault(nums[j], 0);
//                right.put(nums[j], count+1);
//            }
//            for(int j = 1; j < n - 2; j++){
//                //遍历最大值，以nums[j]作为最大值，则从右往左找比nums[j]小的
//                //满足31
//                if(nums[j] < leftMax){
//                    //找到小于等于3 - 1的最大值，也就是2
//                    Integer next = right.floorKey(leftMax - 1);
//                    if(next!=null && next > nums[j]){
//                        exist = true;
//                        break;
//                    }
//                }
//            }
            if(exist){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }

    }
}
