package LeetCode;

public class Problem_1004 {
    public static void main(String[] args) {
        Solution s = new Problem_1004().new Solution();
        System.out.println(s.longestOnes(new int[]{0,0,1,1,0,
                0,1,1,1,0,
                1,1,0,0,0,
                1,1,1,1}, 3));
//        [1,1,1,0,0,0,1,1,1,1,0]
//        2
        System.out.println(s.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }

    class Solution {
        public int longestOnes(int[] A, int K) {


            int l = 0;
            int r = 0;
            int count = K;
            int max = K;

            while (r < A.length){
                while (r < A.length && count > 0){
                    if(A[r] == 0){
                        count--;
                    }
                    r++;
                }
                while (r < A.length && A[r] == 1){
                    r++;
                }
                //r走到0或者结尾后一格，都一样
                max = Math.max(max, r - l);

                while (l < A.length && A[l] == 1){
                    l++;
                }
                //走到0或者结尾后一格, 越过这个0
                if(l < A.length){
                    l++;
                    count++;
                }
            }
            return max;




   /*
            //从每个点出发，向右扩展，最多把k个0变成1，计算总长，比较最大值
            //然后左指针向右移动直到跨过第一个0，右指针右移直到结束或增加一个0（必然增加，除非之前已经到结尾了）
            int left = 0;
            int right = 0;
            int count = K;
            int max = K;
            while (count >= 0 && right < A.length){
                if(A[right] == 0){
                    if(count == 0){
                        right--;
                        break;
                    }
                    count--;
                }
                right++;
            }
            //int len = right == A.length ? 1 : 0;
            max = Math.max(right - left + 1, max);

            while(left + max < A.length && right < A.length){
                //左指针右移，过滤掉连续的1
                while(left + max < A.length && A[left] == 1){
                    left++;
                }
                if(A[left] == 0){
                    count++;
                    //max大于等于K, 所以一定不会走到结尾
                    left++;
                }else{
                    break;
                }

                //while(A[left] == 0), 可能导致不够长
                //循环有2种结束可能，一种是right走到了0，一种是达到了结尾且为1，前者长度需要减少1
                while(right < A.length && count >= 0){

                    if(A[right] == 0){
                        if(count == 0){
                            //right--;
                            break;
                        }
                        count--;
                    }
                    right++;
                }
                int len = right - left + 1;// - (right < A.length && A[right] == 0 ? 1 : 0);
                max = Math.max(max, len);
                right++;

            }
            return max;

    */
        }


    }
}
