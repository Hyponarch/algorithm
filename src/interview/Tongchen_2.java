package interview;

public class Tongchen_2 {
    public class Solution {
        /**
         *
         * @param a int整型一维数组 店铺1的价格列表
         * @param b int整型一维数组 店铺2的价格列表
         * @return int整型一维数组
         */
        public int[] mergePrice (int[] a, int[] b) {
            // write code here
            int p1 = 0;
            int p2 = 0;
            int[] ans = new int[a.length + b.length];
            while(p1 < a.length || p2 < b.length){
                if(p1 == a.length){
                    while(p2 < b.length){
                        ans[p1+p2] = b[p2++];
                    }
                    break;
                }else if(p2 == b.length){
                    while(p1 < a.length){
                        ans[p1+p2] = a[p1++];
                    }
                }else {
                    if(a[p1] <= b[p2]){
                        ans[p1+p2] = a[p1++];
                    }else {
                        ans[p1+p2] = b[p2++];
                    }
                }
            }
            return ans;
        }
    }
}
