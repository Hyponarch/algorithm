package LeetCode;

public class Problem_5773 {
    class Solution {
        public String maxValue(String n, int x) {
            StringBuilder sb = new StringBuilder();
            //判断正负
            if(n.charAt(0) == '-'){
                //找到第一个大于x的数字，插在前面
                for(int i = 1; i < n.length(); i++){
                    if(n.charAt(i) - '0' > x){
                        sb.append(n, 0, i);
                        sb.append(x);
                        sb.append(n.substring(i));
                        break;
                    }
                }
            }else {
                //找到第一个小于等于x的数字，插在它前面
                for(int i = 0; i < n.length(); i++){
                    if(n.charAt(i) - '0' <= x){
                        sb.append(n, 0, i);
                        sb.append(x);
                        sb.append(n.substring(i));
                        break;
                    }
                }
            }
            if(sb.length() == 0){
                sb.append(n).append(x);
            }
            return sb.toString();
        }
    }
}
