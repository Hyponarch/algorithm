package LeetCode;

public class Problem_413 {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            //长度为n的等差数列，n > 3，则长度为n-1的连续子数组也是等差数列，共2个，n-2共3个,n-3共4个...3共n-2个
            //还有不连续的，讨论有点复杂 X
            //n^3遍历？ X
            //子数组 是数组中的一个连续序列。
            //求等差子数组的长度n，则合计有(1+n-2)*(n-2)/2个子数组
            //然后从最后一个元素继续向后遍历
            int count = 0;
            int n = nums.length;

            for(int i = 0; i < n - 2; i++){
                int diff = nums[i+1] - nums[i];
                if(nums[i+2] != nums[i+1] + diff){
                    continue;
                }

            }
            int start = 0;
            while (start < n - 2){
                int diff = nums[start+1] - nums[start];
                int end = start + 2;
                while (end < n && nums[end] == nums[end-1] + diff){
                    end++;
                }
                //end会多走一位，所以计算长度时-1
                int length = end - start;
                if(length >= 3){
                    count += (length - 1) * (length -2) / 2;
                }
                //end - 1为验证的最后一位
                start = end - 1;
            }



//            for(int i = 0; i < n; i++){
//                for(int j = i + 1; j < n; j++){
//                    int diff = nums[j] - nums[i];
//                    int curr = nums[j];
//                    int len = 2;
//                    for(int k = j + 1; k < n; k++){
//                        if(nums[k] == curr + diff){
//                            curr = nums[k];
//                            len++;
//                            if(len >= 3){
//                                count++;
//                            }
//                        }
//                    }
//
//                }
//            }
            return count;
        }
    }
}
