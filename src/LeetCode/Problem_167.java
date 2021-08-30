package LeetCode;

import java.util.Arrays;

public class Problem_167 {
    public static void main(String[] args) {
        Solution s = new Problem_167().new Solution();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int len = numbers.length;
            int left = 0;
            int right = len - 1;
            while (left < right){
                int sum = numbers[left] + numbers[right];
                if(sum == target){
                    return new int[]{left + 1, right + 1};
                }else if(sum < target){
                    left++;
                }else {
                    right--;
                }
            }
            return new int[0];
        }

        //暴力解法
        public int[] twoSum1(int[] numbers, int target) {
            int len = numbers.length;
            //两重循环找符合条件的结果
            for(int i = 0; i < len; i++){
                for (int j = i + 1; j < len; j++){
                    if(numbers[i] + numbers[j] == target){
                        return new int[]{i, j};
                    }
                }
            }
            return new int[0];
        }

        //暴力解法，剪枝
        public int[] twoSum2(int[] numbers, int target) {
            int len = numbers.length;
            for(int i = 0; i < len; i++){
                for (int j = i + 1; j < len; j++){
                    if(numbers[i] + numbers[j] == target){
                        return new int[]{i, j};
                    }else if(numbers[i] + numbers[j] > target){ //如果当前两数之和大于target，则j不应该继续增加
                        break;
                    }
                }
            }
            return new int[0];
        }

        //暴力解法的改进2
        public int[] twoSum3(int[] numbers, int target) {
            int len = numbers.length;
            for(int i = 0; i < len; i++){
                for (int j = len - 1; j > i; j--){  //
                    if(numbers[i] + numbers[j] == target){
                        return new int[]{i, j};
                    }else if(numbers[i] + numbers[j] > target){
                        break;  //
                    }
                }
            }
            return new int[0];
        }
    }
}
