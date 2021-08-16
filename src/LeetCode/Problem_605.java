package LeetCode;

public class Problem_605 {
    public static void main(String[] args) {
        Problem_605 p = new Problem_605();
        Solution s = p.new Solution();
        s.canPlaceFlowers(new int[]{1,0,0,0,0,0,1}, 2);
    }
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int count = n;
            for(int i=0;i<flowerbed.length;i++){
                if(flowerbed[i] == 0 && (i==0 || flowerbed[i-1]==0) && (i==n-1 || flowerbed[i+1]==0)){
                    flowerbed[i]=1;
                    count--;
                    if(count==0){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
