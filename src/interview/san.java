package interview;

import java.util.*;

public class san {
    //字符串，数字符号字母，删除符号，字母左边数字右边，字母有序，数字有序

    /**
     * 删除符号
     * @param str
     * @return
     */
    String deleteSign(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(isAlphaBeta(c) || isDigit(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 字母左边数字右边
     * @param str
     * @return
     */
//    String abl(String str){
//
//    }
//    String countSort(String str){
//        Map<Character, Integer> freq = new HashMap<>();
//        for(int i = 0; i < str.length(); i++){
//            char c = str.charAt(i);
//            if(isDigit(c) || isAlphaBeta(c)){
//                int f = freq.getOrDefault(c, 0);
//                freq.put(c, f + 1);
//            }
//        }
//        StringBuilder ans = new StringBuilder();
//        for(int i = 0; i < 26; i++){
//            int num = freq.getOrDefault((char)('a' + i), 0);
//            for(int j = 0; j < num; j++){
//                ans.append()
//            }
//        }
//    }
    boolean isAlphaBeta(char c){
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
    boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
}
