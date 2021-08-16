package LeetCode;

public class Problem_402 {
    public static void main(String[] args) {
        Solution s = new Problem_402().new Solution();
        System.out.println( s.removeKdigits("112",1));
    }
    class Solution {
        public String removeKdigits(String num, int k) {
            //如果可以让位数减少（前k+i位有i个0），优先把0前的数字清了
            //如果前k+1位没有0，说明位数是固定的n-k，那么尽量让高位数字小
            //找到前k+1位最小的数字最靠左的位置j，此时需要删除j个数字，剩余k-j，再从j的右侧开始，找到k-j-1中的最小数字
            if(k>=num.length()){
                return "0";
            }
            //找0
            int p=0;
            int count=0;
            //只要遇到0就能一直增大区间[0, k+count]
            while(p<=k+count && p<num.length()){
                if(num.charAt(p)=='0'){
                    count++;
                }
                p++;
            }
            if(count!=0){
                if(k+count>=num.length()){
                    return "0";
                }
                return num.substring(k+count, num.length());
            }
            //没有0
            int start=0;
            //从1开始，找到前k+i个位置有count个1，删掉最右1左边的其他数（j个），然后从1后面开始找2，直到k=0
            for(int i=1;i<10;i++){
                //对1到9，分别找可保留的数字
                //i的数目
                int c=0;
                int idx = 0;
                for(int j=0;j<k+c && j < num.length();j++){
                    if(num.charAt(j)==(char) i+'0'){
                        c++;
                        idx=j;
                    }
                }
                //循环结束后，在idx及idx左侧，找到了c个i，删除的个数为delete= idx-start-c, k-=delete
                //start = idx+1;
                int delete = idx - start - c;
                k -= delete;
                start = idx + 1;
            }






            int remain= 0;
            while(k>0){
                //找前k+1个数里的最小值，最靠左的坐标
                char min = 65535;
                int index = 0;
                for(int i=remain;i<remain+k+1 && i<num.length();i++){
                    if(num.charAt(i) < min){
                        min = num.charAt(i);
                        index = i;
                    }
                }
                //删除的字符数为index-start(不含index)
                k = k - (index-remain);
                //删除左侧

                num = num.substring(0, remain)+num.substring(index, num.length());
                //每次循环保留的数，第一轮是0个，结束时是一个
                remain++;
            }
            return num;
        }
    }
}
