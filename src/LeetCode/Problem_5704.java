package LeetCode;

public class Problem_5704 {
    public static void main(String[] args) {
        Solution s= new Problem_5704().new Solution();
        s.maximumScore(new int[]{6569,9667,3148,7698,1622,2194,793,9041,1670,1872}, 5);
    }
    class Solution {
        public int maximumScore(int[] nums, int k) {
            //包含端点k

            //当前最大分数
            int maxScore = nums[k];
            //所有分数
            int len = nums.length;

            int[] lMin = new int[len];
            lMin[k] = nums[k];
            int[] rMin = new int[len];
            rMin[k] = nums[k];
            for(int i = k + 1; i < len; i++){
                rMin[i] = Math.min(rMin[i - 1], nums[i]);
            }
            for(int i = k - 1; i > -1; i--){
                lMin[i] = Math.min(lMin[i+1], nums[i]);
            }
            int left = k;
            int right = k;
            int ans = nums[k];
            while(left >=0 && right < len){
                if(lMin[left] >= rMin[right] && left > 0){
                    left--;
                    ans = Math.max(ans, (right - left + 1) * Math.min(rMin[right], lMin[left]));
                }else if(lMin[left] < rMin[right] && right < len - 1){
                    right++;
                    ans = Math.max(ans, (right - left + 1) * Math.min(rMin[right], lMin[left]));
                }else {
                    break;
                }
            }
            return  ans;
            //区间内的最小值
//            int leftMin = nums[k];
//            for(int i = k; i > -1; i--){
//                leftMin = Math.min(leftMin, nums[i]);
//                int min = leftMin;
//                for(int j = k; j <len; j++){
//                    min = Math.min(min, nums[j]);
//                    maxScore = Math.max(maxScore, min*(j - i + 1));
//                }
//
//            }
//            return maxScore;
        }
    }
}
